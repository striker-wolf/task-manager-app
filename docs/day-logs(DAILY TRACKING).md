# Day 1 — Backend Setup

## What I Did
- Created Spring Boot project
- Connected PostgreSQL
- Built User API

## Problems
- Table name conflict (user keyword issue)

## Fix
- Used @Table(name = "users")

## Learnings
- Controller → Repository → DB flow
- Importance of naming

## Next
- Add Service Layer
- Add GET API





# Day 2 — Service Layer + GET API

## What I Did
- Added Service Layer
- Refactored controller to use service
- Implemented GET /users API

## Problems
- (leave empty if none)

## Fix
- (leave empty)

## Learnings
- Separation of concerns (Controller vs Service)
- Cleaner architecture improves maintainability

## Next
- Add Update/Delete API
- Add validation





# Day 3 — CRUD + Validation + Debugging

## What I Did
- Implemented Update API (PUT)
- Implemented Delete API (DELETE)
- Added validation using @NotBlank and @Email
- Fixed multiple Maven and dependency issues
- Configured Lombok correctly

## Problems
- Validation annotations not working
- Maven dependency errors
- Lombok not generating methods
- Duplicate method in controller

## Fix
- Added spring-boot-starter-validation dependency
- Cleaned and corrected pom.xml dependencies
- Enabled annotation processing for Lombok
- Removed duplicate method

## Learnings
- Difference between build, compile, and runtime errors
- Importance of correct dependencies in Spring Boot
- How validation works using annotations
- How Lombok works internally

## Next
- Implement exception handling





# Day 4 — Exception Handling

## What I Did
- Created custom exception (ResourceNotFoundException)
- Implemented global exception handler using @RestControllerAdvice
- Replaced RuntimeException with custom exception
- Added GET /users/{id} API
- Fixed HTTP status handling (200 → 404)

## Problems
- 405 Method Not Allowed error
- Incorrect HTTP status (200 instead of 404)

## Fix
- Added missing @GetMapping("/{id}")
- Used @ResponseStatus(HttpStatus.NOT_FOUND)

## Learnings
- Difference between HTTP status and response body
- Importance of centralized exception handling
- Clean error response structure
- How backend communicates errors to client

## Next
- Handle validation errors properly
- Standardize API responses





# Day 5 — Validation Handling + Standard API Design

## What I Did
- Implemented global validation error handling
- Standardized API response format across all endpoints
- Refactored controller to return structured responses
- Applied consistent response for POST, GET, PUT, DELETE

## Problems
- Validation not triggering initially
- Confusion between 400 vs 500 errors
- Inconsistent API responses

## Fix
- Added @Valid in controller
- Handled MethodArgumentNotValidException globally
- Standardized response structure using Map

## Learnings
- Full validation flow (Request → Validation → Exception → Handler → Response)
- Difference between HTTP status codes (200, 201, 400, 404, 500)
- Importance of consistent API design

## Next
- Introduce DTO layer





# Day 6 — DTO Layer (Data Abstraction)

## What I Did
- Introduced DTO layer (UserRequestDTO, UserResponseDTO)
- Refactored controller to use DTO instead of Entity
- Updated service to convert DTO ↔ Entity
- Implemented clean data flow across layers

## Problems
- DTO not integrated initially
- Type mismatch errors (DTO vs Entity)
- Missing imports (ArrayList)
- Getter/Setter confusion

## Fix
- Updated controller and service to use DTO consistently
- Fixed imports
- Ensured proper conversion between DTO and Entity

## Learnings
- Difference between DTO and Entity
- Importance of data abstraction and decoupling
- DTO → Entity → DTO flow
- Each layer must use consistent data types

## Next
- Replace Map with proper response wrapper class