# Welcome my hiring test!

## Implementation
Decided to implement the API by initializing a springboot project since it 
allows me to get started quickly with a Java application.

SWAGGER was used for documenting API, by using swagger annotations is really easy to get the API documentation always updated.
(To see API documentations refer to Running application section)

Decided to use Jooq for persistence since it allows to write easy and safe queries by generating code based on the existent DB

Liquibase was added for DB creation and database changes tracking

Basic auth implemented using Spring security


API is available: http://minesweeperapi-env.eba-h2mmpfhs.us-east-2.elasticbeanstalk.com/swagger-ui.html#/
**For accessing most of the endpoints you'll need to create a user account credentials by using the /users resource**

Kotlin multiplatform API Client **(WIP)** : https://github.com/principitomas/minesweeper-api-client

## Running the application

### To run the minesweeper application in you local machine you just need to:

 - Make sure you have MySQL and Java 8 installed in your local
 
 - Import the project in Intellj IDEA and if that's the first time you run the app run first the **liquibase:update** Maven goal that will automatically generate the data structure. Before running the goal and the application, remember add your database url and credentials to liquibase.properties and application.properties both located in resources/config/ (DO NOT FORGET THIS)

Once you updated the properties files and **liquibase:update** already run the application is ready to go!

 - API documentation will be available in http://localhost:8081/swagger-ui.html#/




