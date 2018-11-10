#! /bin/sh

WS=$(cd $(dirname $0); pwd)

iconv -f utf-8 -t eucjp ${WS}/$1.yomi | perl ${WS}/yomi2voca.pl > ${WS}/$1.dic
