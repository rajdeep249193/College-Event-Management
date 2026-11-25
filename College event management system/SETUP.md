# Campusly: Setup

## Local startup defaults

The app is configured to start with safe local development defaults so it works immediately in this project.

Default credentials:

    Username: admin
    Password: AdminPass123

    Username: student
    Password: StudentPass123

You can still override them at runtime with environment variables if you want stronger custom values:

PowerShell (current session):

    $env:ADMIN_PASSWORD   = "choose-a-strong-admin-password"
    $env:STUDENT_PASSWORD = "choose-a-strong-student-password"

To keep them between sessions, set them in Windows under System > Environment Variables,
or add them to the run configuration in VS Code.

## Optional

    $env:H2_CONSOLE_ENABLED = "true"   # enable the H2 console for local development only

## Running

Install JDK 25 (the current Java LTS) and Maven 3.8+ / 3.9+. In PowerShell, select JDK 25 for the current session and ensure Java and Maven are available:

    $env:JAVA_HOME = "C:\path\to\jdk-25"
    $env:Path = "$env:JAVA_HOME\bin;$env:Path"

The Maven build targets Java 25.

From the project root in PowerShell, run:

    .\start-campusly.ps1

This starts the application with the local defaults above. Open http://localhost:8081.

Events are stored in ./data/collegeevents.mv.db and persist across restarts.

## Sample data

On first start the app adds three sample events. To start with an empty calendar:

    $env:DEMO_DATA_ENABLED = "false"
