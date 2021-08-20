package com.redhat.demos.quarkusretailstore.inventory.infrastrcuture;

import com.redhat.demos.quarkusretailstore.inventory.Inventory;

import java.util.Collection;

public interface InventoryService {

    Collection<Inventory> getCompeleteInventory();
}
