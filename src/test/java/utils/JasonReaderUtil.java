package utils;

import com.google.gson.Gson;
import com.google.gson.JsonElement;
import com.google.gson.JsonParser;
import datamodel.TestData;

import java.io.FileNotFoundException;
import java.io.FileReader;

public class JasonReaderUtil {

    public static TestData[] getTestDataFromJasonArray() throws FileNotFoundException {
        JsonElement root = new JsonParser().parse(new FileReader(System.getProperty("user.dir") + "/src/main/resources/testData/testData.json"));
        Gson gson = new Gson();
        TestData[] testData = gson.fromJson(root, TestData[].class);
        return testData;

    }


    public static TestData[] getRandomTestDataFromJasonArray() throws FileNotFoundException {
        JsonElement root = new JsonParser().parse(new FileReader(System.getProperty("user.dir") + "/src/main/resources/testData/complexTestData.json"));
        Gson gson = new Gson();
        TestData[] testData = gson.fromJson(root, TestData[].class);
        return testData;

    }
}
