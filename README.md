# yape-booking-mobile-automation

### Prerequisites
* Java jdk 1.8
* Git
* maven 3x or higher
* Download and install android studio https://developer.android.com/studio
* Download and install Appium Server GUI
  
  ```
  https://github.com/appium/appium-desktop/releases/tag/v1.22.3-4
  https://github.com/appium/appium-inspector/releases (Appium Inspector - Optional)
  ```
* Install adb https://www.xda-developers.com/install-adb-windows-macos-linux/

---
### Clone a repository
1. Go to the repository link and clone repo

```
https://github.com/AlexanderGamarra/yape-booking-mobile-automation
```
---

### Building Project

Open project and following the next steps (IntelliJ - Recommended)

```
1. Open project folder in terminal
2. Execute next command there "mvn clean install" (To install maven dependencies)
3. Execute "mvn verify" (You shouldn't have mistakes)
```
---
### Set Up IntelliJ

Install plugins
```
1. Go to the preferences
2. Search plugins section
3. Install "Cucumber for Java" and "Gherkin"
4. Reopen IntelliJ 
```
---
### Set Up Environment
#### Virtual Device - ADB

1. Open "Android Studio/Virtual Device Manager/Run Emulator” (Or you can use physical device)
2. Turn on USB debugging and connect it to your computer.
3. Open terminal and run next command: “adb devices”

   ```
   adb devices
  
   ```
   * You should see something like this:
   ```
   alexandergamarra@Alexanders-MacBook-Pro Android % adb devices
   List of devices attached
   emulator-5554	device
   ```
#### Booking Application
   1. Go to the follow path ./yape-booking-mobile-automation/src/test/resources/apk/
   2. Copy “com.booking_v33.6.0.1-901292_Android-8.0.apk” absolute path
   3. Go to your terminal and execute the follow command: 

   ```
      adb install {absolute path copied recently}
   ```
   * Example:
   ```
      alexandergamarra@Alexanders-MacBook-Pro Android % adb install /Users/alexandergamarra/Documents/Examén\ técnico/Desafio\ 2/	com.booking_v33.6.0.1-901292_Android-8.0.apk
      Performing Streamed Install
      Success
   ```

#### Appium Server GUI
   1. Open Appium Server GUI
   2. Click on Edit configurations and set _ANDROID_HOME_ and _JAVA_HOME_ path
   ```
      Example:
      
      ANDROID_HOME: /Users/alexandergamarra/Library/Android/sdk
      JAVA_HOME: /Library/Java/JavaVirtualMachines/jdk1.8.0_341.jdk 
   ```
   2. After that click on Save and Restart Appium
   3. Go to Advanced tab and set follow values	

      ```
         Server address: localhost
         Port: 4723
         Allow CORP: yes
      ```
   4. Click on startServer
---
### Run Automated Test Suite

Project has the follow tags executions: @RegressionTest and @SmokeTest
```
1. Go to this file "src/test/java/main.java"
2. If you want to execute all the tests, you must use @RegressionTest tag

@CucumberOptions(
        tags = "@RegressionTest",
        plugin = {"pretty"}
)
  
```
### Getting serenity reports

```
1. Go to the terminal
2. Execute next command: "mvn serenity:aggregate"
3. You will see serenity reports on the logs:

[INFO]   - Full Report: {user}/yape-restFul-booker/target/site/serenity/index.html
[INFO]   - Single Page HTML Summary: {user}/yape-restFul-booker/target/site/serenity/serenity-summary.html
[INFO]   - Full Report As React Based Single Page Application: {user}/yape-restFul-booker/target/site/serenity/navigator/index.html

5. Enter to the "Full Report" to see execution details.  
```
