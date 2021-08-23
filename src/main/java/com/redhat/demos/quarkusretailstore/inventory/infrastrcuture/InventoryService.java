package com.redhat.demos.quarkusretailstore.inventory.infrastrcuture;

import com.redhat.demos.quarkusretailstore.inventory.Inventory;
import com.redhat.demos.quarkusretailstore.inventory.InventoryJson;

import java.util.Collection;

public interface InventoryService {

    Collection<Inventory> getCompeleteInventory();

    InventoryJson addInventory(final InventoryJson inventoryJson);
}
