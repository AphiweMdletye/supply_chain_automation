package Logistics;
import Engine.EngineDriver;
import Utils.ExcelUtility;
import org.apache.poi.openxml4j.exceptions.InvalidFormatException;
import org.json.JSONException;
import org.testng.annotations.Test;
import java.lang.reflect.Method;
import java.io.IOException;
import org.json.JSONObject;


public class SuperDemo extends EngineDriver
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

        String jsonBody = "{\n" +
                "  \"Test case\": \"name\",\n" +
                "  \"Location\": {\n" +
                "    \"suburb\": \"test\"\n" +
                "  }\n" +
                "}";

        String suburb = currentTestData.get("Suburb");
        String testcase = currentTestData.get("Test case");

        try
        {
            JSONObject jObject  = new JSONObject(jsonBody);
            jObject.put("Test case",testcase);
            jObject.getJSONObject("Location").put("suburb",suburb);
            System.out.println(jObject);
            System.out.println("--------------------------------");
        }
        catch (JSONException e)
        {
            e.printStackTrace();
        }
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

        String jsonBody = "{\n" +
                "  \"Test case\": \"name\",\n" +
                "  \"Location\": [\n" +
                "    {\n" +
                "      \"Place\": \n" +
                "      {\n" +
                "        \"suburb\": \"test\"\n" +
                "      }\n" +
                "    }\n" +
                "  ]\n" +
                "}";

        String suburb = currentTestData.get("Suburb");
        String testcase = currentTestData.get("Test case");

        try
        {
            JSONObject jObject  = new JSONObject(jsonBody);
            jObject.put("Test case",testcase);
            jObject.getJSONObject("Place").put("suburb",suburb);
            System.out.println(jObject);
            System.out.println("--------------------------------");
        }
        catch (JSONException e)
        {
            e.printStackTrace();
        }
        System.out.print("\n\n");
    }

}
