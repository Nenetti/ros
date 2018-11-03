#! /bin/sh
#echo "$*"
DIR=$(cd $(dirname $0); pwd)
ow=voice.wav
pico2wave -w=$DIR/$ow "$*"
