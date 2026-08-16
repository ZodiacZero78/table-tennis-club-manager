# System Architecture

## Overview

The Table Tennis Club Manager is a web application designed to manage
members, attendance, table usage and reservations for a single table tennis
club.

The system uses a React frontend, a Spring Boot REST API and a PostgreSQL
database.

---

## Technology Stack

### Frontend

- React
- JavaScript/TypeScript
- HTML/CSS

### Backend

- Java 21
- Spring Boot
- Spring Web
- Spring Data JPA
- Flyway

### Database

- PostgreSQL 17

### Infrastructure

- Docker
- Docker Compose
- GitHub Actions

### Development

- IntelliJ IDEA
- Maven
- Git
- GitHub

---

## High-Level Architecture

The application follows a layered client-server architecture.

```text
┌──────────────────────┐
│      React App       │
│      Frontend        │
└──────────┬───────────┘
           │
           │ HTTP / REST
           ↓
┌──────────────────────┐
│    Spring Boot API   │
│      Backend         │
└──────────┬───────────┘
           │
           │ JPA / SQL
           ↓
┌──────────────────────┐
│     PostgreSQL       │
│      Database        │
└──────────────────────┘