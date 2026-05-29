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





# Day 11 — Frontend Integration (React + API)

## What I Did
- Created React app using create-react-app
- Cleaned default boilerplate files
- Built UserList component to fetch and display users
- Connected frontend with backend GET /users API
- Rendered dynamic data using React state and useEffect

## Problems
- CORS issue while calling backend API
- Confusion with nested response (data.data)
- No error handling initially

## Fix
- Enabled CORS using @CrossOrigin in backend
- Accessed correct data using ApiResponse structure (data.data)
- Added basic error handling in fetch

## Learnings
- Full frontend-backend data flow
- React state management using useState
- Side effects handling using useEffect
- Importance of API response structure

## Next
- Build form to create user (POST API integration)





# Day 12 — Create User Form + POST API Integration

## What I Did
- Built UserForm component using controlled inputs
- Implemented POST API call to create users
- Connected frontend form with Spring Boot backend
- Added dynamic UI refresh after successful user creation
- Implemented parent-child communication using props

## Problems
- Understanding async form submission flow
- Confusion around refresh-based UI updates
- Missing frontend validation initially

## Fix
- Used async/await for API handling
- Triggered UI refresh using shared parent state
- Added basic validation and response status handling

## Learnings
- Controlled components using useState
- Form event handling using preventDefault()
- Parent-child communication through props
- State-driven UI rendering and refresh flow
- Frontend-backend interaction lifecycle

## Next
- Implement delete user functionality from frontend





# Day 13 — Delete User Flow (Frontend + Backend Sync)

## What I Did
- Added Delete button for each user
- Integrated DELETE API call with backend
- Implemented confirmation dialog before deletion
- Refreshed user list dynamically after delete
- Used dynamic user ID-based API requests

## Problems
- Understanding frontend-backend synchronization after delete
- Confusion about dynamic URLs and action binding
- Concern about keeping UI state consistent

## Fix
- Used dynamic route with user ID for DELETE requests
- Triggered fetchUsers() after deletion
- Added confirmation flow using window.confirm()

## Learnings
- Event-driven frontend interaction
- Dynamic API requests using IDs
- Importance of backend and frontend state synchronization
- UI updates do not happen automatically after backend changes

## Next
- Implement update/edit user functionality





# Day 14 — Edit / Update User Flow

## What I Did
- Added Edit button for each user
- Lifted editing state to App.js
- Implemented reusable form for Create + Edit operations
- Added pre-filled form behavior using useEffect
- Integrated PUT API for updating users
- Dynamically switched form mode and button text
- Reset form state after successful update

## Problems
- Understanding shared state between components
- Confusion around useEffect dependency behavior
- Managing create vs update flow in same form

## Fix
- Lifted editingUser state to parent component
- Used conditional logic for POST vs PUT requests
- Used useEffect to synchronize form fields with editing state

## Learnings
- Lifting state up in React
- Parent-child component coordination
- Reusable form architecture
- Conditional rendering and dynamic form behavior
- React lifecycle through state and useEffect

## Next
- Add loading states and frontend feedback system





# Day 15 — UX + Feedback System

## What I Did
- Added loading state management during API requests
- Disabled submit button while requests are in progress
- Added success messages for create and update operations
- Added error messages for failed requests
- Improved API error handling using backend response messages
- Implemented request lifecycle management using try/catch/finally

## Problems
- Understanding request lifecycle flow
- Managing multiple UI states (loading, success, error)
- Ensuring loading state resets on both success and failure

## Fix
- Used separate state variables for loading, success, and error
- Implemented finally block for cleanup
- Added proper response status checking before processing data

## Learnings
- Request lifecycle management
- Importance of user feedback during operations
- Preventing duplicate requests using disabled buttons
- Difference between system success and user-visible success
- Frontend error handling patterns

## Next
- Extract API calls into separate service layer