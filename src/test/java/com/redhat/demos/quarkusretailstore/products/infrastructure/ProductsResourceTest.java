package com.redhat.demos.quarkusretailstore.products.infrastructure;

import io.quarkus.test.junit.QuarkusTest;
import io.quarkus.test.junit.TestProfile;
import io.restassured.RestAssured;
import io.restassured.parsing.Parser;
import org.hamcrest.Matchers;
import org.junit.jupiter.api.Test;

import javax.inject.Inject;
import javax.ws.rs.core.MediaType;
import java.util.UUID;

import static io.restassured.RestAssured.given;
import static org.hamcrest.Matchers.*;

@QuarkusTest
@TestProfile(ProductsResourceTestProfile.class)
public class ProductsResourceTest {

    @Inject
    private ProductsService productsService;

    @Test
    public void testProductsEndpoint() {

        RestAssured.registerParser(MediaType.APPLICATION_JSON, Parser.JSON);

        given()
                .when().get("/products")
                .then()
                .statusCode(200)
                .body("$", hasSize(greaterThan(2)));
    }

    @Test
    public void testSingleProduct() {

        String skuId = UUID.randomUUID().toString();

        given()
                .when().get("/products/" + skuId)
                .then()
                .statusCode(200)
                .body("description", equalTo("A mocked product"));
    }

}
