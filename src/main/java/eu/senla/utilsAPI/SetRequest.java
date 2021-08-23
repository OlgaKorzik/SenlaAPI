package eu.senla.utilsAPI;

import eu.senla.model.Pet;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;

import static io.restassured.RestAssured.given;

public class SetRequest {
    protected static RequestSpecification requestSpecification = PetAPISpecification.getReguestSpecification();
    protected Response response = null;

    protected Response setRequestGet(String url){
        response = given()
                .spec(requestSpecification)
                .when()
                .get(url);
        return response;
    }
    protected Response setRequestPost(String url, Pet pet){
        response = given()
                .spec(requestSpecification)
                .when()
                .body(pet)
                .post(url);
        return response;
    }
    protected Response setRequestPut(String url, Pet pet){
        response = given()
                .spec(requestSpecification)
                .when()
                .body(pet)
                .put(url);
        return response;
    }
    protected Response setRequestDelete(String url){
        response = given()
                .spec(requestSpecification)
                .when()
                .delete(url);
        return response;
    }

}
