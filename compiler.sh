reset
cd ~/Desktop/simulation
javac src/**/*.java
echo Compiled...
cd ~/Desktop/eco/src
java simulation/Main
cd ~/Desktop/simulation/src/simulation
rm -f *.class