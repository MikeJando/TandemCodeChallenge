# TandemCodeChallenge
Submission for Tandem Code Challenge 10/2020
By Mike Jando

## Information

This is a gradle project writting in Java to parse a JSON file and implement a quiz game via the command prompt.

## Installation
JSON File should be added to the resources folder within the project.

This project uses the JSON Simple library. You must add the following dependancy to your build.gradle file:

//https://mvnrepository.com/artifact/com.googlecode.json-simple/json-simple

compile group: 'com.googlecode.json-simple', name: 'json-simple', version: '1.1.1'

## Contributing
Pull requests are welcome!

## Possible Issues

The code will handle input mismatch exceptions and Index Out of Bounds exceptions.  
However, it is possible some test cases were missed in the handling of these errors.

## Future Enhancements
In the future, I would like to add an interface via JavaFX.

Additionaly, I would like to go back and look for ways to make the code more efficient.
