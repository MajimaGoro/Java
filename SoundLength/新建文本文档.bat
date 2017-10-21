javac -encoding UTF-8 -classpath ./lib/jaudiotagger-2.2.6-SNAPSHOT.jar SoundLength.java
pause
java -classpath ./lib/jaudiotagger-2.2.6-SNAPSHOT.jar SoundLength
pause
jar -cvfm SoundLength.jar SoundLength.mf SoundLength.class
pause
java -jar SoundLength.jar
pause
cmd