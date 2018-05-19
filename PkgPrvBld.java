import java.io.*;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.TimeUnit;
import java.util.stream.Collectors;

public class PkgPrvBld {
    private static final String jdkBinPath = "C:\\Program Files\\Java\\jdk1.8.0_144\\bin\\";
    private static final String proguardLibPath = "C:\\proguard6.0.2\\lib\\";

    public static void main(String[] args) {
        build();
    }

    private static void build() {
        final String className = "JavaCpp";
        final String[] loadLibs = {"libs\\ffmpeg-3.4.1-1.4.jar", "libs\\javacpp-1.4.jar"};
        final String[] proguardKeepPrefix = {"**"};
        final String jarFileName = className + ".jar";
        final String packagePath = "org/bytedeco/javacpp";
        final boolean makeDocFlag = true;
        StringBuilder cp = new StringBuilder();
        for (String tmp : loadLibs) {
            cp.append(tmp).append(";");
        }
        cp.deleteCharAt(cp.length() - 1);
        try {
            Files.createDirectories(Paths.get(packagePath));
            ArrayList<String> importList = new ArrayList<>();
            ArrayList<String> codeList = new ArrayList<>();
            ArrayList<String> settingsList = new ArrayList<>();
            // className.java
            findAllFile("src").stream()
                    .filter(e -> e.getAbsolutePath().endsWith(".java"))
                    .forEach(e -> {
                        try {
                            getImportList(e.getAbsolutePath()).forEach(s -> {
                                if (importList.stream().noneMatch(i -> i.equals(s)))
                                    importList.add(s);
                            });
                            getCode(e.getAbsolutePath()).forEach(s -> {
                                if (s.startsWith("public class " + className)) codeList.add(s);
                                else if (s.startsWith("public class") || s.startsWith("public interface ") || s.startsWith("public abstract "))
                                    codeList.add(s.replace("public ", " "));
                                else if (s.matches(".*//.*") && !s.matches(".*\".*//.*\".*"))
                                    codeList.add(s.substring(0, s.lastIndexOf("//")));
                                else if (!s.endsWith(";") && !s.endsWith("}") && !s.endsWith("{"))
                                    codeList.add(s + " ");
                                else codeList.add(s);
                            });
                        } catch (IOException e1) {
                            e1.printStackTrace();
                        }
                    });
            // create className.java
            final PrintWriter codePw = new PrintWriter(new File(packagePath + "/" + className + ".java"), "UTF-8");
            codePw.print("package " + (packagePath.replaceAll("/", ".")) + ";");
            importList.forEach(codePw::print);
            codeList.forEach(codePw::println);
            codePw.flush();
            codePw.close();
            // javac
            ArrayList<String> ceRet = execThrowReturn("" +
                    jdkBinPath + "javac -encoding utf-8 -cp " + cp.toString() + " " +
                    packagePath + "/*.java"
            );
            ceRet.forEach(e -> System.out.println("javac: " + e));
            ceRet.clear();
            // jar
            ceRet = execThrowReturn("" +
                    jdkBinPath + "jar -cf " + jarFileName + " " +
                    packagePath + "/*.class "
            );
            ceRet.forEach(e -> System.out.println("jar: " + e));
            ceRet.clear();
            // make proguard config profile
            final File proguardConfigFile = new File("myconfig.pro");
            final PrintWriter myprocfgPw = new PrintWriter(proguardConfigFile, "UTF-8");
            myprocfgPw.print(makeProguardConfig(jarFileName, loadLibs, proguardKeepPrefix));
            myprocfgPw.flush();
            myprocfgPw.close();
            // proguard
            ceRet = execThrowReturn(
                    jdkBinPath + "java -jar " + proguardLibPath + "proguard.jar @" + proguardConfigFile.getName(),
                    5);
            ceRet.forEach(e -> System.out.println("proguard: " + e));
            ceRet.clear();
            // delete proguard config profile
            proguardConfigFile.delete();
            // javadoc
            if (makeDocFlag) {
                deleteDirectory(Paths.get("doc").toFile());
                ceRet = execThrowReturn("" +
                        jdkBinPath + "javadoc -d doc -encoding utf-8 -docencoding utf-8 -cp libs/* " +
                        packagePath + "/*.java", 10
                );
                ceRet.forEach(e -> System.out.println("javadoc: " + e));
                ceRet.clear();
            }
            // delete working directory
            deleteDirectory(Paths.get("com").toFile());
            System.out.println("--- finish ---");
        } catch (IOException | InterruptedException e) {
            e.printStackTrace();
        }
    }

