package be.helb.controller;

import io.restassured.RestAssured;
import org.junit.jupiter.api.Test;

public class HomeControllerIntegrationTest {

    //Permet de verifier l'existence ou non d'un URL
    @Test
    public void whenRequestGet_ThenOk(){
        RestAssured.with().when().request("GET", "/api/Exercise/All/").then().statusCode(200);
    }

    @Test
    public void whenRequestPost_ThenOk(){
        RestAssured.with().param("name", "Push up")
                .param("description", "Chest exercise").when().request("POST", "/api/Exercise/New").then().statusCode(200);
    }

    @Test
    public void whenRequestDelete_ThenOk(){
        int id = 1;
        RestAssured.with().param("id", id).when().request("DELETE", "/api/Exercise/Delete/" + id ).then().statusCode(200);
    }

    @Test
    public void whenRequestPut_ThenOk(){
        int id = 4;
        String desc = "How do you describe your bench press?\n" +
                "Résultat de recherche d'images pour \"bench press description\"\n" +
                "The bench press is a compound exercise that targets the muscles of the upper body. It involves lying on a bench and pressing weight upward using either a barbell or a pair of dumbbells. During a bench press, you lower the weight down to chest level and then press upwards while extending your arms.";
        RestAssured.with().param("id", id)
                .param("name", "Bench Press")
                .param("description", desc)
                .when().request("PUT", "/api/Exercise/Update/" + id ).then().statusCode(200);
    }
}
