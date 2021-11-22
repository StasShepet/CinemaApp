# Cinema App

# :closed_book: General info:
Hello! Immediately in the project is a web-api, where I implemented the processing of various requests, depending on the role that were granted to him after authorization. The project was implemented using Spring, Hibernate, Java 11 and compliance with the principles of SOLID and REST

# :cinema: About project:
This is a cinema service, where you can use next requests:
- GET - /login - all users
- GET - /cinema-halls, /movies, /movie-sessions/available - all roles,
- GET - /users/by-email?email - ADMIN role,
- GET - /orders, /shopping-carts/by-user - USER role;
- POST - /register-user, /register-admin - unauthorized,
- POST - /cinema-halls, /movies, /movie-sessions - ADMIN role,
- POST - /orders/complete - USER role; PUT /movie-sessions/id - ADMIN role,
- PUT - /shopping-carts/movie-sessions?movieSessionId - USER role;
- DELETE - /movie-sessions/id - ADMIN role.

# :abacus: Technologies used:

1. Java 11
2. MySQL
3. Spring (Spring Core, Spring Security, Spring Web)
4. Tomcat 9.0.50
5. Hibernate
6. Maven

# :computer: If you want to run this project on your computer, you need:
1. Install MySQL or another DBMS and create a schema
2. In src/main/resources/db.properties add Driver, the path to your DB, password, and username
3. Deploy application to Tomcat 9.x

By default there are installed two accounts: ADMIN anna@gmail.com with password: 12345678

and USER bohdan@gmail.com with password: 87654321