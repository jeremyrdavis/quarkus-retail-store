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

        assertEquals("ATLANTA-01", store.storeId());
        assertEquals("DECATUR", store.storeName());
        assertNotNull(store.storeAddress());
        assertEquals("426 W Ponce de Leon Ave", store.storeAddress().street());
        assertEquals("3340 Peachtree Rd NE", store.mailingAddress().street());
    }
}
