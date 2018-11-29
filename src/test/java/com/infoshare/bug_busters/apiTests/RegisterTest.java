package com.infoshare.bug_busters.apiTests;
import io.restassured.RestAssured;
import io.restassured.parsing.Parser;
import org.junit.Test;

import java.util.HashMap;
import java.util.Map;

import static io.restassured.RestAssured.given;
import static io.restassured.RestAssured.when;
import static org.hamcrest.Matchers.equalTo;


public class RegisterTest {


    @Test
    public void checkingWeb(){
        when()
                .get("http://localhost:4180/").
        then()
                .statusCode(200);
    }
    @Test
    public void checkingRegistration() {
        RestAssured.registerParser("text/plain", Parser.JSON);
        Map<String, Object> project = new HashMap<>();
        project.put("username", "John");
        project.put("password", "12345");
        project.put("email", "john2@gmail.com");
        given()
                .body(project).when()
                .post("http://localhost:4180/register").
                then()
                .log().all().contentType("text/plain").body("username", equalTo("John"));

             //.statusCode(200)
    }
    @Test
            public void checkingLogin() {
        given()
                .param("username", "John")
                .param("password","12345");
                when().get("http://localhost:4180/login").then().statusCode(200);

    }

}
