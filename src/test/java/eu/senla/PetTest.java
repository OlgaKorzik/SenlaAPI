package eu.senla;

import eu.senla.endpoint.EndPointPet;
import eu.senla.model.Pet;
import eu.senla.utilsAPI.DataForTest;
import eu.senla.utilsAPI.MethodsParse;

import org.junit.jupiter.api.*;

import java.io.File;


import static eu.senla.utilsAPI.DataForTest.*;
import static io.restassured.module.jsv.JsonSchemaValidator.matchesJsonSchema;
import static org.junit.jupiter.api.Assertions.*;


@TestInstance(TestInstance.Lifecycle.PER_CLASS)
public class PetTest extends BaseClass{
    private static  File jsonSchema = new File(JSON_SCHEMA_FILE);

    @Test
    @Order(1)
    @DisplayName("Check to GET request")
    public void getRequestTest(){
    response = setRequestGet(EndPointPet.STATUS_AVAILABLE);
    String actualStatus = MethodsParse.getJsonArrayFromResponse(response).get(0)
            .getAsJsonObject()
            .get("status")
            .getAsString();
    String expectedStatus = "available";
        assertEquals(expectedStatus, actualStatus);
    }
    @Test
    @Order(2)
    @DisplayName("Check to POST request")
    public void postRequestTest(){
        Pet pet = DataForTest.getPetForPostTet();
        setRequestPost(EndPointPet.PET, pet)
                .then()
                .assertThat()
                .body(matchesJsonSchema(jsonSchema));
    }
    @Test
    @Order(3)
    @DisplayName("Check to PUT request")
    public void putRequestTest(){
        Pet pet = DataForTest.getPetForPutTest();
        setRequestPut(EndPointPet.PET, pet)
                .then()
                .assertThat()
                .body(matchesJsonSchema(jsonSchema));
    }
    @Test
    @Order(4)
    @DisplayName("Check to Delete request")
    public void deleteRequestTest(){
        String id = DataForTest.getIdPetForPutTest();
        setRequestDelete(EndPointPet.PET +"/"+ id);
        response = setRequestGet(EndPointPet.PET +"/"+ id);
        String actualMessage = MethodsParse.getMessageFromJson(response);
        String expectedMessage = "Pet not found";
        assertEquals(expectedMessage,actualMessage,"Pet don't delete");
    }
}
