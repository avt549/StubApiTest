package test;

import io.qameta.allure.*;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;
import org.testng.annotations.Test;


import static helpers.Helpers.*;
import static io.restassured.module.jsv.JsonSchemaValidator.matchesJsonSchemaInClasspath;

@Test(testName = "Проверка мока OTUS",
        description = "Проверка мока OTUS")
public class ResponseSchemaTest {

    public Response response;

    @Test (testName = "/users/get/all валидация схемы и статус кода 200",
            description = "/users/get/all валидация схемы и статус кода 200")

    public void GetAllUsersSchemaTest(){
        String url = "http://localhost:8080/users/get/all";
        RequestSpecification request = buildRequest() ;
        Response response =
                executeGetRequest(request, url);
                        response.then()
                        .log().all()
                        .statusCode(200)
                        .body(matchesJsonSchemaInClasspath("schema/usersAll.json"));
    }


    @Test (testName = "/users/get/1 валидация схемы и статус кода 200",
            description = "/users/get/1 валидация схемы и статус кода 200")
    public void GetUserSchemaTest(){
        String url = "http://localhost:8080/users/get/1";
        RequestSpecification request = buildRequest() ;
        Response response =
                executeGetRequest(request, url);
        response.then()
                .log().all()
                .statusCode(200)
                .body(matchesJsonSchemaInClasspath("schema/users.json"));
    }


    @Test (testName = "/users/1 валидация схемы и статус кода 200",
            description = "/users/1 валидация схемы и статус кода 200")
    public void GetUserMobileSchemaTest(){
        String url = "http://localhost:8080/users/1";
        RequestSpecification request = buildRequest() ;
        Response response =
                executeGetRequest(request, url);
        response.then()
                .log().all()
                .statusCode(200)
                .body(matchesJsonSchemaInClasspath("schema/users.json"));
    }
    @Step("Getting response")
    @Attachment
    public String getRecommendedName() {
        return response.toString();
    }

}
