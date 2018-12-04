package com.infoshare.bug_busters.apiTests;

import io.restassured.RestAssured;
import io.restassured.parsing.Parser;
import org.junit.Test;

import java.io.File;
import java.util.HashMap;
import java.util.Map;

import static io.restassured.RestAssured.given;
import static org.hamcrest.Matchers.notNullValue;

public class AddingCardAndAddress {
    @Test

    public void addingCard() {
        RestAssured.registerParser("text/plain", Parser.JSON);
        Map<String, Object> cart = new HashMap<>();
        cart.put("longNum", "523456789126");
        cart.put("expires", "12/20");
        cart.put("ccv", "553");
        cart.put("userID", "string");
        given().contentType("application/json")
                .body(cart).log().all().
                when()
                .post("http://localhost:4180/card").
                then()
                .log().all()
                .statusCode(200)
                .body("id", notNullValue());

    }
    @Test
    public void addingAddress() {
        RestAssured.registerParser("text/plain", Parser.JSON);
        Map<String, Object> address = new HashMap<>();
        address.put("number", "12/20");
        address.put("street", "Polna");
        address.put("city", "Opole");
        address.put("postcode", "78-254");
        address.put("country", "Poland");


        given().contentType("application/json")
                .body(address).log().all().
                when()
                .post("http://localhost:4180/addresses").
                then()
                .log().all().body("id", notNullValue())
                .statusCode(200);
    }

}

