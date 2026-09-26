#!/bin/sh
# Builds lab1.jar inside a Docker JDK container (no local JVM required).
# Bytecode targets Java 8, so the jar runs on any JRE >= 8 (e.g. on helios).
set -e
cd "$(dirname "$0")"
docker run --rm -v "$PWD":/work -w /work eclipse-temurin:21-jdk sh -c '
  rm -rf out lab1.jar &&
  mkdir -p out &&
  javac --release 8 -Xlint:-options -encoding UTF-8 -d out src/Lab1.java &&
  jar --create --file lab1.jar --main-class Lab1 -C out .
'
echo "Built lab1.jar"