    private static ArrayList<String> execThrowReturn(String com) throws IOException, InterruptedException {
        return execThrowReturn(com, -1);
    }

    private static ArrayList<String> execThrowReturn(String com, int timeoutSec) throws IOException, InterruptedException {
        String[] command = com.split(" ");
        ArrayList<String> result = new ArrayList<>();
        Runtime r = Runtime.getRuntime();
        Process process = r.exec(command);
        if (timeoutSec < 0) {
            process.waitFor();
        } else {
            process.waitFor(timeoutSec, TimeUnit.SECONDS);
        }
        System.out.println("after " + com);
        String charSet = "UTF-8";
        if (System.getProperty("os.name").toLowerCase().startsWith("windows")) {
            charSet = "MS932";
        }
        BufferedReader buffer = new BufferedReader(new InputStreamReader(process.getInputStream(), charSet));
        String line;
        while (buffer.ready() && (line = buffer.readLine()) != null) {
            result.add("io: " + line);
        }
        buffer.close();
        buffer = new BufferedReader(new InputStreamReader(process.getErrorStream(), charSet));
        while (buffer.ready() && (line = buffer.readLine()) != null) {
            int index = line.lastIndexOf(" ");
            if (index < 0) index = 0;
            result.add("error: " + line.substring(index));
        }
        buffer.close();
        return result;
    }

    private static void deleteDirectory(File directoryToBeDeleted) {
        File[] allContents = directoryToBeDeleted.listFiles();
        if (allContents != null) {
            for (File file : allContents) {
                deleteDirectory(file);
            }
        }
        directoryToBeDeleted.delete();
    }

    private static List<String> getImportList(String path) throws IOException {
        return Files.lines(Paths.get(path))
                .filter(e -> e.startsWith("import "))
                .filter(e -> !e.contains("com.nec.cl"))
                .collect(Collectors.toList());
    }

    private static List<String> getCode(String path) throws IOException {
        return Files.lines(Paths.get(path))
                .map(String::trim)
                .filter(e -> !e.startsWith("package"))
                .filter(e -> !e.startsWith("import"))
                .filter(e -> e.length() != 0)
                .filter(e -> !e.startsWith("//"))
                .collect(Collectors.toList());
    }

    private static List<File> findAllFile(String absolutePath) throws IOException {
        return Files.walk(Paths.get(absolutePath))
                .map(Path::toFile)
                .filter(File::isFile)
                .filter(file -> !file.getName().startsWith(Thread.currentThread().getStackTrace()[1].getFileName()))
                .filter(file -> !file.getName().startsWith("Main"))
                .collect(Collectors.toList());
    }

