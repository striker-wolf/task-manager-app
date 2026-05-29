# Decisions

- Used @Table(name="users")
  Reason: "user" is reserved keyword in PostgreSQL

- Introduced Service Layer
  Reason: Separation of concerns, better scalability

- Used JPA instead of raw SQL
  Reason: Faster development and abstraction




- Used Service Layer
  Reason: To separate business logic from controller and improve scalability  




- Added validation using annotations
  Reason: Prevent invalid data from entering system

- Cleaned pom.xml dependencies
  Reason: Ensure stable and production-ready configuration

- Used Lombok
  Reason: Reduce boilerplate code and improve readability




- Used custom exception instead of RuntimeException
  Reason: To provide meaningful and specific error handling

- Implemented @RestControllerAdvice
  Reason: Centralize exception handling and avoid duplication

- Added HTTP status using @ResponseStatus
  Reason: Ensure correct communication with client (not just response body)    




- Standardized API response format
  Reason: Ensure consistency, easier frontend integration, and better debugging

- Handled validation errors globally
  Reason: Avoid default messy responses and improve clarity

- Used HTTP status codes properly (200, 201, 400, 404)
  Reason: Correct communication between backend and client




- Introduced DTO layer
  Reason: Avoid exposing entity directly and improve flexibility, security, and scalability

- Separated input and output DTO
  Reason: Control incoming and outgoing data independently  




- Introduced ApiResponse<T> wrapper
  Reason: Provide type safety, consistency, and reusable response structure

- Replaced Map with generic response class
  Reason: Avoid unstructured responses and improve maintainability




- Introduced mapper layer
  Reason: Separate data conversion from business logic and improve maintainability

- Used static methods in mapper
  Reason: Utility-style usage without needing object instantiation

- Used stream API for list mapping
  Reason: Cleaner and more readable transformation logic




- Used Builder pattern for object creation
  Reason: Improve readability, avoid partial object states, and scale better with more fields

- Used Lombok annotations (@Builder, @Data)
  Reason: Reduce boilerplate and simplify code  




- Introduced structured logging using SLF4J
  Reason: Improve debugging, monitoring, and production readiness

- Used parameterized logging ({})
  Reason: Better performance and standard logging practice




- Used React for frontend integration
  Reason: To visualize backend APIs and build full-stack understanding

- Consumed ApiResponse<T> in frontend
  Reason: Maintain consistency with backend response structure

- Enabled CORS in backend
  Reason: Allow frontend (localhost:3000) to access backend APIs  




- Used controlled components for form handling
  Reason: Keep React in control of input state and behavior

- Used parent-managed refresh state
  Reason: Coordinate updates between sibling components after user creation

- Used async/await for API requests
  Reason: Improve readability and handle asynchronous operations cleanly




  - Refetched users after deletion
  Reason: Ensure frontend stays synchronized with backend state

- Added confirmation dialog before delete
  Reason: Prevent accidental destructive actions

- Used dynamic ID-based DELETE endpoint
  Reason: Perform actions on specific resources




- Reused single form for Create and Edit operations
  Reason: Reduce duplication and centralize form logic

- Lifted editing state to App.js
  Reason: Allow coordination between UserList and UserForm

- Used conditional API logic (POST vs PUT)
  Reason: Support multiple behaviors using shared form state




- Added loading state during API requests
  Reason: Improve user experience and prevent duplicate actions

- Disabled submit button while processing
  Reason: Avoid multiple submissions and inconsistent state

- Added success and error feedback messages
  Reason: Keep users informed about operation outcomes

- Used try/catch/finally for request handling
  Reason: Ensure proper cleanup regardless of request result  