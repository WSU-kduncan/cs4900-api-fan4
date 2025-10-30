# API ROUTES

## GET methods

### movie Entity
- All movies
- Movie by movieId
- Movie by title

### watchedMovie Entity
- All watched movies
- Watched Movies by Id (composite)
- WatchedMovie by username
- WatchedMovie by movie

### review Entity
- All reviews
- Reviews by Id (composite)
- Review by username

### user Entity
- All users
- Users by Id
- Users by review
- Users by exact name

## POST methods

### movie Entity
- New Movie

### watchedMovie Entity
- New watched movie entries

### review Entity
- New review
  
### user Entity
- Create new user
- Change username
- Change name
  
## PUT methods

### movie Entity
- Update Movie

### watchedMovie Entity
- Update watched movie status
  - Practically only watched movie date will be changed
  -  PUT returns 201 when creating a new object and 200 when updating

### review Entity
- Update review

### user Entity
- Update username
- Update name
- Update birth year

## HOW TO RUN API
Ensure the following are installed on your system:
- Java JDK (17 or higher) 
- Gradle
- MariaDb
- Git
- Bruno
- DBeaver

NOTE: Spring Boot and JPA are utilized in this project; however, additional installation for these dependencies will not be necessary as they are included via Gradle dependencies.

1. Clone the repository
    - Run: `git clone https://github.com/WSU-kduncan/cs4900-api-fan4.git`
    
2. Clone the database repository
    - Run: `git clone https://github.com/WSU-kduncan/cs4900-fan4.git`
    
3. Start the database container
    - Navigate to the database directory that contains the Docker Compose file: `cd cs4900-fan4/DatabaseDesign/`
    - Run: `docker compose up -d`
    
4. Verify database connection
    - Open DBeaver to ensure the database is connected on the same port (should be 4444). Refer to README file for further instructions found at `https://github.com/WSU-kduncan/cs4900-fan4/blob/feedback/DatabaseDesign/README.md`
    
5. Skip if populated: Click on SQL editor on the top menu in DBeaver. Paste the SQL script and click run SQL script on the left menu inside the editor found at `https://github.com/WSU-kduncan/cs4900-fan4/tree/feedback/DatabaseDesign/InitializationScripts`

6. Run the Spring Boot API application
    - Ensure you are on the main branch, if not run: `git checkout -b main`
    - Navigate to cs4900-api-fan4/src/main/java/com/Fan4/Collectiviews/demo/Fan4.java
    - Click run java in vscode
    
7. Test API
    - Open Bruno and import the provided collection
    - Test various endpoints using GET, POST, and PUT

