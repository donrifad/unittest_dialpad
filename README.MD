<h1>Number Pad Problem</h1>

This is a maven project tests are in test package and application is in java package

<h2>Tests desighn aproach</h2>
<br>The application can take infinitive numbers as inputs and it is not possible to test all combination.
<br>Use few boundry values and equlance partioning values.

<h2>Tests</h2>
<br>TelephoneDialPadTest calss contain three test methods
<br>1.testValidSingleInputs - test input [0-9] - Data providers are used
<br>2.testNegativeInputs - test input [abcd]
<br>3.testRandomInputs - test input [[99,101,99,1001,9999,12345,56789] - Data providers are used


<h2>Run The Tests</h2>
<br>approach 1:

<br>In inteliJ right click on the test class and run as testng
<br>Before running the tests you  goto edit configuration=>set listners as default.
<br>This will generate the report in output folder

<br>approach 2:
<br>Run
```bash
mvn clean install -DskipTests=true
mvn clean test -Pregression -Dsuite=smokesuite
```
<br>This will generate a report inside target folder called surefire reports
