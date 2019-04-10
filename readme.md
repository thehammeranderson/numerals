# Roman Numerals Converter

This is a java based Roman Numerals converter.  Given a Roman Numeral string (XIV) as a parameter, the converter will return the integer value.

Here are some of the main features:
* Roman Numeral format validation with tips on why it is wrong

The jar file that is created when this project is built could be used as a library but beware that this is a fat JAR that includes dependencies inside the JAR.

## Getting Started

* Download and install Git
  * See https://git-scm.com/book/en/v2/Getting-Started-Installing-Git for more information
* Open a terminal/console and navigate to the directory you wish to clone the repository to
* At the command line type the following
```
git clone https://github.com/thehammeranderson/numerals.git
```

See deployment for notes on how to deploy the project on a live system.

### Prerequisites to build and run

* Java - see https://www.java.com/en/download/help/download_options.xml for download and install instructions
* Maven - see https://maven.apache.org/install.html for download and install instructions

### Using an IDE

* Make sure you have Maven and JUnit plugins for your IDE
* Import the project as a Maven project

If these are configured you should be able to run the application by right clicking on RomanNumeralConversion.java and running as a Java application.  You will also be able to run the AppTest.java file as a JUnit test or choose test methods in that class and run them individually via a JUnit plugin.

## Running the tests

If your environment is properly setup with Java and Maven, you can open up a shell/console/terminal window.  Change directory to the webcrawler folder.  If you are in the right folder, you will see a pom.xml file.  Now you can type the following from the command line and press <return> to run the Unit Tests:

```
mvn clean test

```

The Unit Tests will run when the project is built as follows:

```
mvn clean install

```
### Break down of tests

Unit tests are in src/test/java/ in the AppTest class.  Listed below are more details on the tests performed.

* testAddition()
    * simple test that summation working properly
* testSubtraction()
    * simple test that subtraction sequences are working
* testNumeralChars()
    * test that only valid numerals are being accepted and that the proper exception is thrown when an invalid character is given
* testBadNumeral()
    * test when correct numerals are given but in a bad sequence

## Deployment

A stand alone executable jar file will be created in the target directory of the project.  This can be copied to anywhere java is available to run the jar from a command line.

```
java -jar <path to jar>numerals-0.0.1-SNAPSHOT.jar <roman numeral string>

```

## Built With

* [Maven](https://maven.apache.org/) - Dependency Management
* [JUnit](https://junit.org/junit5/) - Used for unit testing
* [AWS Lambda](https://aws.amazon.com/lambda/) - Used if deploying as a Lambda service
* [JSON](http://www.JSON.org/) - Used to create responses when deploying as an AWS Lambda service and API Gateway

## Future improvements

* 
