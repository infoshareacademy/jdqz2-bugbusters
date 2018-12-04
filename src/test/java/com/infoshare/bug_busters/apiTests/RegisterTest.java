package com.infoshare.bug_busters.apiTests;
import io.restassured.RestAssured;
import io.restassured.parsing.Parser;
import org.junit.Test;
import java.util.HashMap;
import java.util.Map;
import static io.restassured.RestAssured.given;
import static io.restassured.RestAssured.when;
import static org.hamcrest.Matchers.notNullValue;

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
        project.put("username", "John10");
        project.put("firstName", "John3");
        project.put("lastName", "Doe");
        project.put("password", "12345");
        project.put("email", "john10@gmail.com");
        given().contentType("application/json")
            .body(project).log().all().
        when()
            .post("http://localhost:4180/register").
        then()
            .log().all()
            .statusCode(200)
            .body("id", notNullValue());
    }

}
