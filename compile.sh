rm -rf classes releases
mkdir classes
mkdir releases
cd source
javac -cp project/*/* -d ../classes project/*/*.java
cd ../classes
jar -cvfm ../releases/unstable.jar ../manifest.txt project/*/*.class
