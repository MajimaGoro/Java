rem javac -encoding UTF-8 -classpath ./lib/jaudiotagger-2.2.6-SNAPSHOT.jar SoundLength.java
rem pause
rem java -classpath ./lib/jaudiotagger-2.2.6-SNAPSHOT.jar SoundLength
rem pause
rem cmd
rem MP3文件路径
set dirPath="E:\\Code\\Java\\SoundLength\\sound\\"
rem lua路径
set luaPath="E:\\Code\\Java\\SoundLength\\SoundLength.lua"
rem 忽略路径
set subPath="E:\\Code\\Java\\SoundLength\\"
javac -encoding UTF-8 SoundLength.java
pause
java SoundLength %dirPath% %luaPath% %subPath%
pause
cmd