    private static String makeProguardConfig(String inputJar, String[] loadLibs, String[] proguardKeepPrefix) {
        String outputJar = inputJar.substring(0, inputJar.lastIndexOf(".")) + "p.jar";
        StringBuilder libSb = new StringBuilder();
        for (String lib : loadLibs) {
            libSb.append("-libraryjars ").append(lib).append(System.lineSeparator());
        }
        StringBuilder keepSb = new StringBuilder();
        for (String keep : proguardKeepPrefix) {
            keepSb.append("-keep public interface **").append(System.lineSeparator());
            keepSb.append(System.lineSeparator());
            keepSb.append("-keep public class **.").append(keep).append("** {").append(System.lineSeparator());
            keepSb.append(" public <fields>;").append(System.lineSeparator());
            keepSb.append(" public <methods>;").append(System.lineSeparator());
            keepSb.append("}").append(System.lineSeparator());
            keepSb.append(System.lineSeparator());
            keepSb.append("-keep,allowshrinking public interface **").append(System.lineSeparator());
            keepSb.append(System.lineSeparator());
            keepSb.append("-keep,allowshrinking public class **.").append(keep).append("** {").append(System.lineSeparator());
            keepSb.append(" public <fields>;").append(System.lineSeparator());
            keepSb.append(" public <methods>;").append(System.lineSeparator());
            keepSb.append("}").append(System.lineSeparator());
            keepSb.append(System.lineSeparator());
        }
        return
                "-injars " + inputJar + System.lineSeparator() +
                        "-outjars " + outputJar + System.lineSeparator() +
                        "" + System.lineSeparator() +
                        "-libraryjars 'C:\\Program Files\\Java\\jre1.8.0_171\\lib\\rt.jar'" + System.lineSeparator() +
                        "-libraryjars 'C:\\Program Files\\Java\\jre1.8.0_171\\lib\\jce.jar'" + System.lineSeparator() +
                        libSb.toString() +
                        "" + System.lineSeparator() +
                        "" + System.lineSeparator() +
                        "" + System.lineSeparator() +
                        "" + System.lineSeparator() +
                        keepSb.toString() +
                        "" + System.lineSeparator() +
                        "" + System.lineSeparator() +
                        "" + System.lineSeparator() +
                        "" + System.lineSeparator() +
                        "# Keep - Applications. Keep all application classes, along with their 'main' methods." + System.lineSeparator() +
                        "-keepclasseswithmembers public class * {" + System.lineSeparator() +
                        "    public static void main(java.lang.String[]);" + System.lineSeparator() +
                        "}" + System.lineSeparator() +
                        "" + System.lineSeparator() +
                        "# Also keep - Enumerations. Keep the special static methods that are required in" + System.lineSeparator() +
                        "# enumeration classes." + System.lineSeparator() +
                        "-keepclassmembers enum  * {" + System.lineSeparator() +
                        "    public static **[] values();" + System.lineSeparator() +
                        "    public static ** valueOf(java.lang.String);" + System.lineSeparator() +
                        "}" + System.lineSeparator() +
                        "" + System.lineSeparator() +
                        "# Also keep - Database drivers. Keep all implementations of java.sql.Driver." + System.lineSeparator() +
                        "-keep class * extends java.sql.Driver" + System.lineSeparator() +
                        "" + System.lineSeparator() +
                        "# Also keep - Swing UI L&F. Keep all extensions of javax.swing.plaf.ComponentUI," + System.lineSeparator() +
                        "# along with the special 'createUI' method." + System.lineSeparator() +
                        "-keep class * extends javax.swing.plaf.ComponentUI {" + System.lineSeparator() +
                        "    public static javax.swing.plaf.ComponentUI createUI(javax.swing.JComponent);" + System.lineSeparator() +
                        "}" + System.lineSeparator() +
                        "" + System.lineSeparator() +
                        "# Keep - Native method names. Keep all native class/method names." + System.lineSeparator() +
                        "-keepclasseswithmembers,includedescriptorclasses,allowshrinking class * {" + System.lineSeparator() +
                        "    native <methods>;" + System.lineSeparator() +
                        "}" + System.lineSeparator() +
                        "" + System.lineSeparator() +
                        "# Remove - System method calls. Remove all invocations of System" + System.lineSeparator() +
                        "# methods without side effects whose return values are not used." + System.lineSeparator() +
                        "-assumenosideeffects public class java.lang.System {" + System.lineSeparator() +
                        "    public static long currentTimeMillis();" + System.lineSeparator() +
                        "    static java.lang.Class getCallerClass();" + System.lineSeparator() +
                        "    public static int identityHashCode(java.lang.Object);" + System.lineSeparator() +
                        "    public static java.lang.SecurityManager getSecurityManager();" + System.lineSeparator() +
                        "    public static java.util.Properties getProperties();" + System.lineSeparator() +
                        "    public static java.lang.String getProperty(java.lang.String);" + System.lineSeparator() +
                        "    public static java.lang.String getenv(java.lang.String);" + System.lineSeparator() +
                        "    public static java.lang.String mapLibraryName(java.lang.String);" + System.lineSeparator() +
                        "    public static java.lang.String getProperty(java.lang.String,java.lang.String);" + System.lineSeparator() +
                        "}" + System.lineSeparator() +
                        "" + System.lineSeparator() +
                        "# Remove - Math method calls. Remove all invocations of Math" + System.lineSeparator() +
                        "# methods without side effects whose return values are not used." + System.lineSeparator() +
                        "-assumenosideeffects public class java.lang.Math {" + System.lineSeparator() +
                        "    public static double sin(double);" + System.lineSeparator() +
                        "    public static double cos(double);" + System.lineSeparator() +
                        "    public static double tan(double);" + System.lineSeparator() +
                        "    public static double asin(double);" + System.lineSeparator() +
                        "    public static double acos(double);" + System.lineSeparator() +
                        "    public static double atan(double);" + System.lineSeparator() +
                        "    public static double toRadians(double);" + System.lineSeparator() +
                        "    public static double toDegrees(double);" + System.lineSeparator() +
                        "    public static double exp(double);" + System.lineSeparator() +
                        "    public static double log(double);" + System.lineSeparator() +
                        "    public static double log10(double);" + System.lineSeparator() +
                        "    public static double sqrt(double);" + System.lineSeparator() +
                        "    public static double cbrt(double);" + System.lineSeparator() +
                        "    public static double IEEEremainder(double,double);" + System.lineSeparator() +
                        "    public static double ceil(double);" + System.lineSeparator() +
                        "    public static double floor(double);" + System.lineSeparator() +
                        "    public static double rint(double);" + System.lineSeparator() +
                        "    public static double atan2(double,double);" + System.lineSeparator() +
                        "    public static double pow(double,double);" + System.lineSeparator() +
                        "    public static int round(float);" + System.lineSeparator() +
                        "    public static long round(double);" + System.lineSeparator() +
                        "    public static double random();" + System.lineSeparator() +
                        "    public static int abs(int);" + System.lineSeparator() +
                        "    public static long abs(long);" + System.lineSeparator() +
                        "    public static float abs(float);" + System.lineSeparator() +
                        "    public static double abs(double);" + System.lineSeparator() +
                        "    public static int max(int,int);" + System.lineSeparator() +
                        "    public static long max(long,long);" + System.lineSeparator() +
                        "    public static float max(float,float);" + System.lineSeparator() +
                        "    public static double max(double,double);" + System.lineSeparator() +
                        "    public static int min(int,int);" + System.lineSeparator() +
                        "    public static long min(long,long);" + System.lineSeparator() +
                        "    public static float min(float,float);" + System.lineSeparator() +
                        "    public static double min(double,double);" + System.lineSeparator() +
                        "    public static double ulp(double);" + System.lineSeparator() +
                        "    public static float ulp(float);" + System.lineSeparator() +
                        "    public static double signum(double);" + System.lineSeparator() +
                        "    public static float signum(float);" + System.lineSeparator() +
                        "    public static double sinh(double);" + System.lineSeparator() +
                        "    public static double cosh(double);" + System.lineSeparator() +
                        "    public static double tanh(double);" + System.lineSeparator() +
                        "    public static double hypot(double,double);" + System.lineSeparator() +
                        "    public static double expm1(double);" + System.lineSeparator() +
                        "    public static double log1p(double);" + System.lineSeparator() +
                        "}" + System.lineSeparator() +
                        "" + System.lineSeparator() +
                        "# Remove - Number method calls. Remove all invocations of Number" + System.lineSeparator() +
                        "# methods without side effects whose return values are not used." + System.lineSeparator() +
                        "-assumenosideeffects public class java.lang.* extends java.lang.Number {" + System.lineSeparator() +
                        "    public static java.lang.String toString(byte);" + System.lineSeparator() +
                        "    public static java.lang.Byte valueOf(byte);" + System.lineSeparator() +
                        "    public static byte parseByte(java.lang.String);" + System.lineSeparator() +
                        "    public static byte parseByte(java.lang.String,int);" + System.lineSeparator() +
                        "    public static java.lang.Byte valueOf(java.lang.String,int);" + System.lineSeparator() +
                        "    public static java.lang.Byte valueOf(java.lang.String);" + System.lineSeparator() +
                        "    public static java.lang.Byte decode(java.lang.String);" + System.lineSeparator() +
                        "    public int compareTo(java.lang.Byte);" + System.lineSeparator() +
                        "    public static java.lang.String toString(short);" + System.lineSeparator() +
                        "    public static short parseShort(java.lang.String);" + System.lineSeparator() +
                        "    public static short parseShort(java.lang.String,int);" + System.lineSeparator() +
                        "    public static java.lang.Short valueOf(java.lang.String,int);" + System.lineSeparator() +
                        "    public static java.lang.Short valueOf(java.lang.String);" + System.lineSeparator() +
                        "    public static java.lang.Short valueOf(short);" + System.lineSeparator() +
                        "    public static java.lang.Short decode(java.lang.String);" + System.lineSeparator() +
                        "    public static short reverseBytes(short);" + System.lineSeparator() +
                        "    public int compareTo(java.lang.Short);" + System.lineSeparator() +
                        "    public static java.lang.String toString(int,int);" + System.lineSeparator() +
                        "    public static java.lang.String toHexString(int);" + System.lineSeparator() +
                        "    public static java.lang.String toOctalString(int);" + System.lineSeparator() +
                        "    public static java.lang.String toBinaryString(int);" + System.lineSeparator() +
                        "    public static java.lang.String toString(int);" + System.lineSeparator() +
                        "    public static int parseInt(java.lang.String,int);" + System.lineSeparator() +
                        "    public static int parseInt(java.lang.String);" + System.lineSeparator() +
                        "    public static java.lang.Integer valueOf(java.lang.String,int);" + System.lineSeparator() +
                        "    public static java.lang.Integer valueOf(java.lang.String);" + System.lineSeparator() +
                        "    public static java.lang.Integer valueOf(int);" + System.lineSeparator() +
                        "    public static java.lang.Integer getInteger(java.lang.String);" + System.lineSeparator() +
                        "    public static java.lang.Integer getInteger(java.lang.String,int);" + System.lineSeparator() +
                        "    public static java.lang.Integer getInteger(java.lang.String,java.lang.Integer);" + System.lineSeparator() +
                        "    public static java.lang.Integer decode(java.lang.String);" + System.lineSeparator() +
                        "    public static int highestOneBit(int);" + System.lineSeparator() +
                        "    public static int lowestOneBit(int);" + System.lineSeparator() +
                        "    public static int numberOfLeadingZeros(int);" + System.lineSeparator() +
                        "    public static int numberOfTrailingZeros(int);" + System.lineSeparator() +
                        "    public static int bitCount(int);" + System.lineSeparator() +
                        "    public static int rotateLeft(int,int);" + System.lineSeparator() +
                        "    public static int rotateRight(int,int);" + System.lineSeparator() +
                        "    public static int reverse(int);" + System.lineSeparator() +
                        "    public static int signum(int);" + System.lineSeparator() +
                        "    public static int reverseBytes(int);" + System.lineSeparator() +
                        "    public int compareTo(java.lang.Integer);" + System.lineSeparator() +
                        "    public static java.lang.String toString(long,int);" + System.lineSeparator() +
                        "    public static java.lang.String toHexString(long);" + System.lineSeparator() +
                        "    public static java.lang.String toOctalString(long);" + System.lineSeparator() +
                        "    public static java.lang.String toBinaryString(long);" + System.lineSeparator() +
                        "    public static java.lang.String toString(long);" + System.lineSeparator() +
                        "    public static long parseLong(java.lang.String,int);" + System.lineSeparator() +
                        "    public static long parseLong(java.lang.String);" + System.lineSeparator() +
                        "    public static java.lang.Long valueOf(java.lang.String,int);" + System.lineSeparator() +
                        "    public static java.lang.Long valueOf(java.lang.String);" + System.lineSeparator() +
                        "    public static java.lang.Long valueOf(long);" + System.lineSeparator() +
                        "    public static java.lang.Long decode(java.lang.String);" + System.lineSeparator() +
                        "    public static java.lang.Long getLong(java.lang.String);" + System.lineSeparator() +
                        "    public static java.lang.Long getLong(java.lang.String,long);" + System.lineSeparator() +
                        "    public static java.lang.Long getLong(java.lang.String,java.lang.Long);" + System.lineSeparator() +
                        "    public static long highestOneBit(long);" + System.lineSeparator() +
                        "    public static long lowestOneBit(long);" + System.lineSeparator() +
                        "    public static int numberOfLeadingZeros(long);" + System.lineSeparator() +
                        "    public static int numberOfTrailingZeros(long);" + System.lineSeparator() +
                        "    public static int bitCount(long);" + System.lineSeparator() +
                        "    public static long rotateLeft(long,int);" + System.lineSeparator() +
                        "    public static long rotateRight(long,int);" + System.lineSeparator() +
                        "    public static long reverse(long);" + System.lineSeparator() +
                        "    public static int signum(long);" + System.lineSeparator() +
                        "    public static long reverseBytes(long);" + System.lineSeparator() +
                        "    public int compareTo(java.lang.Long);" + System.lineSeparator() +
                        "    public static java.lang.String toString(float);" + System.lineSeparator() +
                        "    public static java.lang.String toHexString(float);" + System.lineSeparator() +
                        "    public static java.lang.Float valueOf(java.lang.String);" + System.lineSeparator() +
                        "    public static java.lang.Float valueOf(float);" + System.lineSeparator() +
                        "    public static float parseFloat(java.lang.String);" + System.lineSeparator() +
                        "    public static boolean isNaN(float);" + System.lineSeparator() +
                        "    public static boolean isInfinite(float);" + System.lineSeparator() +
                        "    public static int floatToIntBits(float);" + System.lineSeparator() +
                        "    public static int floatToRawIntBits(float);" + System.lineSeparator() +
                        "    public static float intBitsToFloat(int);" + System.lineSeparator() +
                        "    public static int compare(float,float);" + System.lineSeparator() +
                        "    public boolean isNaN();" + System.lineSeparator() +
                        "    public boolean isInfinite();" + System.lineSeparator() +
                        "    public int compareTo(java.lang.Float);" + System.lineSeparator() +
                        "    public static java.lang.String toString(double);" + System.lineSeparator() +
                        "    public static java.lang.String toHexString(double);" + System.lineSeparator() +
                        "    public static java.lang.Double valueOf(java.lang.String);" + System.lineSeparator() +
                        "    public static java.lang.Double valueOf(double);" + System.lineSeparator() +
                        "    public static double parseDouble(java.lang.String);" + System.lineSeparator() +
                        "    public static boolean isNaN(double);" + System.lineSeparator() +
                        "    public static boolean isInfinite(double);" + System.lineSeparator() +
                        "    public static long doubleToLongBits(double);" + System.lineSeparator() +
                        "    public static long doubleToRawLongBits(double);" + System.lineSeparator() +
                        "    public static double longBitsToDouble(long);" + System.lineSeparator() +
                        "    public static int compare(double,double);" + System.lineSeparator() +
                        "    public boolean isNaN();" + System.lineSeparator() +
                        "    public boolean isInfinite();" + System.lineSeparator() +
                        "    public int compareTo(java.lang.Double);" + System.lineSeparator() +
                        "    public byte byteValue();" + System.lineSeparator() +
                        "    public short shortValue();" + System.lineSeparator() +
                        "    public int intValue();" + System.lineSeparator() +
                        "    public long longValue();" + System.lineSeparator() +
                        "    public float floatValue();" + System.lineSeparator() +
                        "    public double doubleValue();" + System.lineSeparator() +
                        "    public int compareTo(java.lang.Object);" + System.lineSeparator() +
                        "    public boolean equals(java.lang.Object);" + System.lineSeparator() +
                        "    public int hashCode();" + System.lineSeparator() +
                        "    public java.lang.String toString();" + System.lineSeparator() +
                        "}" + System.lineSeparator() +
                        "" + System.lineSeparator() +
                        "# Remove - String method calls. Remove all invocations of String" + System.lineSeparator() +
                        "# methods without side effects whose return values are not used." + System.lineSeparator() +
                        "-assumenosideeffects public class java.lang.String {" + System.lineSeparator() +
                        "    public static java.lang.String copyValueOf(char[]);" + System.lineSeparator() +
                        "    public static java.lang.String copyValueOf(char[],int,int);" + System.lineSeparator() +
                        "    public static java.lang.String valueOf(boolean);" + System.lineSeparator() +
                        "    public static java.lang.String valueOf(char);" + System.lineSeparator() +
                        "    public static java.lang.String valueOf(char[]);" + System.lineSeparator() +
                        "    public static java.lang.String valueOf(char[],int,int);" + System.lineSeparator() +
                        "    public static java.lang.String valueOf(double);" + System.lineSeparator() +
                        "    public static java.lang.String valueOf(float);" + System.lineSeparator() +
                        "    public static java.lang.String valueOf(int);" + System.lineSeparator() +
                        "    public static java.lang.String valueOf(java.lang.Object);" + System.lineSeparator() +
                        "    public static java.lang.String valueOf(long);" + System.lineSeparator() +
                        "    public boolean contentEquals(java.lang.StringBuffer);" + System.lineSeparator() +
                        "    public boolean endsWith(java.lang.String);" + System.lineSeparator() +
                        "    public boolean equalsIgnoreCase(java.lang.String);" + System.lineSeparator() +
                        "    public boolean equals(java.lang.Object);" + System.lineSeparator() +
                        "    public boolean matches(java.lang.String);" + System.lineSeparator() +
                        "    public boolean regionMatches(boolean,int,java.lang.String,int,int);" + System.lineSeparator() +
                        "    public boolean regionMatches(int,java.lang.String,int,int);" + System.lineSeparator() +
                        "    public boolean startsWith(java.lang.String);" + System.lineSeparator() +
                        "    public boolean startsWith(java.lang.String,int);" + System.lineSeparator() +
                        "    public byte[] getBytes();" + System.lineSeparator() +
                        "    public byte[] getBytes(java.lang.String);" + System.lineSeparator() +
                        "    public char charAt(int);" + System.lineSeparator() +
                        "    public char[] toCharArray();" + System.lineSeparator() +
                        "    public int compareToIgnoreCase(java.lang.String);" + System.lineSeparator() +
                        "    public int compareTo(java.lang.Object);" + System.lineSeparator() +
                        "    public int compareTo(java.lang.String);" + System.lineSeparator() +
                        "    public int hashCode();" + System.lineSeparator() +
                        "    public int indexOf(int);" + System.lineSeparator() +
                        "    public int indexOf(int,int);" + System.lineSeparator() +
                        "    public int indexOf(java.lang.String);" + System.lineSeparator() +
                        "    public int indexOf(java.lang.String,int);" + System.lineSeparator() +
                        "    public int lastIndexOf(int);" + System.lineSeparator() +
                        "    public int lastIndexOf(int,int);" + System.lineSeparator() +
                        "    public int lastIndexOf(java.lang.String);" + System.lineSeparator() +
                        "    public int lastIndexOf(java.lang.String,int);" + System.lineSeparator() +
                        "    public int length();" + System.lineSeparator() +
                        "    public java.lang.CharSequence subSequence(int,int);" + System.lineSeparator() +
                        "    public java.lang.String concat(java.lang.String);" + System.lineSeparator() +
                        "    public java.lang.String replaceAll(java.lang.String,java.lang.String);" + System.lineSeparator() +
                        "    public java.lang.String replace(char,char);" + System.lineSeparator() +
                        "    public java.lang.String replaceFirst(java.lang.String,java.lang.String);" + System.lineSeparator() +
                        "    public java.lang.String[] split(java.lang.String);" + System.lineSeparator() +
                        "    public java.lang.String[] split(java.lang.String,int);" + System.lineSeparator() +
                        "    public java.lang.String substring(int);" + System.lineSeparator() +
                        "    public java.lang.String substring(int,int);" + System.lineSeparator() +
                        "    public java.lang.String toLowerCase();" + System.lineSeparator() +
                        "    public java.lang.String toLowerCase(java.util.Locale);" + System.lineSeparator() +
                        "    public java.lang.String toString();" + System.lineSeparator() +
                        "    public java.lang.String toUpperCase();" + System.lineSeparator() +
                        "    public java.lang.String toUpperCase(java.util.Locale);" + System.lineSeparator() +
                        "    public java.lang.String trim();" + System.lineSeparator() +
                        "}" + System.lineSeparator() +
                        "" + System.lineSeparator() +
                        "# Remove - StringBuffer method calls. Remove all invocations of StringBuffer" + System.lineSeparator() +
                        "# methods without side effects whose return values are not used." + System.lineSeparator() +
                        "-assumenosideeffects public class java.lang.StringBuffer {" + System.lineSeparator() +
                        "    public java.lang.String toString();" + System.lineSeparator() +
                        "    public char charAt(int);" + System.lineSeparator() +
                        "    public int capacity();" + System.lineSeparator() +
                        "    public int codePointAt(int);" + System.lineSeparator() +
                        "    public int codePointBefore(int);" + System.lineSeparator() +
                        "    public int indexOf(java.lang.String,int);" + System.lineSeparator() +
                        "    public int lastIndexOf(java.lang.String);" + System.lineSeparator() +
                        "    public int lastIndexOf(java.lang.String,int);" + System.lineSeparator() +
                        "    public int length();" + System.lineSeparator() +
                        "    public java.lang.String substring(int);" + System.lineSeparator() +
                        "    public java.lang.String substring(int,int);" + System.lineSeparator() +
                        "}" + System.lineSeparator() +
                        "" + System.lineSeparator() +
                        "# Remove - StringBuilder method calls. Remove all invocations of StringBuilder" + System.lineSeparator() +
                        "# methods without side effects whose return values are not used." + System.lineSeparator() +
                        "-assumenosideeffects public class java.lang.StringBuilder {" + System.lineSeparator() +
                        "    public java.lang.String toString();" + System.lineSeparator() +
                        "    public char charAt(int);" + System.lineSeparator() +
                        "    public int capacity();" + System.lineSeparator() +
                        "    public int codePointAt(int);" + System.lineSeparator() +
                        "    public int codePointBefore(int);" + System.lineSeparator() +
                        "    public int indexOf(java.lang.String,int);" + System.lineSeparator() +
                        "    public int lastIndexOf(java.lang.String);" + System.lineSeparator() +
                        "    public int lastIndexOf(java.lang.String,int);" + System.lineSeparator() +
                        "    public int length();" + System.lineSeparator() +
                        "    public java.lang.String substring(int);" + System.lineSeparator() +
                        "    public java.lang.String substring(int,int);" + System.lineSeparator() +
                        "}" + System.lineSeparator() +
                        "";
    }

}
