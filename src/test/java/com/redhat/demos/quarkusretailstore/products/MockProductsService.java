package com.redhat.demos.quarkusretailstore.products;

import javax.enterprise.context.ApplicationScoped;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.UUID;

@ApplicationScoped
public class MockProductsService implements ProductsService{

    @Override
    public Collection<ProductMaster> getAllProducts() {
        return new ArrayList(
            Arrays.asList(new ProductMaster(UUID.randomUUID().toString(), "A product"),
            new ProductMaster(UUID.randomUUID().toString(), "Another product"),
            new ProductMaster(UUID.randomUUID().toString(), "Yet another product"))
        );
    }
}
