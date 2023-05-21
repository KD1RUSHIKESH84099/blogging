# BloggingPlatformApi
## Language Used
- JAVA
## FrameWork Used
- SpringBoot
## DataBase Used
- MySQL
## Requirements
- IntelliJIDEA
- ServerPort: 8080 (use: localhost:8080)
- ServerPort: 8080 
- Java version: 17
- Everything is present in the pom.xml (no need to download any library)
- Aws account to deploy project
## Installation
To run this application locally, you will need to have Java and MySQL installed on your machine.

- Clone the repository to your local machine.
- Create a new MySQL database.
- Update the application.properties file in the src/main/resources directory to include your MySQL username and password
- Run the application using your IDE or by running the command mvn spring-boot:run in the project directory
- Access the APIs using any HTTP client such as Postman or cURL.

## Data Flow
The application is built using the SpringBoot framework and consists of four layers: DTO, model, service, and repository.-

- Controller - The controller layer handles the HTTP requests, translates the JSON parameter to object, and authenticates the request and transfer it to the business (service) layer. In short, it consists of views i.e., frontend part.
- Service -The business layer handles all the business logic. It consists of service classes and uses services provided by data access layers.
- Repository - This layer mainatains the h2-database thing on which CRUD operations are performed
Model - This layer consists basically the class level things- the various classes required for the project and these classes consists the attributes to be stored.
 ## EndPoints

- Delete/ post/{postId}/ delete post.
- Put/post/{postId}/ update post.
- Post Controller The post controller handles post-related operations.
- GET /post Retrieve all posts.
- POST /post Create a new post.
- Comment Controller The comment controller manages comments on posts.
- POST /comment Add a new comment to a post.
- Delete /comments/{commentId}/ delete comment.

## Working

- This project consist of four models namely User, Post, Follow, Comments along with their corresponding repository classes, controller classes and service classes
- SQl-Queries has been handled with native query in the post repository and user repository as per need of the queries
- Performed Annotation validation on all the Model class present in the MVC
- Performed Manual validation too with the need of it, as an example we cannot have more than one user with same name
- Created Exception handler as the exceptions should be handled and whatever the output we want to show the user on screen is written
- Relationship between Models or tables are given accordingly, relationship given as such of @ManyToOne for post model where more than one user can have more than one posts or many posts, - In the model class of follow there is a @ManyToOne relationship between Users like one user follows other user if users are present in the database and parallel there are @ManyToOne relationship in between sender and receiver user and comment they sent to the post.


