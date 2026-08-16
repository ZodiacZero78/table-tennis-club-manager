# Troubleshooting

A record of significant development and infrastructure issues encountered
during the project and how they were resolved.

---

## 1. Spring Boot Failed to Configure DataSource

### Problem

The application failed to start with:

`Failed to configure a DataSource: 'url' attribute is not specified and no embedded datasource could be configured.`

### Cause

The database configuration had been placed in the `target` directory's
`application.properties` instead of:

`src/main/resources/application.properties`

The `target` directory contains generated build output and should not be
used for application configuration.

### Solution

Moved the database configuration to:

`src/main/resources/application.properties`

### Lesson

Application source/configuration belongs under `src/main`, while `target/`
contains generated build artifacts.

---

## 2. Docker Compose Could Not Find Configuration File

### Problem

Running:

`docker compose up -d`

returned:

`no configuration file provided: not found`

### Cause

The command was being run from the wrong directory because the project
contained a nested `table-tennis-club-manager` folder.

### Solution

Moved the project files so that the project structure was:

`table-tennis-club-manager/`
`├── docker-compose.yml`
`├── pom.xml`
`└── src/`

Then ran Docker Compose from the project root.

### Lesson

Docker Compose looks for its configuration file in the current directory
unless another file/path is explicitly specified.

---

## 3. Docker Could Not Connect to Docker Desktop

### Problem

Docker returned an error similar to:

`unable to get image 'postgres:17': error during connect: open //./pipe/dockerDesktopLinuxEngine: The system cannot find the file specified.`

### Cause

Docker Desktop's Linux engine was not running.

### Solution

Started Docker Desktop and waited for the Docker engine to become available.

### Lesson

Docker commands require the Docker engine to be running, not just the
Docker CLI being installed.

---

## 4. Java Version Mismatch

### Problem

The terminal continued reporting Java 17 after installing Java 21.

### Cause

The system PATH and/or running applications were still using the existing
Java 17 installation.

### Solution

Updated the Java 21 PATH configuration and restarted IntelliJ so it picked up
the updated environment.

### Lesson

Changes to environment variables may not be picked up by applications that
were already running.

---

## 5. Maven Wrapper Permission Denied in CI

### Problem

GitHub Actions failed with:

`./mvnw: Permission denied`

### Cause

The Linux GitHub Actions runner requires `mvnw` to have executable
permissions. The Windows development environment did not expose this issue.

### Solution

Marked the Maven wrapper as executable in Git:

`git update-index --chmod=+x mvnw`

### Lesson

File permissions can behave differently between Windows and Linux.
CI can expose cross-platform issues that aren't visible during local
development.

---

## 6. PostgreSQL Connection Refused in CI

### Problem

GitHub Actions failed with:

`Connection to localhost:5432 refused.`

### Cause

The PostgreSQL container running locally through Docker was not available
to GitHub Actions. GitHub Actions runs on a separate temporary machine.

### Solution

Added PostgreSQL 17 as a GitHub Actions service container:

`services:`
`  postgres:`
`    image: postgres:17`

### Lesson

CI environments are isolated from local development environments.
External dependencies required by tests must be provided within the CI
environment.

---

## 7. Git Line Ending Warnings

### Problem

Git displayed warnings such as:

`LF will be replaced by CRLF`

when adding project files.

### Cause

The project files use Unix-style LF line endings while Windows commonly
uses CRLF line endings. Git was configured to handle the conversion.

### Solution

No action was required.

### Lesson

Line-ending differences between operating systems are normal and are
handled by Git's line-ending configuration.