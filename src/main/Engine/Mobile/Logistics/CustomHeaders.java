package main.Engine.Mobile.Logistics;

import java.util.HashMap;
import java.util.Map;


/**
 * The CustomHeaders program/class implements an application that
 * simply build headers E.g. "content-type":"application/json" can be build by calling the buildCustomHeaders(String headerKey, String headerValue).
 * Users can also hard to headers ones off in the buildCustomHeaders() method.
 *
 * @author  Ryno Hoorn
 * @version 1.0
 * @since   2019-02-22
 */

public class CustomHeaders {

    // Creating a HashMap
    public static Map<String, String> customHeadersMap = new HashMap<>();
    public static String pContentTypeHeader;


    //This mothod allow you add header to headersMaps
    public static void buildCustomHeaders(String headerKey, String headerValue)
    {

        // Adding key-value pairs to a HashMap
        customHeadersMap.put(headerKey, headerValue);

    }


    //Hard code header could be done in this method
    public static void buildCustomHeaders(){

        // Adding key-value pairs to a HashMap
        customHeadersMap.put("Content-Type", "application/json");

    }



    //Get one single header
    public static String getContentTypeHeader(String singleHeader)
    {

        pContentTypeHeader = customHeadersMap.get (singleHeader);

        return pContentTypeHeader;
    }



    //Get all  headers
    public static Map getAllHeader()
    {

        return customHeadersMap;
    }


}
