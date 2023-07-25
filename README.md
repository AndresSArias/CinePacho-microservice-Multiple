<br />
<div align="center">
<h3 align="center">CINE PACHO, MICROSERVICE MULTIPLEXS</h3>
  <p align="center">
    Installation guide for the backend of a system that resolve the services of a cinema chain that has different multiplexes in the city. This is the Multiplexs Microservice, this service solves the requirements presented along with the Users Microservice connection.
  </p>
</div>

### Built With

* ![Java](https://img.shields.io/badge/java-%23ED8B00.svg?style=for-the-badge&logo=java&logoColor=white)
* ![Spring](https://img.shields.io/badge/Spring-6DB33F?style=for-the-badge&logo=spring&logoColor=white)
* ![Gradle](https://img.shields.io/badge/Gradle-02303A.svg?style=for-the-badge&logo=Gradle&logoColor=white)
* ![MySQL](https://img.shields.io/badge/MySQL-00000F?style=for-the-badge&logo=mysql&logoColor=white)


<!-- GETTING STARTED -->
## Getting Started

To get a local copy up and running follow these steps.

### Prerequisites

* JDK 17 [https://jdk.java.net/java-se-ri/17](https://jdk.java.net/java-se-ri/17)
* Gradle [https://gradle.org/install/](https://gradle.org/install/)
* MySQL [https://dev.mysql.com/downloads/installer/](https://dev.mysql.com/downloads/installer/)

### Recommended Tools
* IntelliJ Community [https://www.jetbrains.com/idea/download/](https://www.jetbrains.com/idea/download/)
* Postman [https://www.postman.com/downloads/](https://www.postman.com/downloads/)

### Installation

1. Clone the repository
2. Change directory
   ```sh
   cd CinePacho-microservice-Multiplexs
   ```
3. Execute the script of "scriptCreationDB" in resource (src/main/resources/scriptCreationDB.sql).
4. After the tables are created with the first execute microservice, execute src/main/resources/scriptInitialFillDB.sql content to populate the database
5. Update the database connection settings
   ```yml
   # src/main/resources/application-dev.yml
   spring:
      datasource:
          url: jdbc:mysql://localhost/cinepacho_dbmultiplexs
          username: root
          password: <your-password>
   ```
6. Open Swagger UI and search for the endpoint you want to use, remember to have the token generated from the Users microservice.

<!-- USAGE -->
## Usage

1. Right-click the class UserMicroserviceApplication and choose Run
2. Open [http://localhost:8090/swagger-ui/index.html](http://localhost:8090/swagger-ui/index.html) in your web browser

<!-- ROADMAP -->
## Tests

- Right-click the test folder and choose Run tests with coverage
