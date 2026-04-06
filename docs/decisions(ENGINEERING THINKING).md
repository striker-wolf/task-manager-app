# Decisions

- Used @Table(name="users")
  Reason: "user" is reserved keyword in PostgreSQL

- Introduced Service Layer
  Reason: Separation of concerns, better scalability

- Used JPA instead of raw SQL
  Reason: Faster development and abstraction

- Used Service Layer
  Reason: To separate business logic from controller and improve scalability  