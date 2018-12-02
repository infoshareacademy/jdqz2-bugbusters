package com.infoshare.bug_busters.apiTests;

import io.restassured.RestAssured;
import io.restassured.parsing.Parser;
import org.junit.Test;

import java.util.HashMap;
import java.util.Map;

import static io.restassured.RestAssured.given;

public class LoginTest {
    @Test
    public void checkingLogin() {
        RestAssured.registerParser("text/plain", Parser.JSON);
        Map<String, Object> login = new HashMap<>();
        login.put("username", "John3");
        login.put("password", "12345");

        given()
                .contentType("application/json")
                .body(login).log().all()
                .auth()
                .preemptive()
                .basic("John2", "12345").
                when().get("http://localhost:4180/login").
                then()
                .statusCode(200);

    }
}
