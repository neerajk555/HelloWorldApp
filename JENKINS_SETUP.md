# Jenkins Freestyle Build Job Configuration Guide

This guide provides step-by-step instructions to configure a Jenkins Freestyle Build Job for the HelloWorldApp project.

## Prerequisites

- Jenkins installed and running on Ubuntu
- Git plugin enabled (usually installed by default)
- Maven plugin installed in Jenkins
- OpenJDK 17 installed on Jenkins server

### Ubuntu Setup (if not already installed)

```bash
sudo apt update
sudo apt install openjdk-17-jdk maven
java -version  # Verify OpenJDK 17 is installed
```

## Step 1: Access Jenkins Dashboard

1. Open Jenkins URL (usually `http://localhost:8080`)
2. Log in with your credentials
3. Click **Create a job** or **New Item**

## Step 2: Create New Freestyle Job

1. Enter job name: `HelloWorldApp-Build`
2. Select **Freestyle job**
3. Click **OK**

## Step 3: Configure General Settings

1. **Description**: Enter `Build and test HelloWorldApp from GitHub`
2. **GitHub Project**: 
   - Check the box: ✓ GitHub project
   - URL: `https://github.com/neerajk555/HelloWorldApp`

## Step 4: Configure Source Code Management

1. Select **Git** from Source Code Management
2. Fill in the details:
   - **Repository URL**: `https://github.com/neerajk555/HelloWorldApp.git`
   - **Credentials**: Leave blank (for public repo) or add GitHub credentials if private
   - **Branch Specifier**: `*/main`
   - **Additional Behaviours**: 
     - Click **Add** and select "Clean before checkout"

## Step 5: Configure Build Environment

1. Check: ✓ **Provide Maven environment**
2. Maven Version: Select the latest available

## Step 6: Configure Build Steps

1. Click **Add build step**
2. Select **Invoke top-level Maven targets**
3. Configure:
   - **Maven Version**: Select your Maven version
   - **Goals**: `clean install`

## Step 7: Configure Post-Build Actions

1. Click **Add post-build action**
2. Select **Publish JUnit test result report**
3. Configure:
   - **Test report XMLs**: `**/target/surefire-reports/*.xml`

4. (Optional) Add archive artifacts:
   - Click **Add post-build action**
   - Select **Archive the artifacts**
   - **Files to archive**: `target/*.jar`

## Step 8: Save and Test

1. Click **Save**
2. Click **Build Now** to test the job
3. Monitor the build progress in the **Console Output**

## Step 9: Verify Build Success

1. Click on the build number in the **Build History**
2. Click **Console Output**
3. Look for:
   - `[INFO] BUILD SUCCESS`
   - Test results summary
   - JAR file created

### Expected Output Example

```
[INFO] Scanning for projects...
[INFO] 
[INFO] --------------------< com.example:HelloWorldApp >---------------------
[INFO] Building HelloWorldApp 1.0.0
[INFO] --------------------------------[ jar ]---------------------------------
...
[INFO] Tests run: 2, Failures: 0, Errors: 0, Skipped: 0
[INFO] 
[INFO] --- maven-jar-plugin:3.2.0:jar (default-jar) @ HelloWorldApp ---
[INFO] Building jar: .../target/HelloWorldApp-1.0.0.jar
[INFO] 
[INFO] BUILD SUCCESS
[INFO] Total time:  XX.XXX s
[INFO] Finished at: 2025-12-02T10:00:00+00:00
```

## Troubleshooting Guide

### Build Fails with "mvn: command not found"
- **Solution**: Install Maven or select Maven in Jenkins > Manage Jenkins > Global Tool Configuration

### "Failed to connect to repository"
- **Solution**: 
  - Verify GitHub URL is correct
  - For private repos, add GitHub credentials in Jenkins
  - Check network connectivity

### Tests Not Running
- **Solution**: Ensure surefire plugin is in pom.xml and test files are in correct location

### Build Succeeds but Artifacts Not Found
- **Solution**: Check the archive artifacts path matches actual output location

## Manual Build for Testing

To test the build locally before setting up Jenkins:

```bash
# Clone the repository
git clone https://github.com/YOUR_USERNAME/HelloWorldApp.git
cd HelloWorldApp

# Build the project
mvn clean install

# Run the application
java -jar target/HelloWorldApp-1.0.0.jar

# Run tests
mvn test
```
