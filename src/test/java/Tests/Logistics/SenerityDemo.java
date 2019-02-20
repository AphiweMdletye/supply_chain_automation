package Logistics;


import org.apache.poi.openxml4j.exceptions.InvalidFormatException;
//import org.junit.Test;
import Utils.ExcelUtility;
import org.testng.annotations.Test;

import java.io.IOException;

public class SenerityDemo
{
    @Test
    public void printTestData() throws IOException, InvalidFormatException
    {

        String s = ExcelUtility.ReadExcelFile();
        System.out.print("This is the dummy test case 1");
    }

    @Test
    public void printTestDataTwo()
    {
        System.out.print("This is the dummy test case 2");
    }

    @Test
    public void printTestDataThree()
    {
        System.out.print("This is the dummy test case 3");

    }
}
