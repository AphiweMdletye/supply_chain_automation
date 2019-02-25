package main.Engine.API;

/**
 * The CustomHeaders program/class implements an application that
 * simply build headers E.g. "content-type":"application/json" can be build by calling the buildCustomHeaders(String headerKey, String headerValue).
 * Users can also hard to headers ones off in the buildCustomHeaders() method.
 *
 * @author Ryno Hoorn
 * @version 1.0
 * @since 2019-02-22
 */

import io.restassured.builder.RequestSpecBuilder;
import io.restassured.builder.ResponseSpecBuilder;
import io.restassured.specification.RequestSpecification;
import java.util.HashMap;
import java.util.Map;
import static main.Engine.API.EngineDriver.*;

public class CustomHeaders {

    //Creating a HashMap
    public static Map<String, String> customHeadersMap = new HashMap<>();
    public static String pContentTypeHeader;

    //This method allow you add header to headersMaps
    public static void buildCustomHeaders(String headerKey, String headerValue) {

        // Adding key-value pairs to a HashMap
        customHeadersMap.put(headerKey, headerValue);
    }

    //This method allow you add header to headersMaps
    public static Map buildCustomHeaders1(String headerKey, String headerValue) {

        // Adding key-value pairs to a HashMap
        customHeadersMap.put(headerKey, headerValue);

        return customHeadersMap;
    }

    //Hard code header could be done in this method
    public static void buildCustomHeaders() {

        // Adding key-value pairs to a HashMap
        customHeadersMap.put("authorization", authorization);
        customHeadersMap.put("postman-token", postmanToken);
        customHeadersMap.put("content-type", contentType);
        customHeadersMap.put("cache-control", cacheControl);
        customHeadersMap.put("content-type", contentType);
    }

    //Hard code header could be done in this method
    public static RequestSpecification requestHeaders_Tal() {

        RequestSpecification headers = null;

        builder = new RequestSpecBuilder(); 

        builder.addHeader("authorization", authorization);
        builder.addHeader("postman-token", postmanToken);
        builder.addHeader("content-type", contentType);
        builder.addHeader("cache-control", cacheControl);
        respec.expectHeader("content-type", contentType);

        headers = builder.build();

        return headers;
    }

    //Get one single header
    public static String getContentTypeHeader(String singleHeader) {

        pContentTypeHeader = customHeadersMap.get(singleHeader);

        return pContentTypeHeader;
    }

    //Get all headers
    public static Map getAllHeader() {

        return customHeadersMap;
    }
}
