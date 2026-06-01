# Architecture

## Backend
- Spring Boot
- Layers:
  - Controller
  - Service
  - Repository
  - Entity

## Database
- PostgreSQL

## Flow
Controller → Service → Repository → DB




## Flow
Client → DTO → Controller → Service → Entity → Repository → DB




## Flow
Client → DTO → Controller → Service → Mapper → Entity → Repository → DB




## Flow
React → API Call → Controller → Service → Mapper → Repository → DB → Response → UI




# Frontend Architecture

React Components
        ↓
Service Layer
        ↓
Spring Boot APIs

# Backend Architecture

Controller
        ↓
Service
        ↓
Mapper
        ↓
Repository
        ↓
Database