package com.redhat.demos.quarkusretailstore.products;

import java.util.Collection;

public interface ProductsService {

    public Collection<ProductMaster> getAllProducts();
}
