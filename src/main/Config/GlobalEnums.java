package main.Config;

/**
 * @author lionel.mangoua
 * Date: 21/02/19
 */

public class GlobalEnums {

    public enum Environment {

        TAKEALOT("https://uat-api2.mrdcourier.com","/api/","3", "takealot"),
        MrD("https://uat-api2-food.mrdcourier.com","/api/","1","mrD"),
        SUPERBALIST("","2","/api/","superbalist");

        public final String base_Url, path, port, environmentName;

        //Setters
        Environment(String base_Url, String path, String port, String environmentName) {
            this.base_Url = base_Url;
            this.path = path;
            this.port = port;
            this.environmentName = environmentName;
        }
    }
}