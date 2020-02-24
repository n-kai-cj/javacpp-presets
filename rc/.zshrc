## change prompt color
#PROMPT="%B%{[31m%}${USER}@%1~%#%{[m%}%b "
 PROMPT="%B%{[31m%}${USER}@%m %1~%#%{[m%}%b "
PROMPT2="%B%{[37m%]${USER}@%1~%#%b "

## command history
HISTFILE=$HOME/.zsh_history
HISTSIZE=1000000
SAVEHIST=1000000
## share command history with other shells
setopt share_history
## do not save duplicate command
setopt histignorealldups
setopt hist_ignore_dups
## not save history command
setopt hist_no_store
## remove extra space and record history
setopt hist_reduce_blanks

## auto command complete
autoload -U compinit
compinit
## enable reference from PROMPT variables
setopt prompt_subst
## no beep
setopt nobeep
## show list of command completion
setopt auto_list
## auto pushd when cd
setopt auto_pushd
setopt pushd_ignore_dups
setopt auto_cd
## enable edit after history search
setopt hist_verify
autoload history-search-end
## shortcut of command history search
zle -N history-beginning-search-backward-end history-search-end
zle -N history-beginning-search-forward-end history-search-end
bindkey "^P" history-beginning-search-backward-end
bindkey "^N" history-beginning-search-forward-end
## emacs key bind
bindkey -e
## reverse history search with Sift-Tab
bindkey "^[[Z" reverse-menu-complete
zstyle ':completion:*' _prefix
zstyle ':completion:*' verbose yes
## enable correct command
setopt correct
setopt list_packed
## command completion match lower and upper case
zstyle ':completion:*' matcher-list 'm:{a-z}={A-Z}'

## ls color
export LSCOLORS=exfxcxdxbxegedabagacad
#export LSCOLORS=gxfxcxdxbxegedabagacad
alias ls="ls --color=auto"
zstyle ':completion:*' list-colors $LSCOLORS

