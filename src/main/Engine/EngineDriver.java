package main.Engine;

/**
 * @author chris
 * Date: 21/02/19
 */

import main.Utils.ExcelUtility;
import io.qameta.allure.restassured.AllureRestAssured;
import io.restassured.RestAssured;
import io.restassured.builder.RequestSpecBuilder;
import io.restassured.builder.ResponseSpecBuilder;
import io.restassured.response.Response;
import io.restassured.response.ValidatableResponse;
import io.restassured.specification.RequestSpecification;
import io.restassured.specification.ResponseSpecification;
import org.apache.log4j.PropertyConfigurator;
import org.apache.poi.openxml4j.exceptions.InvalidFormatException;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import java.io.IOException;
import java.lang.reflect.Method;
import java.util.LinkedHashMap;
import java.util.Map;
import java.util.Properties;
import java.util.concurrent.TimeUnit;
import static io.restassured.RestAssured.given;
import static org.hamcrest.Matchers.lessThan;

public class EngineDriver {

    public static final String XLSX_FILE_PATH = "src/main/DataFiles/userData.xlsx";
    public static String[][] excelData = null;
    public Map<String, String> currentTestData = null;

    public static final  String FOOD = "1"; //MrD
    public static final  String SUPERBALIST = "2";
    public static final String TAKEALOT = "3";
    public static final String GENERAL = "4";
    //Header
    public static String propertyFileName = System.getProperty("propertyFileName");
    public static String authorization = "Basic bXJkMjp6K01RYWNeP1RyTSZFKH52RzkyVV95";
    public static String postmanToken = "d49b2126-380e-5d97-9daa-6486d8e5f4ac";
    public static String contentType = "application/json";
    public static String cacheControl = "no-cache";
    public static Response res = null;
    public static ValidatableResponse response = null;
    public static RequestSpecBuilder builder;
    public static RequestSpecification requestSpec;
    public static ResponseSpecBuilder respec;
    public static ResponseSpecification responseSpec;
    //Locations
    public static final String MONTAGUE = "5428707"; //CPT Warehouse Location Id
    public static final String JHB = "000000"; //CPT Warehouse Location Id
    public static final int CLIENT_ID_SUPERBALIST = 2;
    public static final int CLIENT_ID_TAKEALOT = 3;

    @BeforeClass
    public void startEngine() throws IOException, InvalidFormatException {

        excelData = ExcelUtility.ReadExcelFile("Locations");

        //region <To remove the warning: "log4j:WARN No appenders could be found for logger">
        Properties prop = new Properties();
        prop.setProperty("log4j.rootLogger", "WARN");
        PropertyConfigurator.configure(prop);
        //endregion

        main.Config.GlobalEnums.Environment env = main.Config.GlobalEnums.Environment.TAKEALOT;

        RestAssured.baseURI = env.base_Url;
        RestAssured.basePath = env.path;

        builder = new RequestSpecBuilder();
        respec = new ResponseSpecBuilder();

        builder.addFilter(new AllureRestAssured());//To setup Filter that gonna attach Request/Response logs to report

        respec.expectResponseTime(lessThan(10L), TimeUnit.SECONDS);

        requestSpec = builder.build();
        responseSpec = respec.build();
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

        System.out.println("Number of rows: " + numRows);
        System.out.println("Number of columns: " + numCols);

        for (int i = 0; i < numRows; i++) {
            if (excelData[i][0].toString().equals(testName)) {
                for (int j = 0; j < numCols; j++) {
                    currentTestData.put(excelData[0][j], excelData[i][j]);
                }
            }
        }
        return currentTestData;
    }

    public static RequestSpecification requestHeaders() {

        RequestSpecification headers = null;

        builder = new RequestSpecBuilder();
        respec = new ResponseSpecBuilder();

        builder.addHeader("authorization", authorization);
        builder.addHeader("postman-token", postmanToken);
        builder.addHeader("content-type", contentType);
        builder.addHeader("cache-control", cacheControl);
        respec.expectHeader("content-type", contentType);

        headers = builder.build();
        responseSpec = respec.build();

        return headers;
    }

    public ValidatableResponse postMethod(String payload, String endpoint, RequestSpecification header) {

        response =
                given().
                        spec(requestSpec).
                        spec(header).
                        body(payload).
                        log().all().
                when().
                        post(endpoint).
                then().
                        log().all();
        return response;
    }
}
