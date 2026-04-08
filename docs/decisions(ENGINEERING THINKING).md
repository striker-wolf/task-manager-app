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