package com.redhat.demos.quarkusretailstore.inventory.api;

import java.util.Collection;

public interface InventoryService {

    Collection<InventoryDTO> getCompeleteInventory();

    InventoryDTO addInventory(final InventoryDTO inventoryJson);

    InventoryDTO updateInventory(final InventoryDTO inventoryJson) throws NoSuchInventoryRecordException;
}
