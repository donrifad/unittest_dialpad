#Number Pad Problem

This is a maven project tests are in test package and application is in java package

##Tests desighn aproach
The application can take infinitive numbers as inputs and it is not possible to test all combination.
Use few boundry values and equlance partioning values.

##Tests
TelephoneDialPadTest calss contain three test methods
1.testValidSingleInputs - test input [0-9] - Data providers are used
2.testNegativeInputs - test input [abcd]
3.testRandomInputs - test input [[99,101,99,1001,9999,12345,56789] - Data providers are used


##Run The Tests
approach 1:

In inteliJ right click on the test class and run as testng
Before running the tests you  goto edit configuration=>set listners as default.
This will generate the report in output folder

approach 2:
Run
```bash
mvn clean install -DskipTests=true
mvn clean test -Pregression -Dsuite=smokesuite
```
This will generate a report inside target folder called surefire reports