package test;

import io.restassured.module.jsv.JsonSchemaValidator;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;
import org.testng.annotations.Test;


import static helpers.Helpers.*;


public class ResponseSchemaTests {



    @Test
    public void GetAllUsersSchemaTest(){
        String url = "http://localhost:8080/users/get/all";
        RequestSpecification request = buildRequest() ;
        Response response =
                executeGetRequest(request, url);
                        response.then()
                        .log().all()
                        .statusCode(200)
                        .body(JsonSchemaValidator.matchesJsonSchemaInClasspath("schema/usersAll.json"));
    }

    @Test
    public void GetUserSchemaTest(){
        String url = "http://localhost:8080/users/get/1";
        RequestSpecification request = buildRequest() ;
        Response response =
                executeGetRequest(request, url);
        response.then()
                .log().all()
                .statusCode(200)
                .body(JsonSchemaValidator.matchesJsonSchemaInClasspath("schema/users.json"));
    }

    @Test
    public void GetUserMobileSchemaTest(){
        String url = "http://localhost:8080/users/1";
        RequestSpecification request = buildRequest() ;
        Response response =
                executeGetRequest(request, url);
        response.then()
                .log().all()
                .statusCode(200)
                .body(JsonSchemaValidator.matchesJsonSchemaInClasspath("schema/users.json"));
    }


}
