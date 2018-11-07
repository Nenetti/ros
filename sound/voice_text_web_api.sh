#!/bin/bash

cd $(cd $(dirname $0); pwd)
rm voice.wav > /dev/null 2>&1

TEXT=$*

curl "https://api.voicetext.jp/v1/tts" \
     -o "voice.wav" \
     -u "n6lz1e96uwetsyn4:" \
     -d "text=$TEXT" \
     -d "speaker=hikari" \
     -d "emotion=happiness" \
     -d "emotion_level=2" \
     -d "pitch=105" \
     -d "speed=105"

if [[ -f voice.wav ]]; then
  aplay voice.wav
else
  aplay Error_Network.wav
fi
