echo off
rem MP3文件路径
set dirPath=E:\avg\game_5th_cn\trunk\br_cn_client\Documents\sound\
rem lua路径
set luaPath=E:\Algorithms\Java\SoundLength\SoundLength.lua
rem 忽略路径
set subPath=E:\avg\game_5th_cn\trunk\br_cn_client\Documents\
java -jar SoundLength.jar %dirPath% %luaPath% %subPath%
pause
cmd