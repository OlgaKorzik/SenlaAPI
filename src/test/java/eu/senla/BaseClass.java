package eu.senla;

import eu.senla.endpoint.EndPointPet;
import eu.senla.utilsAPI.SetRequest;
import org.junit.jupiter.api.BeforeAll;

import static io.restassured.RestAssured.*;

public class BaseClass extends SetRequest {

    @BeforeAll
    public void setUp(){
        response = given()
                .spec(requestSpecification)
                .when()
                .get(EndPointPet.PET);
    }

}
