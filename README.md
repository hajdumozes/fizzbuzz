# FizzBuzz

### Description

A simple web app printing numbers from 1 to the selected number.

Numbers, which are a multiple of 3, are replaced with Fizz, while the multiples of 5 are replaced with Buzz.

### Requirements
- Apache Tomcat (and all of its requirements)

### How to build

- the app requires tomcat, which means that the built war needs to be copied into it's webapps directory
- the war can be created by 'mvn clean install' / 'mvn clean package'
- more about deploying war to tomcat: https://www.baeldung.com/spring-boot-war-tomcat-deploy

### How to test
- all tests are run during the build process, so if one of them fails, the war file cannot be produced
- the build process can be skipped by using 'mvn test'
- the tests can be found in the default src/test location, and follow the structure of the src/main folder
- they can be run manually as any other java application

### How to run
- after deployed to and run by tomcat, the app can be accessed at its dedicated port, eg.: http://localhost:8080/fizzbuzz/
- the default port for tomcat is 8080
- the port must be followed by the war name, which is fizzbuzz after the build
- followed by a git clone operation, the app can also be run by the 'fizzbuzz\src\main\java\com\example\fizzbuzz\FizzbuzzApplication.java' file

### Maven
Since the app is maven based, and setting it up might be tricky: https://stackoverflow.com/questions/45119595/how-to-add-maven-to-the-path-variable
