//package main.Utils.API;
//
///**
// * @author lionel.mangoua
// * Date: 21/02/19
// */
//
//import io.qameta.allure.restassured.AllureRestAssured;
//import io.restassured.RestAssured;
//import io.restassured.builder.RequestSpecBuilder;
//import io.restassured.builder.ResponseSpecBuilder;
//import io.restassured.response.Response;
//import io.restassured.response.ValidatableResponse;
//import io.restassured.specification.RequestSpecification;
//import io.restassured.specification.ResponseSpecification;
//import main.Config.GlobalEnums;
//import org.apache.log4j.PropertyConfigurator;
//import org.joda.time.Days;
//import org.testng.annotations.BeforeClass;
//
//import java.util.Properties;
//import java.util.concurrent.TimeUnit;
//import static io.restassured.RestAssured.given;
//import static org.hamcrest.Matchers.lessThan;
//
//public class AbstractTestBase {
//
//    public static final  String FOOD = "1"; //MrD
//    public static final  String SUPERBALIST = "2";
//    public static final String TAKEALOT = "3";
//    public static final String GENERAL = "4";
//    //Header
//    public static String API_HOST = System.getProperty("API_HOST");
//    public static String propertyFileName = System.getProperty("propertyFileName");
//    public static String authorization = "Basic bXJkMjp6K01RYWNeP1RyTSZFKH52RzkyVV95";
//    public static String postmanToken = "d49b2126-380e-5d97-9daa-6486d8e5f4ac";
//    public static String contentType = "application/json";
//    public static String cacheControl = "no-cache";
//    public static Response res = null;
//    public static ValidatableResponse response = null;
//    public static RequestSpecBuilder builder;
//    public static RequestSpecification requestSpec;
//    public static ResponseSpecBuilder respec;
//    public static ResponseSpecification responseSpec;
//    //Locations
//    public static final String MONTAGUE = "5428707"; //CPT Warehouse Location Id
//    public static final String JHB = "000000"; //CPT Warehouse Location Id
//    public static final int CLIENT_ID_SUPERBALIST = 2;
//    public static final int CLIENT_ID_TAKEALOT = 3;
//    //Options
//    public static final String STANDARD = "STANDARD";
//    public static final String GUARANTEED_EXPRESS = "GUARANTEED_EXPRESS";
//    public static final String SAME_DAY = "SAME_DAY";
//    public static final String WEEKEND_SATURDAY = "WEEKEND_SATURDAY";
//    public static final String WEEKEND_SUNDAY = "WEEKEND_SUNDAY";
//    public static final String CREATED_STATE = "CREATED";
//    public static final String RESERVED_STATE = "RESERVED";
//    public static final String ACTIONED_STATE = "ACTIONED";
//    //    public static String shipBy;
////    public static String offeredBy;
//    //Parcel
//    public static final String BARCODE_SUP = "B";
//    public static final String BARCODE_TAL = "S";
//    public static final String CPT_WAREHOUSE = "cpt";
//    public static final String JHB_WAREHOUSE = "jhb";
//    //Systems
//    public static final String SYSTEM_SUP = "Sup";
//    public static final String SYSTEM_TAL = "Tal";
//    public static final String SYSTEM_MrD = "MrD";
//    public static final String SYSTEM_FNB = "FNB";
//
//    @BeforeClass
//    public void setup() {
//
//        //region <To remove the warning: "log4j:WARN No appenders could be found for logger">
//        Properties prop = new Properties();
//        prop.setProperty("log4j.rootLogger", "WARN");
//        PropertyConfigurator.configure(prop);
//        //endregion
//
//        GlobalEnums.Environment env = GlobalEnums.Environment.TAKEALOT;
//
//        RestAssured.baseURI = env.base_Url;
//        RestAssured.basePath = env.path;
//
//        builder = new RequestSpecBuilder();
//        respec = new ResponseSpecBuilder();
//
//        builder.addFilter(new AllureRestAssured());//To setup Filter that gonna attach Request/Response logs to report
//
//        respec.expectResponseTime(lessThan(10L), TimeUnit.SECONDS);
//
//        requestSpec = builder.build();
//        responseSpec = respec.build();
//    }
//
//    public static RequestSpecification requestHeaders() {
//
//        RequestSpecification headers = null;
//
//        builder = new RequestSpecBuilder();
//        respec = new ResponseSpecBuilder();
//
//        builder.addHeader("authorization", authorization);
//        builder.addHeader("postman-token", postmanToken);
//        builder.addHeader("content-type", contentType);
//        builder.addHeader("cache-control", cacheControl);
//        respec.expectHeader("content-type", contentType);
//
//        headers = builder.build();
//        responseSpec = respec.build();
//
//        return headers;
//    }
//
//    public ValidatableResponse postMethod(String payload, String endpoint, RequestSpecification header) {
//
//        response =
//                given().
//                        spec(requestSpec).
//                        spec(header).
//                        body(payload).
//                        log().all().
//                when().
//                        post(endpoint).
//                then().
//                        log().all();
//        return response;
//    }
//}
