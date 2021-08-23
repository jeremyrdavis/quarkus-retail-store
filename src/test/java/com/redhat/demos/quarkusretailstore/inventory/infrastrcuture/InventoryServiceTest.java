package com.redhat.demos.quarkusretailstore.inventory.infrastrcuture;

import com.redhat.demos.quarkusretailstore.inventory.Inventory;
import com.redhat.demos.quarkusretailstore.inventory.InventoryJson;
import com.redhat.demos.quarkusretailstore.products.ProductMaster;
import io.quarkus.test.junit.QuarkusTest;
import org.junit.jupiter.api.Test;

import javax.inject.Inject;
import java.math.BigDecimal;
import java.time.LocalDateTime;
import java.util.Collection;
import java.util.UUID;

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

    @Test
    public void testCreatingInventoryFromJson() {

        InventoryJson inventoryJson = new InventoryJson(
                new ProductMaster(UUID.randomUUID().toString(), "A product description"),
                BigDecimal.valueOf(19.99),
                BigDecimal.valueOf(24.99),
                1,
                9,
                0,
                LocalDateTime.of(2021, 8, 15, 4, 30),
                LocalDateTime.now().minusMinutes(3),
                10,
                15
        );

        Inventory inventory = Inventory.from(inventoryJson);
        assertNotNull(inventory);
        assertEquals(BigDecimal.valueOf(19.99), inventory.getUnitCost());
        assertEquals(BigDecimal.valueOf(24.99), inventory.getMaxRetailPrice());
        assertEquals(1, inventory.getOrderQuantity());
        assertEquals(9, inventory.getInStockQuantity());
        assertEquals(0, inventory.getBackOrderQuantity());
        assertEquals(10, inventory.getMinimumQuantity());
        assertEquals(15, inventory.getMaximumQuantity());
    }

}
