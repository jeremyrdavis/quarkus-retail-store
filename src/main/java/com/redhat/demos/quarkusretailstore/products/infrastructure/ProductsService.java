package com.redhat.demos.quarkusretailstore.products.infrastructure;

import com.redhat.demos.quarkusretailstore.products.ProductMaster;

import java.util.Collection;

public interface ProductsService {

    public Collection<ProductMaster> getAllProducts();
}
