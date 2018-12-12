package com.infoshare.bug_busters.api;

import org.junit.Test;

import static io.restassured.RestAssured.given;

public class Catalogue {
    @Test
    public void checkingCatalogue(){
        given()
            .contentType("application/json").
        when()
           .get("http://localhost:4180/cart").
        then()
           .log().all().statusCode(200);
    }
}
