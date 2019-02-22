package main.Engine;

import main.Utils.ExcelUtility;
import org.apache.poi.openxml4j.exceptions.InvalidFormatException;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;

import java.io.IOException;
import java.lang.reflect.Method;
import java.util.LinkedHashMap;
import java.util.Map;

public class EngineDriver {
    //
    public static final String XLSX_FILE_PATH = "src/main/DataFiles/userData.xlsx";
    public static String[][] excelData = null;
    public Map<String, String> currentTestData = null;

    @BeforeClass
    public
    void startEngine() throws IOException, InvalidFormatException {
        excelData = ExcelUtility.ReadExcelFile("Locations");
    }


    @BeforeMethod
    public void testSetUp(Method method) {
        String testName = method.getName();
        getSpecificTestData(testName);
    }


    //Method get a specific test case data from the excelData 2D array
    public Map<String, String> getSpecificTestData(String testName) {
        currentTestData = new LinkedHashMap<String, String>();

        int numRows = excelData.length;
        int numCols = excelData[0].length;

        for (int i = 0; i < numRows; i++) {
            if (excelData[i][0].toString().equals(testName)) {
                for (int j = 0; j < numCols; j++) {
                    currentTestData.put(excelData[0][j], excelData[i][j]);

                }
            }

        }
        return currentTestData;
    }
}
