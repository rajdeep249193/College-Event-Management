@echo off
setlocal
cd /d "%~dp0"

if not defined DB_PASSWORD set DB_PASSWORD=sa
if not defined ADMIN_PASSWORD set ADMIN_PASSWORD=AdminPass123
if not defined STUDENT_PASSWORD set STUDENT_PASSWORD=StudentPass123
if not defined DEMO_DATA_ENABLED set DEMO_DATA_ENABLED=true

where mvn >nul 2>nul
if errorlevel 1 (
    set "MAVEN_HOME=C:\Tools\apache-maven-3.9.16"
    if exist "%MAVEN_HOME%\bin\mvn.cmd" (
        set "PATH=%MAVEN_HOME%\bin;%PATH%"
    ) else (
        echo Maven is not installed or not found on PATH.
        echo Please install Maven or add it to PATH before running this app.
        exit /b 1
    )
)

mvn spring-boot:run
