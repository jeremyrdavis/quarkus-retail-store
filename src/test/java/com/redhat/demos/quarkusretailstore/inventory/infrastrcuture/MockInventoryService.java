package com.redhat.demos.quarkusretailstore.inventory.infrastrcuture;

import com.redhat.demos.quarkusretailstore.inventory.Inventory;
import com.redhat.demos.quarkusretailstore.products.ProductMaster;

import javax.enterprise.context.ApplicationScoped;
import javax.enterprise.inject.Alternative;
import java.math.BigDecimal;
import java.util.*;

@Alternative
@ApplicationScoped
public class MockInventoryService implements InventoryService {

    Collection<Inventory> completeInventory = new ArrayList<>(
            Arrays.asList(
                    new Inventory(new ProductMaster(UUID.randomUUID().toString(), "A mocked product"),
                            BigDecimal.valueOf(18.99),
                            BigDecimal.valueOf(37.99),
                            1,
                            10,
                            0,
                            Calendar.getInstance().getTime(),
                            Calendar.getInstance().getTime(),
                            5,
                            10),
                    new Inventory(new ProductMaster(UUID.randomUUID().toString(), "Another mocked product"),
                            BigDecimal.valueOf(19.99),
                            BigDecimal.valueOf(39.99),
                            1,
                            11,
                            0,
                            Calendar.getInstance().getTime(),
                            Calendar.getInstance().getTime(),
                            6,
                            11),
                    new Inventory(new ProductMaster(UUID.randomUUID().toString(), "And another mocked product"),
                            BigDecimal.valueOf(20.99),
                            BigDecimal.valueOf(39.99),
                            3,
                            12,
                            0,
                            Calendar.getInstance().getTime(),
                            Calendar.getInstance().getTime(),
                            7,
                            12),
                    new Inventory(new ProductMaster(UUID.randomUUID().toString(), "A third mocked product"),
                            BigDecimal.valueOf(21.99),
                            BigDecimal.valueOf(40.99),
                            4,
                            13,
                            0,
                            Calendar.getInstance().getTime(),
                            Calendar.getInstance().getTime(),
                            8,
                            13),
                    new Inventory(new ProductMaster(UUID.randomUUID().toString(), "A fourth mocked product"),
                            BigDecimal.valueOf(22.99),
                            BigDecimal.valueOf(41.99),
                            5,
                            14,
                            0,
                            Calendar.getInstance().getTime(),
                            Calendar.getInstance().getTime(),
                            9,
                            14)
            )
    );

    @Override
    public Collection<Inventory> getCompeleteInventory() {
        return completeInventory;
    }
}
