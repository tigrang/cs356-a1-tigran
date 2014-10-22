#!/bin/bash
mkdir -p bin
cd bin
find ../src -name "*.java" > sources.txt
javac -d . @sources.txt && java $1
