rm -rf classes releases
mkdir classes
mkdir releases
cd source
javac -d ../classes *.java
cd ../classes
jar -cvfm ../releases/v1.1.jar ../manifest.txt *.class
