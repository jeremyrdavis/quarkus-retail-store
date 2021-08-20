package com.redhat.demos.quarkusretailstore.inventory.infrastrcuture;

import io.quarkus.test.junit.QuarkusTest;
import io.quarkus.test.junit.TestProfile;
import io.restassured.RestAssured;
import io.restassured.parsing.Parser;
import org.junit.jupiter.api.Test;

import javax.ws.rs.core.MediaType;

import static io.restassured.RestAssured.given;
import static org.hamcrest.Matchers.greaterThan;
import static org.hamcrest.Matchers.hasSize;

@QuarkusTest @TestProfile(InventoryResourceTestProfile.class)
public class InventoryResourceTest {

    @Test
    public void testCompleteInventory() {

        RestAssured.registerParser(MediaType.APPLICATION_JSON, Parser.JSON);

        given()
                .when().get("/inventory")
                .then()
                .statusCode(200)
                .body("$", hasSize(greaterThan(3)));
    }
}
