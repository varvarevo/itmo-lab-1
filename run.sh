#!/bin/sh
# Runs lab1.jar inside a Docker JRE container (no local JVM required).
cd "$(dirname "$0")"
docker run --rm -v "$PWD":/work -w /work eclipse-temurin:21-jre java -jar lab1.jar
