package main.Utils.API;

/**
 * @author lionel.mangoua
 * Date: 26/02/19
 */

import main.Engine.API.EngineDriver;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Properties;

/**
 * This class is used to write a function 'returnPropVal' to access the properties file.
 * The function 'returnVal' will pass a key from some other class and will return the value for that key. *
 *
 * @ propertyFilePath - should be absolute from root folder of the project til .properties file
 * i.e for Logistics.properties - "Logistics"
 * for GlobalConfig.properties - "GlobalConfig"
 *
 * How to use it:
 * final PropertyFileReader propObj = new PropertyFileReader();
 * final String str = propObj.returnPropVal("Logistics","create_location_uri");
 */

public class PropertyFileReader extends EngineDriver {

    //Default constructor
    public PropertyFileReader() {
    }

    public String returnPropVal(final String key) {

        //Get a new properties object
        final Properties properties = new Properties();
        String value = null;

        try {
//            properties.load(new FileInputStream("src/main/resources/Logistics.properties")); //TODO works
            properties.load(new FileInputStream("src/main/resources/" + propertyFileName + ".properties"));
            //Get property value based on key:
            value = properties.getProperty(key);
        }
        catch (final FileNotFoundException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
        catch (final IOException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }

        return value;
    }
}
