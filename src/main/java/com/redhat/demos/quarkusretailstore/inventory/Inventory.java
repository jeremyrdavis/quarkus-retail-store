package com.redhat.demos.quarkusretailstore.inventory;

import com.redhat.demos.quarkusretailstore.products.ProductMaster;
import io.quarkus.hibernate.orm.panache.PanacheEntity;

import javax.persistence.Entity;
import javax.persistence.OneToOne;
import java.math.BigDecimal;
import java.util.Date;

@Entity
public class Inventory extends PanacheEntity {

    @OneToOne
    ProductMaster productMaster;

    BigDecimal unitCost;

    BigDecimal maxRetailPrice;

    int orderQuantity;

    int inStockQuantity;

    int backOrderQuantity;

    Date lastStockDate;

    Date lastSaleDate;

    int minimumQuantity;

    int maximumQuantity;




}
