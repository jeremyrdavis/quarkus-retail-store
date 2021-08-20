package com.redhat.demos.quarkusretailstore.inventory.infrastrcuture;

import com.redhat.demos.quarkusretailstore.inventory.Inventory;
import io.quarkus.test.junit.QuarkusTest;
import org.junit.jupiter.api.Test;

import javax.inject.Inject;
import java.util.Collection;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;

@QuarkusTest
public class InventoryServiceTest {

    @Inject
    InventoryService inventoryService;

    @Test
    public void testInventory() {

        Collection<Inventory> completeInventory = inventoryService.getCompeleteInventory();
        assertNotNull(completeInventory);
        assertEquals(4, completeInventory.size());
    }

}
