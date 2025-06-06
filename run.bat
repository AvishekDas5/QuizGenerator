@echo off
echo Starting Quiz Generator...
cd /d "%~dp0"

REM Set UTF-8 encoding for emoji support
chcp 65001 >nul

echo Building project...
call mvn clean package

echo Checking for JAR file...
if exist "target\quiz-generator-1.0.0.jar" (
    echo JAR file found. Starting application...
    java -jar target\quiz-generator-1.0.0.jar
) else (
    echo ERROR: JAR file not found!
    dir target\
)

pause
