# HelloWorldApp - Jenkins CI/CD Demo

A simple Java Maven application demonstrating Jenkins Freestyle Build Job integration.

## Prerequisites

- OpenJDK 17 or higher
- Maven 3.6.0 or higher
- Jenkins (for CI/CD)

### Ubuntu Setup (if not already installed)

```bash
sudo apt update
sudo apt install openjdk-17-jdk maven
java -version  # Verify OpenJDK 17 is installed
```

## Build Locally

```bash
mvn clean install
```

## Run the Application

```bash
java -jar target/HelloWorldApp-1.0.0.jar
```

## Run Tests

```bash
mvn test
```

## Project Structure

- `src/main/java/` - Main application code
- `src/test/java/` - Unit tests
- `pom.xml` - Maven configuration file

## Jenkins Integration

This project is configured for Jenkins Freestyle Build Jobs. Follow these steps to integrate with Jenkins:

1. Fork or clone this repository
2. Create a new Freestyle job in Jenkins
3. Configure the job with:
   - **Repository URL**: Your GitHub repository URL
   - **Branch**: `*/main`
   - **Build Steps**: Maven target `clean install`
   - **Post-Build Actions**: 
     - Publish JUnit test results from `**/target/surefire-reports/*.xml`
     - Archive artifacts `target/*.jar`

See `JENKINS_SETUP.md` for detailed Jenkins configuration instructions.
"# HelloWorldApp" 
