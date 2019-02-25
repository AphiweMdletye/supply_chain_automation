package Logistics;

/**
 * @author lionel.mangoua
 * Date: 21/02/19
 */

import io.restassured.response.ValidatableResponse;
import main.Config.GlobalEnums;
import main.Engine.API.EngineDriver;
import org.testng.annotations.Test;
import ru.yandex.qatools.allure.annotations.Description;
import ru.yandex.qatools.allure.annotations.Features;
import ru.yandex.qatools.allure.annotations.Stories;
import java.io.IOException;
import static main.Engine.API.CustomHeaders.buildCustomHeaders1;
import static main.Engine.API.CustomHeaders.requestHeaders_Tal;

public class DummyTest extends EngineDriver {

    GlobalEnums.Environment env = GlobalEnums.Environment.TAKEALOT;

    //Payload
    String payload = "{\n" +
                    "        \"street\": \"250 Main Road\",\n" +
                    "        \"suburb\": \"Rondebosch\",\n" +
                    "        \"city\": \"Cape Town\",\n" +
                    "        \"province\": \"Western Cape\",\n" +
                    "        \"postalCode\": \"7441\",\n" +
                    "        \"countryCode\": \"ZA\",\n" +
                    "        \"addressType\": \"RESIDENTIAL\",\n" +
                    "        \"businessName\": \"Test User\",\n" +
                    "        \"complexDetails\": \"created under client 2 home \"\n" +
                    "    }";

    String uri = "clients/" + env.port + "/locations";

    /**
     * This function is to create ID locations
     */
    @Features("LOCATION - Add customer address")
    @Description("LOCATION - Add customer address")
    @Stories("As an api user I should be able to add a customer delivery address")
    @Test(groups = {"LOG"}, enabled = true)
    public void Post_Create_LocationID_Test_201() throws IOException {

        ValidatableResponse vr = postMethod(payload, uri, requestHeaders_Tal());
//        ValidatableResponse vr = postMethod1(payload, uri, buildCustomHeaders1("authorization", authorization));

        //Validate Response
        vr.assertThat().statusCode(201);
        vr.spec(responseSpec);
    }
}
