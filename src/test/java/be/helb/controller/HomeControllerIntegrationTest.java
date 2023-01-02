package be.helb.controller;

import io.restassured.RestAssured;
import org.junit.jupiter.api.Test;

public class HomeControllerIntegrationTest {

    //Permet de verifier l'existence ou non d'un URL
   // @Test
    public void whenRequestGet_ThenOk(){
        RestAssured.with().when().request("GET", "/HelloWorld").then().statusCode(200);
    }
}
