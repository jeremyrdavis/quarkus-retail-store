package com.redhat.demos.quarkusretailstore.inventory.infrastrcuture;

import com.redhat.demos.quarkusretailstore.inventory.Inventory;
import com.redhat.demos.quarkusretailstore.inventory.InventoryJson;
import com.redhat.demos.quarkusretailstore.inventory.NoSuchInventoryRecordException;
import com.redhat.demos.quarkusretailstore.products.ProductMaster;

import javax.enterprise.context.ApplicationScoped;
import javax.inject.Inject;
import javax.transaction.Transactional;
import java.math.BigDecimal;
import java.util.*;

@ApplicationScoped
public class InventoryServiceImpl implements InventoryService{

    @Inject
    InventoryRepository inventoryRepository;

    Collection<Inventory> completeInventory = new ArrayList<>(
            Arrays.asList(
                    new Inventory( new ProductMaster(UUID.randomUUID().toString(), "A product"),
                            BigDecimal.valueOf(18.99),
                            BigDecimal.valueOf(37.99),
                            1,
                            10,
                            0,
                            Calendar.getInstance().getTime(),
                            Calendar.getInstance().getTime(),
                            5,
                            10),
                    new Inventory( new ProductMaster(UUID.randomUUID().toString(), "Another product"),
                            BigDecimal.valueOf(19.99),
                            BigDecimal.valueOf(39.99),
                            1,
                            11,
                            0,
                            Calendar.getInstance().getTime(),
                            Calendar.getInstance().getTime(),
                            6,
                            11),
                    new Inventory( new ProductMaster(UUID.randomUUID().toString(), "And another product"),
                            BigDecimal.valueOf(20.99),
                            BigDecimal.valueOf(39.99),
                            3,
                            12,
                            0,
                            Calendar.getInstance().getTime(),
                            Calendar.getInstance().getTime(),
                            7,
                            12),
                    new Inventory( new ProductMaster(UUID.randomUUID().toString(), "A third product"),
                            BigDecimal.valueOf(21.99),
                            BigDecimal.valueOf(40.99),
                            4,
                            13,
                            0,
                            Calendar.getInstance().getTime(),
                            Calendar.getInstance().getTime(),
                            8,
                            13)
            )
    );

    @Override
    public Collection<Inventory> getCompeleteInventory() {

        return inventoryRepository.listAll();
    }

    @Override @Transactional
    public InventoryJson addInventory(final InventoryJson inventoryJson) {

        Inventory inventory = Inventory.from(inventoryJson);
        inventoryRepository.persist(inventory);
        return inventory.toInventoryJson();
    }

    @Override @Transactional
    public InventoryJson updateInventory(final InventoryJson inventoryJson) throws NoSuchInventoryRecordException {
        Inventory inventory = inventoryRepository.findById(inventoryJson.getProductMaster().getSkuId());
        if (inventory == null) {
            throw new NoSuchInventoryRecordException(inventoryJson.getProductMaster().getSkuId());
        }
        inventory.setBackOrderQuantity(inventoryJson.getBackOrderQuantity());
        inventory.setInStockQuantity(inventoryJson.getInStockQuantity());
        inventory.setLastSaleDate(inventoryJson.getLastSaleDate());
        inventory.setLastStockDate(inventoryJson.getLastStockDate());
        inventory.setMaximumQuantity(inventoryJson.getMaximumQuantity());
        inventory.setMinimumQuantity(inventoryJson.getMinimumQuantity());
        inventory.setOrderQuantity(inventoryJson.getOrderQuantity());
        inventory.setMaxRetailPrice(inventoryJson.getMaxRetailPrice());
        inventory.setUnitCost(inventoryJson.getUnitCost());
        inventoryRepository.persist(inventory);
        return inventory.toInventoryJson();
    }
}
