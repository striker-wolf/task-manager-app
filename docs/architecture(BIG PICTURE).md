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