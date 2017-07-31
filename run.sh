#!/bin/bash

cwd=$(pwd);
src=$cwd/application/MainApp.java;

echo "Compiling..";

javac $src;

echo "Running..";

java application.MainApp -cp $cwd/application/
