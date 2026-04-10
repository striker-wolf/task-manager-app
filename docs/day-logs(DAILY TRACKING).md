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





# Day 7 — API Response Wrapper + Generics

## What I Did
- Created generic ApiResponse<T> class
- Replaced Map-based responses with ApiResponse
- Refactored all controller endpoints (POST, GET, PUT, DELETE)
- Implemented type-safe and consistent API responses

## Problems
- Confusion with generics (<T>)
- Missed updating some endpoints initially
- Return type mismatch errors

## Fix
- Updated all controller return types to ApiResponse<T>
- Understood and applied generics correctly
- Ensured consistent response structure across APIs

## Learnings
- Generics (<T>) for reusable and flexible design
- Importance of type safety
- Difference between raw Map vs structured response class
- Clean and maintainable API design

## Next
- Introduce Mapper layer to remove manual DTO conversion





# Day 8 — Mapper Layer (Clean Architecture)

## What I Did
- Created UserMapper class for DTO ↔ Entity conversion
- Moved conversion logic from service to mapper
- Refactored service layer to use mapper methods
- Used stream API for mapping list of users

## Problems
- Initial confusion about need for separate mapper layer
- Understanding static methods usage
- Adapting to stream-based mapping

## Fix
- Separated responsibilities clearly (service vs mapper)
- Used static methods for utility-style mapping
- Applied .stream().map() for cleaner list conversion

## Learnings
- Importance of separation of concerns
- Cleaner service layer improves readability and maintainability
- Reusable mapping logic reduces duplication
- Functional style (stream API) for cleaner transformations

## Next
- Introduce builder pattern for cleaner object creation





# Day 9 — Builder Pattern (Clean Object Creation)

## What I Did
- Introduced Builder pattern using Lombok (@Builder)
- Applied builder to Entity and DTO classes
- Refactored mapper to use builder instead of setters
- Improved object creation readability and structure

## Problems
- Lombok builder not working initially
- Confusion with Lombok annotations and imports
- Mixed manual getters/setters with Lombok

## Fix
- Enabled annotation processing and corrected Lombok imports
- Removed manual getters/setters and relied on @Data
- Properly applied @Builder across classes

## Learnings
- Builder pattern enables clean and controlled object creation
- Fluent API improves readability and reduces errors
- Avoid mixing Lombok with manual code
- Builder is better than setters for scalable objects

## Next
- Introduce logging for debugging and production readiness





# Day 10 — Logging + Debugging

## What I Did
- Added logging using @Slf4j in service and exception handler
- Logged key backend operations (create, fetch, update, delete)
- Implemented error logging for failure scenarios

## Problems
- Confusion about where to place logs
- Initial habit of using System.out.println

## Fix
- Used structured logging with log.info() and log.error()
- Followed proper logging format using {} placeholders

## Learnings
- Logging improves observability and debugging
- Difference between log levels (info, error, debug)
- Structured logging is efficient and standard practice
- Debugging mindset shifted from guessing to reading logs

## Next
- Decide next phase: Frontend integration or advanced backend