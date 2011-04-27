@echo off

SET cc=javac
SET jar=jar

SET out=bin
SET res=resources
SET dir=%CD%
SET versionfile=%res%\version.txt
FOR /F %%G IN (%versionfile%) DO SET version=%%G
SET dist=JDesktop-%version%

:Build
call :Compile
call :Package
call :Copy
call :Clean
goto :eof

:Compile
cd src
if exist "%dir%\%out%" rmdir "%dir%\%out%" /s /q
mkdir "%dir%\%out%" 
%cc% -d "%dir%\%out%" com/jdesktop/*.java
cd "%dir%"
goto :eof

:Package
if not exist "%dir%\%out%" goto Error
if exist "%dir%\%dist%" rmdir "%dir%\%dist%" /s /q
mkdir "%dir%\%dist%"
copy "%res%\Manifest.txt" "temp.txt"
echo Specification-Version: "%version%" >> "temp.txt"
echo Implementation-Version: "%version%" >> "temp.txt"
%jar% cfm "%dir%\%dist%\JDesktop.jar" "temp.txt" -C %out%/ .
del "temp.txt"
goto :eof

:Copy
copy "%res%\*.bat" "%dir%\%dist%"
copy "desktop.ini" "%dir%\%dist%"
goto :eof

:Clean
if exist "%dir%\%out%" rmdir "%dir%\%out%" /s /q
goto :eof

:Error
echo Error building
goto :eof

pause