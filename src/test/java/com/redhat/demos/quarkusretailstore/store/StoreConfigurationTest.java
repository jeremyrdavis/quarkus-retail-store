package com.redhat.demos.quarkusretailstore.store;

import io.quarkus.test.junit.QuarkusTest;
import org.junit.jupiter.api.Test;

import javax.inject.Inject;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;

@QuarkusTest
public class StoreConfigurationTest {

    @Inject
    Store store;

    @Test
    public void testStoreConfiguration() {

        assertNotNull(store);
        assertEquals("ATLANTA-01", store.storeId);
        assertEquals("DECATUR", store.storeName);
    }
}
