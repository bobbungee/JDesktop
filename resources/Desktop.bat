@ECHO OFF

SET DESKTOP="%APPDATA%\Microsoft\Internet Explorer"

java -jar JDesktop.jar

IF NOT EXIST "Desktop.htt" goto Error
IF EXIST "bin" rmdir /s /q bin
mkdir bin

move "Desktop.htt" bin

explorer "%CD%\bin"
explorer %DESKTOP%

msg * "Move Desktop.htt to the folder that popped up"

goto :eof 

:Error
echo Error

:End
pause