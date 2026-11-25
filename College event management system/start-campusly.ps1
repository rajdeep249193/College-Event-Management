$ErrorActionPreference = "Stop"

$env:DB_PASSWORD = if ($env:DB_PASSWORD) { $env:DB_PASSWORD } else { "sa" }
$env:ADMIN_PASSWORD = if ($env:ADMIN_PASSWORD) { $env:ADMIN_PASSWORD } else { "AdminPass123" }
$env:STUDENT_PASSWORD = if ($env:STUDENT_PASSWORD) { $env:STUDENT_PASSWORD } else { "StudentPass123" }
$env:DEMO_DATA_ENABLED = if ($env:DEMO_DATA_ENABLED) { $env:DEMO_DATA_ENABLED } else { "true" }

$mavenPath = (Get-Command mvn -ErrorAction SilentlyContinue).Source
if (-not $mavenPath) {
    $mavenPath = "C:\Tools\apache-maven-3.9.16\bin\mvn.cmd"
}

if (-not (Test-Path $mavenPath)) {
    throw "Maven is not installed or not on PATH. Install Maven or add it to PATH before running this script."
}

Push-Location $PSScriptRoot
try {
    & $mavenPath spring-boot:run
    if ($LASTEXITCODE -ne 0) {
        throw "Maven exited with code $LASTEXITCODE."
    }
} finally {
    Pop-Location
}
