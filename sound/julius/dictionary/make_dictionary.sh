#! /bin/sh
iconv -f utf-8 -t eucjp $1.yomi | perl yomi2voca.pl > $1.dic
