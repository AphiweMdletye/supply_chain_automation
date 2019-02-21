package Logistics;

/**
 * @author chris
 * Date: 21/02/19
 */

//import Engine.EngineDriver;
import main.Engine.EngineDriver;
import org.testng.annotations.Test;


public class SenerityDemo extends EngineDriver {

    @Test(enabled = false)
    public void printTestData() {
        System.out.print("printTestData");
        System.out.print("\n" + currentTestData);
        System.out.print("\n\n");
    }

    @Test(enabled = false)
    public void CreateMowbrayLocation() {
        System.out.print("CreateMowbrayLocation");
        System.out.print("\n" + currentTestData);
        System.out.print("\n\n");
    }

    @Test(enabled = false)
    public void CreateRondeboschLocation() {
        System.out.print("CreateRondeboschLocation");
        System.out.print("\n" + currentTestData);
        System.out.print("\n\n");

    }

    @Test(enabled = false)
    public void CreateLocationWithOutStreetName() {
        System.out.print("CreateLocationWithOutStreetName");
        System.out.print("\n" + currentTestData);
        System.out.print("\n\n");

    }

    @Test(enabled = false)
    public void CreateWoodstockLocation() {
        System.out.print("This is the dummy test case 4");
        System.out.print("\n" + currentTestData);
        System.out.print("\n\n");
    }
}