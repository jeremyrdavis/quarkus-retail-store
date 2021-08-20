package com.redhat.demos.quarkusretailstore.inventory.infrastrcuture;

import com.redhat.demos.quarkusretailstore.inventory.Inventory;

import javax.enterprise.context.ApplicationScoped;
import java.util.ArrayList;
import java.util.Collection;

@ApplicationScoped
public class InventoryServiceImpl implements InventoryService{

    @Override
    public Collection<Inventory> getCompeleteInventory() {
        return new ArrayList<>();
    }
}
