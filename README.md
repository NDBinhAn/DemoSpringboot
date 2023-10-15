# Steps for running application
1. **BUILD JAR FILE**
* Open terminal in this folder, type command ".\gradlew bootJar" (required Java 17 & Gradle)

2. **COMPOSE CONTAINER GROUP**
* In terminal in this folder, type "docker-compose up -d" to create app image then run containers app & mysql
* Result: app listen to port 8080

3. **CHECK RESULT BY POSTMAN**
* TaskService.postman_collection.json file is attached in this folder. Import this file to Postman then send request step-by-step


# Dependencies:
- JPARepository
- Flyway to migrate sql statement when run application
- MapStruct to transfer data from DTO object in RequestBody to Entity and from Entity to ResponseBody
