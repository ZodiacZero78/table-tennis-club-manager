# Development Guide

This document explains how to set up, run, test and build the Table Tennis Club Manager application locally.

---

## Prerequisites

The following tools are required:

- Java 21
- Docker Desktop
- Git
- IntelliJ IDEA

The project uses the Maven Wrapper, so Maven does not need to be installed separately.

---

## Project Setup

### 1. Clone the Repository

Clone the repository from GitHub:

```bash
git clone https://github.com/ZodiacZero78/table-tennis-club-manager.git
```

Navigate into the project directory.

```bash
cd table-tennis-club-manager
```

### 2. Start Docker Desktop

Make sure Docker Desktop is running before starting the database.

Docker is used to run the local PostgreSQL database.

### 3. Start PostgreSQL

From the project root directory, run:
```bash
docker compose up -d
```

the ```-d``` option runs the container in detached mode, allowing the terminal
to be used for other commands.

Check that the PostgreSQL container is running:

```bash
docker ps
```

The PostgreSQL container should appear as:

```text 
table-tennis-postgres
```

## Running the Application

The application can be run either through IntelliJ IDEA or from the terminal.

### IntelliJ IDEA

Run the `TableTennisClubManagerApplication` class.

### Terminal

On Windows:

```powershell
.\mvnw.cmd spring-boot:run
```

On Linux/macOS:
```bash
./mvnw spring-boot:run
```

The application will start using the local PostgreSQL database.