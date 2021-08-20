package com.redhat.demos.quarkusretailstore.products.infrastructure;

import io.quarkus.test.junit.QuarkusTest;
import io.restassured.RestAssured;
import io.restassured.parsing.Parser;
import org.hamcrest.Matchers;
import org.junit.jupiter.api.Test;

import javax.ws.rs.core.MediaType;

import static io.restassured.RestAssured.given;
import static org.hamcrest.Matchers.*;

@QuarkusTest
public class ProductsResourceTest {

    @Test
    public void testProductsEndpoint() {

        RestAssured.registerParser(MediaType.APPLICATION_JSON, Parser.JSON);

        given()
                .when().get("/products")
                .then()
                .statusCode(200)
                .body("$", hasSize(greaterThan(2)));
    }

}
