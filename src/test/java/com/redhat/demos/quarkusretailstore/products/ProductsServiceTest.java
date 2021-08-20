package com.redhat.demos.quarkusretailstore.products;

import io.quarkus.test.junit.QuarkusTest;
import org.junit.jupiter.api.Test;

import javax.inject.Inject;

@QuarkusTest
public class ProductsServiceTest {

    @Inject
    ProductsService productsService;

    @Test
    public void testAllProducts() {


    }
}
