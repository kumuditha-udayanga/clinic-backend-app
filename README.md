# Clinic Backend Demo

## Requirements
- Java version: **17**
- Maven

## Setup

1. **Set Frontend Origin URL**  
   In `src/main/resources/application.properties`, set the origin to match your frontend host:

   ```properties
   app.origin.url=http://localhost:3000

2. **Install dependencies**

    ```
    mvn clean install

2. **Run the server**

    ```
    mvn spring-boot:run

The app will typically run at http://localhost:8080.