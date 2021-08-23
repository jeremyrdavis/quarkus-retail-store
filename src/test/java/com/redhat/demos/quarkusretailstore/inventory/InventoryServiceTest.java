package com.redhat.demos.quarkusretailstore.inventory;

import com.redhat.demos.quarkusretailstore.inventory.api.InventoryDTO;
import com.redhat.demos.quarkusretailstore.inventory.api.NoSuchInventoryRecordException;
import com.redhat.demos.quarkusretailstore.inventory.api.InventoryService;
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

        Collection<InventoryDTO> completeInventory = inventoryService.getCompeleteInventory();
        assertNotNull(completeInventory);
        assertEquals(1, completeInventory.size());
    }

    @Test @Order(3)
    public void testUpdatingInventory(){

        InventoryDTO inventoryDTO = mockInventoryDTO();

        try {
            InventoryDTO result = inventoryService.updateInventory(inventoryDTO);
            assertNotNull(result);
            assertEquals(8, result.getInStockQuantity() );
        } catch (NoSuchInventoryRecordException e) {
            assertNull(e, "There should not be an exception");
        }
    }

    @Test
    @Order(2)
    public void testAddingInventory() {

        InventoryDTO inventoryDTO = mockInventoryDTO();

        inventoryService.addInventory(inventoryDTO);

        Inventory inventory = inventoryRepository.findById(skuId);
        assertNotNull(inventory);
        assertEquals(skuId, inventory.getProductMaster().getSkuId());

    }

    @Test @Order(1)
    public void testMarshallingInventoryFromJson() {

        InventoryDTO inventoryDTO = mockInventoryDTO();

        Inventory inventory = Inventory.from(inventoryDTO);
        assertEquals(skuId, inventoryDTO.getProductMaster().getSkuId());
        assertNotNull(inventory);
        assertEquals(BigDecimal.valueOf(19.99), inventory.getUnitCost());
        assertEquals(BigDecimal.valueOf(24.99), inventory.getMaxRetailPrice());
        assertEquals(1, inventory.getOrderQuantity());
        assertEquals(8, inventory.getInStockQuantity());
        assertEquals(0, inventory.getBackOrderQuantity());
        assertEquals(10, inventory.getMinimumQuantity());
        assertEquals(15, inventory.getMaximumQuantity());
    }

    private InventoryDTO mockInventoryDTO() {

        return new InventoryDTO(
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
    }

}
