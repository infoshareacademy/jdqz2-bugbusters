package com.infoshare.bug_busters.apiTests;

import org.junit.Test;

import static io.restassured.RestAssured.given;
import static io.restassured.RestAssured.when;
import static org.hamcrest.Matchers.containsString;
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
    public void checkingRegistration(){
        given()
             .param("username", "John2")
             .param("firstName", "John2")
             .param("lastName","Doe")
             .param("email", "john2@gmail.com")
             .param("password","12345")
             .auth()
             .preemptive();
        when()
                .post("http://localhost:4180/register").
        then()
             .log().all()
             .statusCode(200)
             .contentType("application/json")
             .body("username",containsString("John2"))
             .contentType("application/json");

    }

}
