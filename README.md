# Exercise Log

This project provides a RESTful API to manage users, physical activities, and goals related to a fitness tracking application.

## Features

- User management (CRUD operations)
- Physical Activity management (CRUD operations)
- Goal management (CRUD operations)

## Technologies

- Java
- Spring Boot
- Spring MVC
- Spring Data JPA
- PostgreSQL
- Gradle
- Lombok
- Spring Security Crypto (BCrypt)

## Getting Started

1. Clone the repository:

```
git clone ...
cd fitness-tracker-api
```

2. Set up the PostgreSQL database using Docker:

    - Install Docker on your machine, if you haven't already.
    - Run a PostgreSQL container with the following command:

      ```
      docker run --name exercise-log-postgres -e POSTGRES_USER=myuser -e POSTGRES_PASSWORD=mypassword -e POSTGRES_DB=exercise-log-db -p 5432:5432 -d postgres
      ```

      Replace `myuser` and `mypassword` with your desired database username and password.

    - The PostgreSQL database `exercise-log-db` will now be running on your local machine, accessible on port 5432.

    - Update the `src/main/resources/application.properties` file with your database connection information:

      ```
      spring.datasource.url=jdbc:postgresql://localhost:5432/exercise-log-db
      spring.datasource.username=myuser
      spring.datasource.password=mypassword
      ```

      Replace `myuser` and `mypassword` with the username and password you used when running the PostgreSQL container.


3. Build the project:

```shell
./gradlew build
```

4. Run the project:

```shell
./gradlew bootRun
```

5. The API should be available at `http://localhost:8080`.

## API Endpoints

The following API endpoints are available:

### User Management

- `GET /users`: Get all users.
- `GET /users/{user_id}`: Get a specific user by ID.
- `POST /users`: Create a new user.
- `PUT /users/{user_id}`: Update an existing user by ID.
- `DELETE /users/{user_id}`: Delete a user by ID.
- `POST /users/authenticate`: Authenticate a user by email and password.

### Physical Activity Management

- `GET /activities`: Get all physical activities.
- `GET /activities/{activity_id}`: Get a specific physical activity by ID.
- `GET /activities/user/{user_id}`: Get all physical activities for a specific user by user ID.
- `POST /activities`: Create a new physical activity.
- `PUT /activities/{activity_id}`: Update an existing physical activity by ID.
- `DELETE /activities/{activity_id}`: Delete a physical activity by ID.

### Goal Management

- `GET /goals`: Get all goals.
- `GET /goals/{goal_id}`: Get a specific goal by ID.
- `GET /goals/user/{user_id}`: Get all goals for a specific user by user ID.
- `POST /goals`: Create a new goal.
- `PUT /goals/{goal_id}`: Update an existing goal by ID.
- `DELETE /goals/{goal_id}`: Delete a goal by ID.

## API Documentation

You can access the API documentation and explore the available endpoints using the following URLs:

- Swagger: `/swagger-ui.html`
- OpenAPI: `/v3/api-docs`

