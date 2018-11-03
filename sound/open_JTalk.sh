#! /bin/sh

DIR=$(cd $(dirname $0); pwd)
DIC=open_JTalk/dictionary/UTF-8
HTS=open_JTalk/voices/mei/mei_normal.htsvoice
a=0.5
b=0.3
r=1
fm=2.5
jm=1
jf=3
ow=voice.wav
ot=voice.txt

echo $* > $DIR/$ot

open_jtalk -x $DIR/$DIC -m $DIR/$HTS -a $a -b $b -r $r -fm $fm -jm $jm -jf $jf -ow $DIR/$ow $DIR/$ot
