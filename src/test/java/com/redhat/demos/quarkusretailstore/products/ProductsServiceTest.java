package com.redhat.demos.quarkusretailstore.products;

import com.redhat.demos.quarkusretailstore.products.infrastructure.ProductsService;
import io.quarkus.test.junit.QuarkusTest;
import org.junit.jupiter.api.Test;

import javax.inject.Inject;
import java.util.Collection;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;

@QuarkusTest
public class ProductsServiceTest {

    @Inject
    ProductsService productsService;

    @Test
    public void testAllProducts() {

        Collection<ProductMaster> results = productsService.getAllProducts();
        assertNotNull(results);
        assertEquals(4, results.size());

    }
}
