package com.redhat.demos.quarkusretailstore.products.infrastructure;

import com.redhat.demos.quarkusretailstore.products.ProductMaster;
import io.quarkus.test.junit.QuarkusMock;
import io.quarkus.test.junit.QuarkusTest;
import io.quarkus.test.junit.TestProfile;
import io.quarkus.test.junit.mockito.InjectMock;
import io.restassured.RestAssured;
import io.restassured.parsing.Parser;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;

import javax.inject.Inject;
import javax.ws.rs.core.MediaType;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.UUID;

import static io.restassured.RestAssured.given;
import static org.hamcrest.Matchers.*;

@QuarkusTest
@TestProfile(ProductsResourceTestProfile.class)
public class ProductsResourceTest {

    @Inject
    private ProductsService productsService;

/*
    @BeforeAll
    public static void setup() {
        ProductsService mockProductsService = Mockito.mock(ProductsService.class);
        Mockito.when(mockProductsService.getAllProducts()).thenReturn(new ArrayList(
                Arrays.asList(new ProductMaster(UUID.randomUUID().toString(), "First product"),
                        new ProductMaster(UUID.randomUUID().toString(), "Second product"),
                        new ProductMaster(UUID.randomUUID().toString(), "Third product"))
        ));
        QuarkusMock.installMockForType(mockProductsService, ProductsService.class);
    }

*/
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
