# BIRTHDAY SYSTEM CHALLENGE

This system is part of the Jobsity tech interview process

## System Dependencies

This application was developer using the technologies below

* Java 17.0.4
* Gradle 8.5
* Spring Shell

Confirm that you are use a JDK greater or equals the informed version here.
It'ss

## Build the Application
In your terminal you need to go to the root project path.

After this, you need to run the below command to generates the java file and run the full tests.
```shell
./gradlew clean build test
```
## Run the Application

After [Build the Application](#build-the-application), you can start the shell command line application with the below command. 
```shell
java -jar build/libs/birthday-project-0.0.1-SNAPSHOT.jar
```

In the shell you have some important commands:

* help -> shows all command the application allows.
* exit -> exit the shell
* send-happy-birthday-message -> send a happy birthday message flow
* send-reminder-birthday-message -> send a reminder birthday message flow

### send-happy-birthday-message

This command execute the flow that generates notification for each friend that has make birthday in the informed date.

* InputDate
  * This command arg allows that you inform a specific date in the standard YYYY-MM-DD. If not informed, the application will assume the current date.

* Output
  * If some friend is a birth person, the app will print the message that we expect to send for him. Of course, I didn't implement the integration with a mail provider.
  * The Message layout is: receiver email, subject and body.

* example
```shell
send-happy-birthday-message --inputDate 2023-10-20
```

### send-reminder-birthday-message

This command execute the flow that generates notification for all friends (without the birth person) to reminder them to send a message for the birth person.

* InputDate
  * This command arg allows that you inform a specific date in the standard YYYY-MM-DD. If not informed, the application will assume the current date.

* Output
  * If some friend is a birth person, the app will print the messages for the other friends in the way we expect to send for them. Of course, I didn't implement the integration with a mail provider.
  * The Message layout is: receiver email, subject and body.
* example
```shell
send-reminder-birthday-message --inputDate 2023-10-20
```

## Unit Test

The application was built based in the TDD concept.

We have unit test for the domain and the adapter layers.

For the subsections below, the tests need to run. Execute [Build the Application](#build-the-application) section.  

### Test Report 

You can see the test execution report when you access the file below.
```shell
./build/reports/tests/test/index.html
```

### Jacoco

I included the Jacoco dependency to shows the application test coverage.

You can see the coverage information access the file below.
```shell
./build/jacocoHtml/index.html
```
