package Logistics;

import org.apache.poi.openxml4j.exceptions.InvalidFormatException;
import main.Utils.ExcelUtility;
import org.testng.annotations.Test;
import java.lang.reflect.Method;
import java.io.IOException;


public class SenerityDemo
{
    @Test
    public void printTestData(Method method) throws IOException, InvalidFormatException
    {
//        String name =  method.getName();
        String name =  "Creating a Mowbray location";
        String[][] data = ExcelUtility.ReadExcelFile();

        ExcelUtility.getSpecificTestData(name,data);


    }

//    @Test
//    public void printTestData1() throws IOException, InvalidFormatException
//    {
//
//        printTestDataTwo();
//        printTestDataThree();
//
//    }
//
//
//    @Test
//    public void printTestData2() throws IOException, InvalidFormatException
//    {
//
//        printTestDataTFour();
//        printTestDataTwo();
//
//    }



    public void printTestDataTFour()
    {
        System.out.print("This is the dummy test case 4");
    }

    public void printTestDataTwo()
    {
        System.out.print("This is the dummy test case 2");
    }


    public void printTestDataThree()
    {
        System.out.print("This is the dummy test case 3");

    }


}
