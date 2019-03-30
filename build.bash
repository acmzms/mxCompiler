set -e
cd "$(dirname "$0")"
mkdir -p bin
find ./com -name *.java | javac -d bin -classpath "com/antlr-4.7.2-complete.jar" @/dev/stdin
