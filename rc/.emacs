;;起動画面を消す
(setq inhibit-startup-message t)
;;バックアップファイルをｇ作らない
(setq make-backup-files nil)
(setq delete-auto-save-files t)
(setq backup-inhibited t)
;;対応するかっこを光らせる
(show-paren-mode t)
;;行・列数を表示
(line-number-mode 1)
(column-number-mode 1)
;;マウスホイールを有効に
(mouse-wheel-mode t)
(setq mouse-wheel-follow-mouse t)
;;ispellを有効に
;(add-to-list 'exec-path "C:/Program Files (x86)/Aspell/bin")
;(setq-default ispell-program-name "aspell")
;;ビープ音を消去
(setq visible-bell t)
(setq highlight-nonselected-windows t)
(global-set-key "\C-z" 'undo)
(auto-compression-mode t)
;C-hでバックスペース
(global-set-key "\C-h" 'delete-backward-char)
;M-C-vで1画面前に
(global-set-key (kbd "M-C-v") 'scroll-down)
;C-V(大文字)で本来ならバインドしたいけどXを立ち上げてないと使えない
(global-set-key (kbd "C-S-V") 'scroll-down)
;C-c /で選択regionのコメントアウト
(global-set-key (kbd "C-c /") 'comment-region)
;C-c ?で選択regionのコメント解除
(global-set-key (kbd "C-c ?") 'uncomment-region)

;;日本語設定
;(set-language-environment "Japanese")
;(set-default-coding-systems 'euc-japan)
;(set-terminal-coding-system 'euc-japan)
;(set-default-coding-systems 'sjis)
;(set-terminal-coding-system 'sjis)
;;起動サイズ
(setq initial-frame-alist
      (append (list
	       '(width . 100)
	       '(height . 35)
	       )
	      initial-frame-alist))
(setq default-frame-alist initial-frame-alist)
;スペルチェック
(setq ispell-program-name "aspell")
;C-x pでC-x oの逆
(global-set-key "\C-xp" (lambda () (interactive) (other-window -1)))


;文字の色を設定
;(add-to-list 'default-frame-alist '(foreground-color . "Limegreen"))
;背景色の設定
;(add-to-list 'default-frame-alist '(background-color . "black"))
;カーソルの色の設定
(add-to-list 'default-frame-alist '(cursor-color . "Limegreen"))
;モードラインの文字色設定
;(set-face-foreground 'modeline "lightgreen")
;モードラインの背景色設定
;(set-face-background 'modeline "black")
;;php-mode
;; (setq auto-mode-alist
;;   (cons '("\\.php\\w?" . php-mode) auto-mode-alist))
;; (autoload 'php-mode "php-mode" "PHP mode." t)
;; (add-hook 'php-mode-user-hook
;; '(lambda ()
;;    (setq tab-width 4)
;;    (setq indent-tabs-mode nil))
;; )
;; ;; turn on font-lock mode
;; (when (fboundp 'global-font-lock-mode)
;; (global-font-lock-mode t))
;; ;; bibtex mode ?
;; (setq bibtex-user-optional-fields
;;  '(("annote" "Personal annotation (ignored)")
;;  ("yomi" "Yomigana")
;;  ("location" "where it is (ignored)")
;;  ("memo" "Memorundum (ignored)")
;; ))

;; ;;(modify-frame-parameters nil '((wait-for-wm . nil)))

;; (add-to-list 'load-path "~/.emacs.d/")
;; (require 'web-mode) 
;; (add-to-list 'auto-mode-alist '("\\.phtml\\'" . web-mode))
;; (add-to-list 'auto-mode-alist '("\\.tpl\\.php\\'" . web-mode)) 
;; (add-to-list 'auto-mode-alist '("\\.jsp\\'" . web-mode)) 
;; (add-to-list 'auto-mode-alist '("\\.as[cp]x\\'" . web-mode)) 
;; (add-to-list 'auto-mode-alist '("\\.erb\\'" . web-mode)) 
;; (add-to-list 'auto-mode-alist '("\\.mustache\\'" . web-mode)) 
;; (add-to-list 'auto-mode-alist '("\\.djhtml\\'" . web-mode))
;; ;;lisp-mode
;; (setq inferior-lisp-program "sbcl")
;; (put 'upcase-region 'disabled nil)

;; ;;ruby-mode
;; (add-to-list 'load-path "~/.emacs.d/ruby/")
;; (require 'ruby-mode)
;; (add-to-list 'auto-mode-alist '("\\.rb$" . ruby-mode))
;; (require 'ruby-electric)
;; (add-hook 'ruby-mode-hook '(lambda () (ruby-electric-mode t)))
;; (setq ruby-electric-expand-delimiters-list nil)
;; (require 'ruby-block)
;; (ruby-block-mode t)
;; (setq ruby-block-highlight-toggle t)
;; (require 'smart-compile)
;; (define-key ruby-mode-map (kbd "C-c c") 'smart-compile)
;; (define-key ruby-mode-map (kbd "C-c C-c") (kbd "C-c c C-m"))
;; (define-key ruby-mode-map (kbd "C-c C-c") (kbd "C-c c C-m"))
;; (defun ruby-mode-set-encoding () ())
