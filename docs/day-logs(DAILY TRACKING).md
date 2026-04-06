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