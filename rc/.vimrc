set nocompatible

" edit
"---------------
set autoindent
set smartindent
set cindent
set backspace=indent,eol,start
set clipboard=unnamed
set pastetoggle=<F12> " ペースト時にインデントを行わない
set termencoding=utf-8
set encoding=utf-8
set fileencodings=utf-8,iso-2022-jp,cp932,euc-jp

" indent
"---------------
set tabstop=4
set noexpandtab " スペースでインデントを入れない
set smarttab
set shiftwidth=4
set shiftround
set nowrap

" tab
"---------------
set showtabline=2
nnoremap <C-j> gT
nnoremap <C-k> gt

" display
"---------------
set number " 行番号表示
set ruler " ルーラー表示
set list " タブやEOLを表示
set listchars=tab:»-,trail:-,eol:↲,extends:»,precedes:«,nbsp:% " 非視覚文字表示
set title " 編集中のファイル名表示
set showmode " モード表示
set laststatus=2 " ステータス行設定
set cmdheight=2 " コマンド行設定
set statusline=%t\ %m%r[%<%{fnamemodify(getcwd(),':~')}]%=%h%w%y%{'['.(&fenc!=''?&fenc:&enc).']['.&ff.']'}[%3l,%3c,%5P]
set linespace=0
set mouse=nv " マウス設定有効
set wildmenu
set wildmode=list:longest,full
set showmatch " 対括弧の表示
set showcmd

" search
"---------------
set hlsearch
"Escの2回押しでハイライト消去
nmap <ESC><ESC> :nohlsearch<CR><ESC>

" syntax color
"---------------
syntax on
colorscheme ron
highlight Linenr ctermfg=grey
highlight StatusLine ctermfg=grey
highlight StatusLineNC ctermfg=white
