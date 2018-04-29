import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.PrintWriter;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.TimeUnit;
import java.util.stream.Collectors;

public class PkgPrvBld {

	public static void main(String[] args) {
		final String className = "JavaCpp";
		final String targetSrcPath = "src";
		final String packagePath = "org/bytedeco/javacpp";
		final String jdkBinPath = "C:\\Program Files\\Java\\jdk1.8.0_144\\bin\\";
		final String classPath = "libs/*";
		try {
			Files.createDirectories(Paths.get(packagePath));
			ArrayList<String> importList = new ArrayList<>();
			ArrayList<String> codeList = new ArrayList<>();
			// className.java
			findAllFile(targetSrcPath).stream()
			.filter(e -> e.getAbsolutePath().endsWith(".java"))
			.forEach(e -> {
				try {
					getImportList(e.getAbsolutePath()).stream().forEach(s -> {
						if (!importList.stream().filter(i -> i.equals(s)).findFirst().isPresent()) importList.add(s);
					});
					getCode(e.getAbsolutePath()).stream().forEach(s -> {
						if (s.startsWith("public class "+className)) 	codeList.add(s);
						else if (s.startsWith("public static ")) codeList.add(s.replace("public ", " "));
						else if (s.startsWith("public class") || s.startsWith("public interface ")) codeList.add(s.replace("public ", " "));
						else if (s.matches(".*//.*") && !s.matches(".*\".*//.*\".*")) codeList.add(s.substring(0,s.lastIndexOf("//")));
						else if (!s.endsWith(";") && !s.endsWith("}") && !s.endsWith("{")) codeList.add(s+" ");
						else codeList.add(s);
					});
				} catch (IOException e1) {
					e1.printStackTrace();
				}
			});
			// create className.java
			final PrintWriter codePw = new PrintWriter(new File(packagePath+"/"+className+".java"), "UTF-8");
			codePw.print("package "+(packagePath.replaceAll("/", "."))+";");
			importList.stream().forEach(e -> codePw.print(e));
			codeList.stream().forEach(e -> codePw.print(e));
			codePw.flush();
			codePw.close();
			// create log4j2.xml
			final File xmlFile = new File("log4j2.xml");
			makeLog4j2Xml(xmlFile);
			// javac
			Process process = Runtime.getRuntime().exec(""+
					jdkBinPath+"javac -encoding utf-8 -cp "+classPath+" "+
					packagePath+"/*.java"
					);
			process.waitFor();
			// jar
			process = Runtime.getRuntime().exec(""+
					jdkBinPath+"jar -cf "+className+".jar "+
					packagePath+"/*.class "+xmlFile.getName()
					);
			process.waitFor();
			// delete log4j2.xml
			xmlFile.delete();
			// javadoc
			deleteDirectory(Paths.get("doc").toFile());
			process = Runtime.getRuntime().exec(""+
					jdkBinPath+"javadoc -d doc -encoding utf-8 -docencoding utf-8 -cp "+classPath+" "+
					packagePath+"/*.java"
					);
			process.waitFor(5000, TimeUnit.MILLISECONDS);
			// delete working directory
			deleteDirectory(Paths.get(packagePath.substring(0,packagePath.indexOf("/")-1)).toFile());
		} catch (IOException e) {
			e.printStackTrace();
		} catch (InterruptedException e1) {
			e1.printStackTrace();
		}
	}
	
	private static void makeLog4j2Xml(File xmlFile) {
		String str = "<?xml version=\"1.0\" encoding=\"UTF-8\" ?> " + 
				"<configuration>" + 
				"	<appenders></appenders>" + 
				"	<loggers>" + 
				"		<root level=\"all\"></root>" + 
				"	</loggers>" + 
				"</configuration>" + 
				"";
		try {
			PrintWriter pw = new PrintWriter(xmlFile);
			pw.print(str);
			pw.flush();
			pw.close();
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		}
	}
	
	private static boolean deleteDirectory(File directoryToBeDeleted) {
		File[] allContents = directoryToBeDeleted.listFiles();
		if (allContents != null) {
			for (File file : allContents) {
				deleteDirectory(file);
			}
		}
		return directoryToBeDeleted.delete();
	}
	
	private static List<String> getImportList(String path) throws IOException {
		return Files.lines(Paths.get(path))
				.filter(e -> e.startsWith("import "))
				.collect(Collectors.toList());
	}
	
	private static List<String> getCode(String path) throws IOException {
		return Files.lines(Paths.get(path))
				.map(e -> e.trim())
				.filter(e -> !e.startsWith("package"))
				.filter(e -> !e.startsWith("import"))
				.filter(e -> e.length() != 0)
				.filter(e -> !e.startsWith("//"))
				.filter(e -> !e.matches("/\\*.*\\*/"))
				.collect(Collectors.toList());
	}
	
	private static List<File> findAllFile(String absolutePath) throws IOException {
	    return Files.walk(Paths.get(absolutePath))
	        .map(path -> path.toFile())
	        .filter(file -> file.isFile())
	        .filter(file -> !file.getName().startsWith(Thread.currentThread().getStackTrace()[1].getClassName()))
	        .collect(Collectors.toList());
	}

}
