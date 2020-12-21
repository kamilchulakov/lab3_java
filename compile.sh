rm -rf classes releases
mkdir classes
mkdir releases
cd source
javac -d ../classes *.java
cd ../classes
jar -cvfm ../releases/v1.0.jar ../manifest.txt *.class
