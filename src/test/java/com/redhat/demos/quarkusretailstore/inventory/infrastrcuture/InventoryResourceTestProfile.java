package com.redhat.demos.quarkusretailstore.inventory.infrastrcuture;

import com.redhat.demos.quarkusretailstore.products.MockProductsService;
import io.quarkus.test.junit.QuarkusTestProfile;

import java.util.Collections;
import java.util.Set;

public class InventoryResourceTestProfile implements QuarkusTestProfile {

    @Override
    public Set<Class<?>> getEnabledAlternatives() {
        return Collections.singleton(MockInventoryService.class);
    }
}
