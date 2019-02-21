package Logistics;
import Engine.EngineDriver;
import Utils.ExcelUtility;
import org.apache.poi.openxml4j.exceptions.InvalidFormatException;
import org.testng.annotations.Test;
import java.lang.reflect.Method;
import java.io.IOException;


public class SenerityDemo extends EngineDriver
{
    @Test
    public void printTestData()
    {
        System.out.print("printTestData");
        System.out.print("\n"+currentTestData);
        System.out.print("\n\n");
    }

    @Test
    public void CreateMowbrayLocation()
    {
        System.out.print("CreateMowbrayLocation");
        System.out.print("\n"+currentTestData);
        System.out.print("\n\n");
    }

    @Test
    public void CreateRondeboschLocation()
    {
        System.out.print("CreateRondeboschLocation");
        System.out.print("\n"+currentTestData);
        System.out.print("\n\n");

    }
    @Test
    public void CreateLocationWithOutStreetName()
    {
        System.out.print("CreateLocationWithOutStreetName");
        System.out.print("\n"+currentTestData);
        System.out.print("\n\n");

    }

    @Test
    public void CreateWoodstockLocation()
    {
        System.out.print("This is the dummy test case 4");
        System.out.print("\n"+currentTestData);
        System.out.print("\n\n");
    }

}
