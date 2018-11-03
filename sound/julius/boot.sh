#! /bin/sh
cd $(cd $(dirname $0); pwd)
JCONF=$1
PORT=$2
./julius -C $JCONF -C am-gmm.jconf -module $PORT
