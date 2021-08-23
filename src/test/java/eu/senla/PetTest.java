package eu.senla;

import eu.senla.endpoint.EndPointPet;
import eu.senla.model.Category;
import eu.senla.model.Pet;
import eu.senla.model.TagPet;
import eu.senla.utilsAPI.MethodsParse;

import org.junit.jupiter.api.*;

import java.io.File;
import java.util.ArrayList;
import java.util.Collections;

import static io.restassured.module.jsv.JsonSchemaValidator.matchesJsonSchema;
import static org.junit.jupiter.api.Assertions.*;


@TestInstance(TestInstance.Lifecycle.PER_CLASS)
public class PetTest extends BaseClass{
    private static  File jsonSchema = new File("src/test/resources/json/petJson.json");

    @Test
    @DisplayName("Check to GET request")
    public void getRequestTest(){
    response = setRequestGet(EndPointPet.STATUS + "?status=available");
    String actualStatus = MethodsParse.getJsonArrayFromResponse(response).get(5)
            .getAsJsonObject()
            .get("status")
            .getAsString();
    String expectedStatus = "available";
        assertEquals(expectedStatus, actualStatus);
    }
    @Test
    @DisplayName("Check to POST request")
    public void postRequestTest(){
        TagPet tag = new TagPet(25, "Bengal cat");
        Category category = new Category(1, "Cat");
        Pet pet = new Pet(1234, category, "Mouse", new ArrayList<>(), new ArrayList<>(Collections.singletonList(tag)), "available");
        setRequestPost(EndPointPet.PET, pet)
                .then()
                .assertThat()
                .body(matchesJsonSchema(jsonSchema));
    }
    @Test
    @DisplayName("Check to PUT request")
    public void putRequestTest(){
        TagPet tag = new TagPet(31, "Norwegian cat");
        Category category = new Category(3, "Cat");
        Pet pet = new Pet(1234, category, "Alice", new ArrayList<>(), new ArrayList<>(Collections.singletonList(tag)), "available");
        setRequestPut(EndPointPet.PET, pet)
                .then()
                .assertThat()
                .body(matchesJsonSchema(jsonSchema));
    }
    @Test
    @DisplayName("Check to Delete request")
    public void deleteRequestTest(){
    setRequestDelete(EndPointPet.PET + "/1234");
    response = setRequestGet(EndPointPet.PET + "/1234");
    response.prettyPrint();
    }
}
