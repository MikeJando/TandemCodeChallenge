# TandemCodeChallenge
Submission for Tandem Code Challenge 10/2020

By Mike Jando

## Information

This is a gradle project writting in Java to parse a JSON file and implement a quiz game via the command prompt.

## Dependencies
Project written in Java 11, JDK11 can be found: https://www.oracle.com/java/technologies/javase-jdk11-downloads.html

JSON File should be added to the resources folder within the project.

JSON Simple 1.1.1 was used:https://mvnrepository.com/artifact/com.googlecode.json-simple/json-simple

You must add the following to your build.gradle file, under "dependencies"

compile group: 'com.googlecode.json-simple', name: 'json-simple', version: '1.1.1'

## Possible Issues

The code will handle input mismatch exceptions and Index Out of Bounds exceptions.  
However, it is possible some test cases were missed in the handling of these errors.

## Future Enhancements
In the future, I would like to add an interface via JavaFX.
