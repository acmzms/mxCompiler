set -e
cd "$(dirname "$0")"
export CCHK="java -classpath ./com/antlr-4.7.2-complete.jar:./bin com.Main"
$CCHK
