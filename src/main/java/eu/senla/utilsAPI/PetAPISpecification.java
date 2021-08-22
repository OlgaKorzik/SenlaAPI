package eu.senla.utilsAPI;

import eu.senla.endpoint.EndPointPet;
import io.restassured.builder.RequestSpecBuilder;
import io.restassured.filter.log.LogDetail;
import io.restassured.http.ContentType;
import io.restassured.specification.RequestSpecification;

public class PetAPISpecification {
    public static RequestSpecification getReguestSpecification(){
        return new RequestSpecBuilder()
                .setBaseUri(EndPointPet.BASE_URI)
                .setContentType(ContentType.JSON)
                .log(LogDetail.METHOD)
                .log(LogDetail.URI)
                .log(LogDetail.BODY)
                .log(LogDetail.HEADERS)
                .build();

    }
}
