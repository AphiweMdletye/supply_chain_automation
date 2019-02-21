package Logistics;





import org.jruby.ext.stringio.StringIO$INVOKER$i$0$0$string;

import java.util.HashMap;
import java.util.Map;

public class CreateHashMapExample {


    // Creating a HashMap
    public static Map<String, String> numberMapping = new HashMap<>();
    public static String pContentTypeHeader;


    public static void buildCustomHeaders(String headerKey, String headerValue){

        //
        numberMapping.put(headerKey, headerValue);
        // Adding key-value pairs to a HashMap
        numberMapping.put("Content-Type", "application/json");
        /*System.out.println(numberMapping);
        System.out.println(numberMapping);*/

    }



    //Get one single header
    public static String getContentTypeHeader(){

        pContentTypeHeader = numberMapping.get ("Content-Type");

        return pContentTypeHeader;
    }



    //Get all  headers
    public static Map getAllHeader(){

        return numberMapping;
    }




}