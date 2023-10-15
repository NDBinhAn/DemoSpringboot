# Steps for running application
1. **RUN MYSQL CONTAINER**: 
* Open terminal in this folder, run command "docker-compose up -d" to deploy mysql container with port 3306

2. **SETTING JDK FOR IDE**: 
* Open this folder by Intelij IDEA, choose File->Settings. 
* In appearanced window, on the left-side, choose Build... -> Build Tool -> Gradle 
* On the right-side, settings:
  * Build and run using: Intelij IDEA
  * Run test using: Intelij IDEA
  * Gradle JVM: Temurin-17 (enter Add SDK if not available)
* Click OK to finish

3. **BUILD, RUN APPLICATION**:
* Build Project
* Run Project (backend service will be available on port 8080)

4. **CHECK RESULT BY POSTMAN**
* TaskService.postman_collection.json file is attached in this folder. Import this file to Postman then send request step-by-step


# Dependencies:
- JPARepository
- Flyway to migrate sql statement when run application
- MapStruct to transfer data from DTO object in RequestBody to Entity and from Entity to ResponseBody
