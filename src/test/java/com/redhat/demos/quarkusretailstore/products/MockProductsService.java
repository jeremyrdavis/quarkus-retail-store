package com.redhat.demos.quarkusretailstore.products;

import io.quarkus.test.Mock;

import javax.enterprise.context.ApplicationScoped;
import javax.enterprise.inject.Alternative;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.UUID;

@Alternative
@ApplicationScoped
public class MockProductsService {

    public Collection<ProductMaster> getAllProducts() {
        return new ArrayList(
            Arrays.asList(new ProductMaster(UUID.randomUUID().toString(), "A product"),
            new ProductMaster(UUID.randomUUID().toString(), "Another product"),
            new ProductMaster(UUID.randomUUID().toString(), "Yet another product"))
        );
    }
}
