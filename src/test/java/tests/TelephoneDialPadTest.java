package tests;

import application.TelephoneDialPad;
import datamodel.TestData;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;
import utils.CombinationUtil;
import utils.JasonReaderUtil;

import java.io.FileNotFoundException;
import java.util.Arrays;
import java.util.List;
import java.util.logging.Logger;

public class TelephoneDialPadTest {

    private static final Logger logger = Logger.getLogger(TelephoneDialPadTest.class.getName());


    /**
     *
     * @param data
     * @throws FileNotFoundException
     * description - test valid inputs from(0-9)
     * test data - Is retrieved from test data json
     */
    @Test(dataProvider="getData",priority = 0)
    public void testValidSingleInputs(TestData data) throws FileNotFoundException  {

        SoftAssert softAssert = new SoftAssert();


        logger.info("...input data ..... "+data.input);
        logger.info("... expected out put data.... "+data.expectedOutPut);


        int expectedCombinations = CombinationUtil.getNoOfPossibleCombination(data.input);
        List<String> actualCombination = TelephoneDialPad.retrieveCombinations(data.input);

        softAssert.assertEquals(actualCombination.size(),expectedCombinations,"Both combinations should be equal");

        char[] expectedOutCharacters = data.expectedOutPut.toCharArray();

        for (int i = 0; i < expectedOutCharacters.length; i++) {
            softAssert.assertEquals(actualCombination.get(i), String.valueOf(expectedOutCharacters[i]), "data index:["+ i+"] Both should be equal");
        }

        softAssert.assertAll();

    }

    /**
     * validating negative value - system is throwing a null pointer exception
     */
    @Test(expectedExceptions = NumberFormatException.class,priority = 1)
    public void testNegativeInputs(){
        String dataToTest = "ASD";
        logger.info("...input data ..... "+dataToTest);
        List<String> actualCombination = TelephoneDialPad.retrieveCombinations(dataToTest);
    }


    /**
     *
     * @param data
     * @throws FileNotFoundException
     * description - test valid inputs from(101,99,1001,9999,12345,6789)
     * test data - Is retrieved from complex test data json
     */
    @Test(dataProvider="getRandomData",priority = 2 )
    public void testRandomInputs(TestData data) {
        SoftAssert softAssert = new SoftAssert();

        logger.info("...input data ..... "+data.input);
        logger.info("... expected out put data.... "+data.expectedOutPut);

        int expectedCombinations = CombinationUtil.getNoOfPossibleCombination(data.input);
        List<String> actualCombination = TelephoneDialPad.retrieveCombinations(data.input);

        softAssert.assertEquals(actualCombination.size(),expectedCombinations,"Both combinations should be equal");

        String[] expectedOutCharacters = data.expectedOutPut.split(",");

        for (int i = 0; i < expectedOutCharacters.length; i++) {
            softAssert.assertEquals(actualCombination.get(i), expectedOutCharacters[i], "data index:["+ i+"] Both should be equal");
        }

        softAssert.assertAll();
    }


    /**
     *
     * @return data json array from resources testData.json
     * @throws FileNotFoundException
     */
    @DataProvider
    public Object[][] getData() throws FileNotFoundException {
        List<TestData> testDataDataList = Arrays.asList(JasonReaderUtil.getTestDataFromJasonArray());
        Object[][] testDataJasonArray = new Object[testDataDataList.size()][];

        for (int i = 0; i < testDataDataList.size(); i++) {
            testDataJasonArray[i] = new Object[1];
            testDataJasonArray[i][0] = testDataDataList.get(i);
        }
        return testDataJasonArray;
    }

    /**
     *
     * @return data json array from resources complexData.json
     * @throws FileNotFoundException
     */
    @DataProvider
    public Object[][] getRandomData() throws FileNotFoundException {
        List<TestData> testDataDataList = Arrays.asList(JasonReaderUtil.getRandomTestDataFromJasonArray());
        Object[][] testDataJasonArray = new Object[testDataDataList.size()][];

        for (int i = 0; i < testDataDataList.size(); i++) {
            testDataJasonArray[i] = new Object[1];
            testDataJasonArray[i][0] = testDataDataList.get(i);
        }
        return testDataJasonArray;
    }
}
