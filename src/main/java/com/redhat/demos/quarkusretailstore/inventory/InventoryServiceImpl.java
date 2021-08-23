package com.redhat.demos.quarkusretailstore.inventory;

import com.redhat.demos.quarkusretailstore.inventory.api.InventoryDTO;
import com.redhat.demos.quarkusretailstore.inventory.api.NoSuchInventoryRecordException;
import com.redhat.demos.quarkusretailstore.inventory.api.InventoryService;

import javax.enterprise.context.ApplicationScoped;
import javax.inject.Inject;
import javax.transaction.Transactional;
import java.util.*;
import java.util.stream.Collectors;

@ApplicationScoped
public class InventoryServiceImpl implements InventoryService {

    @Inject
    InventoryRepository inventoryRepository;

    @Override
    public Collection<InventoryDTO> getCompeleteInventory() {

        return inventoryRepository.streamAll().map(inventory -> {
            return inventory.toInventoryDTO();
        }).collect(Collectors.toList());
    }

    @Override @Transactional
    public InventoryDTO addInventory(final InventoryDTO inventoryJson) {

        Inventory inventory = Inventory.from(inventoryJson);
        inventoryRepository.persist(inventory);
        return inventory.toInventoryDTO();
    }

    @Override @Transactional
    public InventoryDTO updateInventory(final InventoryDTO inventoryDTO) throws NoSuchInventoryRecordException {
        Inventory inventory = inventoryRepository.findById(inventoryDTO.getProductMaster().getSkuId());
        if (inventory == null) {
            throw new NoSuchInventoryRecordException(inventoryDTO.getProductMaster().getSkuId());
        }
        inventory.setBackOrderQuantity(inventoryDTO.getBackOrderQuantity());
        inventory.setInStockQuantity(inventoryDTO.getInStockQuantity());
        inventory.setLastSaleDate(inventoryDTO.getLastSaleDate());
        inventory.setLastStockDate(inventoryDTO.getLastStockDate());
        inventory.setMaximumQuantity(inventoryDTO.getMaximumQuantity());
        inventory.setMinimumQuantity(inventoryDTO.getMinimumQuantity());
        inventory.setOrderQuantity(inventoryDTO.getOrderQuantity());
        inventory.setMaxRetailPrice(inventoryDTO.getMaxRetailPrice());
        inventory.setUnitCost(inventoryDTO.getUnitCost());
        inventoryRepository.persist(inventory);
        return inventory.toInventoryDTO();
    }
}
