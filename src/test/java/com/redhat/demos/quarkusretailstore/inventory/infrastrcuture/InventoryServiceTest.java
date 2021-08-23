package com.redhat.demos.quarkusretailstore.inventory.infrastrcuture;

import com.redhat.demos.quarkusretailstore.inventory.Inventory;
import com.redhat.demos.quarkusretailstore.inventory.InventoryJson;
import com.redhat.demos.quarkusretailstore.inventory.NoSuchInventoryRecordException;
import com.redhat.demos.quarkusretailstore.products.ProductMaster;
import io.quarkus.test.junit.QuarkusTest;
import org.junit.jupiter.api.MethodOrderer;
import org.junit.jupiter.api.Order;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestMethodOrder;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import javax.inject.Inject;
import java.math.BigDecimal;
import java.time.LocalDateTime;
import java.util.Collection;
import java.util.UUID;

import static org.junit.jupiter.api.Assertions.*;

@QuarkusTest @TestMethodOrder(MethodOrderer.OrderAnnotation.class)
public class InventoryServiceTest {

    private static final Logger LOGGER = LoggerFactory.getLogger(InventoryServiceTest.class);

    static final String skuId = UUID.randomUUID().toString();

    @Inject
    InventoryService inventoryService;

    @Inject
    InventoryRepository inventoryRepository;

    @Test @Order(4)
    public void testInventory() {

        Collection<Inventory> completeInventory = inventoryService.getCompeleteInventory();
        assertNotNull(completeInventory);
        assertEquals(1, completeInventory.size());
    }

    @Test @Order(3)
    public void testUpdatingInventory(){

        InventoryJson inventoryJson = new InventoryJson(
                new ProductMaster(skuId, "A product description"),
                BigDecimal.valueOf(19.99),
                BigDecimal.valueOf(24.99),
                1,
                8,
                0,
                LocalDateTime.of(2021, 8, 15, 4, 30),
                LocalDateTime.now().minusMinutes(3),
                10,
                15
        );

        try {
            InventoryJson result = inventoryService.updateInventory(inventoryJson);
            assertNotNull(result);
            assertEquals(8, result.getInStockQuantity() );
        } catch (NoSuchInventoryRecordException e) {
            assertNull(e, "There should not be an exception");
        }
    }

    @Test
    @Order(2)
    public void testAddingInventory() {

        InventoryJson inventoryJson = new InventoryJson(
                new ProductMaster(skuId, "A product description"),
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

        inventoryService.addInventory(inventoryJson);

        Inventory inventory = inventoryRepository.findById(skuId);
        assertNotNull(inventory);
        assertEquals(skuId, inventory.getProductMaster().getSkuId());

    }

    @Test @Order(1)
    public void testMarshallingInventoryFromJson() {

        InventoryJson inventoryJson = new InventoryJson(
                new ProductMaster(skuId, "A product description"),
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
        assertEquals(skuId, inventoryJson.getProductMaster().getSkuId());
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
