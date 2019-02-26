package Logistics;

/**
 * @author chris
 * Date: 21/02/19
 */
//
import com.google.gson.*;


import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;
import main.Engine.API.EngineDriver;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;
import org.testng.annotations.Test;
//import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;
import org.python.core.PyInstance;
import org.python.util.PythonInterpreter;
import org.python.core.PyObject;


import java.util.Iterator;

public class SuperDemo extends EngineDriver {

    //    @Test(enabled = true)
//    public void printTestData() {
//
//        System.out.print("printTestData");
//        System.out.print("\n" + currentTestData);
//        System.out.print("\n\n");
//    }
//
//    @Test(enabled = true)
//    public void CreateMowbrayLocation() {
//
//        System.out.print("CreateMowbrayLocation");
//        System.out.print("\n" + currentTestData);
//        System.out.print("\n\n");
//
//        String jsonBody = "{\n" +
//                "  \"Test case\": \"name\",\n" +
//                "  \"Location\": {\n" +
//                "    \"suburb\": \"test\"\n" +
//                "  }\n" +
//                "}";
//
//        String suburb = currentTestData.get("Suburb");
//        String testcase = currentTestData.get("Test case");
//
//        try {
//            JSONObject jObject = new JSONObject(jsonBody);
//            jObject.put("Test case", testcase);
//            jObject.getJSONObject("Location").put("suburb", suburb);
//            System.out.println(jObject);
//            System.out.println("--------------------------------");
//        } catch (JSONException e) {
//            e.printStackTrace();
//        }
//        System.out.print("\n\n");
//    }
//
//    @Test(enabled = true)
//    public void CreateRondeboschLocation() {
//
//        System.out.print("CreateRondeboschLocation");
//        System.out.print("\n" + currentTestData);
//        System.out.print("\n\n");
//    }
//
//    @Test(enabled = true)
//    public void CreateLocationWithOutStreetName() {
//
//        System.out.print("CreateLocationWithOutStreetName");
//        System.out.print("\n" + currentTestData);
//        System.out.print("\n\n");
//    }
    public static boolean found = false;
    public static int position = 0;
    public static int countPosition = 0;
    PythonInterpreter interpreter = null;
    @Test(enabled = true)
    public void CreateWoodstockLocation()  throws Exception {

        System.out.print("This is the dummy test case 4");
        System.out.print("\n" + currentTestData);
        System.out.print("\n\n");

        String jsonBody = "{\n" +
                "  \"instructions\": [\n" +
                "    {\n" +
                "      \"shipments\": [\n" +
                "        {\n" +
                "          \"source\": {\n" +
                "            \"locationId\": 5428707\n" +
                "          },\n" +
                "          \"target\": {\n" +
                "            \"locationId\": 7331533\n" +
                "          },\n" +
                "          \"items\": [\n" +
                "            {\n" +
                "              \"description\": \"Fitbit\",\n" +
                "              \"goodsType\": \"NORMAL\",\n" +
                "              \"volumetrics\": {\n" +
                "                \"height\": 10,\n" +
                "                \"width\": 10,\n" +
                "                \"length\": 10,\n" +
                "                \"weight\": 1\n" +
                "              },\n" +
                "              \"value\": 100.55,\n" +
                "              \"quantity\": 1\n" +
                "            }\n" +
                "          ],\n" +
                "          \"dates\": {\n" +
                "            \"shipBy\": 1547478000000\n" +
                "          },\n" +
                "          \"kyc\": [],\n" +
                "          \"price\": 100\n" +
                "        }\n" +
                "      ]\n" +
                "    }\n" +
                "  ],\n" +
                "  \"client\": {\n" +
                "    \"id\": 3\n" +
                "  },\n" +
                "  \"deliveryType\": \"DELIVERY\",\n" +
                "  \"offered\": 1547416800000\n" +
                "}\n";

        String street = currentTestData.get("Street");
        String suburb = currentTestData.get("Suburb");
        String city = currentTestData.get("City");
        String province = currentTestData.get("Province");
        String postalCode = currentTestData.get("postalCode");
        String testcase = currentTestData.get("Test case");


        String payload = "{\n" +
                "        \"street\": \""+street+"\",\n" +
                "        \"suburb\": \""+suburb+"\",\n" +
                "        \"city\": \""+city+"\",\n" +
                "        \"province\": \""+province+"\",\n" +
                "        \"postalCode\": \""+postalCode+"\",\n" +
                "        \"countryCode\": \""+currentTestData.get("CountryCode")+"\",\n" +
                "        \"addressType\": \""+currentTestData.get("AddressType")+"\",\n" +
                "        \"businessName\": \""+currentTestData.get("BusinessName")+"\",\n" +
                "        \"complexDetails\": \""+currentTestData.get("ComplexDetails")+" \"\n" +
                "    }";

        try
        {
            JSONObject jObject = new JSONObject(jsonBody);
            jObject.put("deliveryType", testcase);


//            position = 0;
//            JSONObject j =  function(jObject,"goodsType","SUPER");

//            position = 0;
//            JSONObject k =  function(jObject ,"locationId","1");

            position = 2;
            JSONObject m =  function(jObject,"locationId","2");


            System.out.println("--------------------------------");

//            System.out.println(j);

            System.out.println("--------------------------------");
//            System.out.println(k);

            System.out.println("--------------------------------");

            System.out.println(m);

            System.out.println("--------------------------------");
        }
        catch (JSONException e)
        {
            e.printStackTrace();
        }
        System.out.print("\n\n");
    }




    public static JSONObject function(JSONObject obj, String keyMain, String newValue) throws Exception {
        // We need to know keys of Jsonobject
        Iterator iterator = obj.keys();
        String key = null;
        while (iterator.hasNext() && found == false && position ==countPosition)
        {
            key = (String) iterator.next();
            // if object is just string we change value in key
            if ((obj.optJSONArray(key)==null) && (obj.optJSONObject(key)==null))
            {
                if ((key.equals(keyMain)) && position ==countPosition)
                {
                    // put new value
                    countPosition++;
                    obj.put(key, newValue);
                    found = true;
                    return obj;
                }
            }

            // if it's jsonobject
            if (obj.optJSONObject(key) != null)
            {
                function(obj.getJSONObject(key), keyMain, newValue);
            }

            // if it's jsonarray
            if (obj.optJSONArray(key) != null)
            {
                JSONArray jArray = obj.getJSONArray(key);
                for (int i=0;i<jArray.length();i++)
                {
                    function(jArray.getJSONObject(i), keyMain, newValue);
                }
            }
        }
        return obj;
    }


}
