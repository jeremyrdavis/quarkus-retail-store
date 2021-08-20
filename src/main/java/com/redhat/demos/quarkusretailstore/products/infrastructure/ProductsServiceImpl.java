package com.redhat.demos.quarkusretailstore.products.infrastructure;

import com.redhat.demos.quarkusretailstore.products.ProductMaster;

import javax.enterprise.context.ApplicationScoped;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.UUID;

@ApplicationScoped
public class ProductsServiceImpl implements ProductsService {

    Collection<ProductMaster> productMasters = new ArrayList(
            Arrays.asList(new ProductMaster(UUID.randomUUID().toString(), "A product"),
                    new ProductMaster(UUID.randomUUID().toString(), "Another product"),
                    new ProductMaster(UUID.randomUUID().toString(), "Yet another product"),
                    new ProductMaster(UUID.randomUUID().toString(), "One more product"))
    );

    @Override
    public Collection<ProductMaster> getAllProducts() {
        return productMasters;
    }
}
