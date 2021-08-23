package com.redhat.demos.quarkusretailstore.inventory;

import com.redhat.demos.quarkusretailstore.products.ProductMaster;
import io.quarkus.hibernate.orm.panache.PanacheEntity;

import javax.persistence.Entity;
import javax.persistence.OneToOne;
import java.math.BigDecimal;
import java.time.LocalDateTime;
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

    public Inventory() {
    }

    public Inventory(ProductMaster productMaster, BigDecimal unitCost, BigDecimal maxRetailPrice, int orderQuantity, int inStockQuantity, int backOrderQuantity, Date lastStockDate, Date lastSaleDate, int minimumQuantity, int maximumQuantity) {
        this.productMaster = productMaster;
        this.unitCost = unitCost;
        this.maxRetailPrice = maxRetailPrice;
        this.orderQuantity = orderQuantity;
        this.inStockQuantity = inStockQuantity;
        this.backOrderQuantity = backOrderQuantity;
        this.lastStockDate = lastStockDate;
        this.lastSaleDate = lastSaleDate;
        this.minimumQuantity = minimumQuantity;
        this.maximumQuantity = maximumQuantity;
    }

    public static Inventory from(final InventoryJson inventoryJson) {

        return new Inventory(
                inventoryJson.productMaster,
                inventoryJson.unitCost,
                inventoryJson.maxRetailPrice,
                inventoryJson.orderQuantity,
                inventoryJson.inStockQuantity,
                inventoryJson.backOrderQuantity,
                Date.from(inventoryJson.lastStockDate.toInstant()),
                Date.from(inventoryJson.lastSaleDate.toInstant()),
                inventoryJson.minimumQuantity,
                inventoryJson.maximumQuantity
        );
    }

    public InventoryJson toInventoryJson() {

        return new InventoryJson(this.productMaster,
                this.unitCost,
                this.maxRetailPrice,
                this.orderQuantity,
                this.inStockQuantity,
                this.backOrderQuantity,
                this.lastStockDate,
                this.lastSaleDate,
                this.minimumQuantity,
                this.maximumQuantity);
    }

    @Override
    public String toString() {
        final StringBuilder sb = new StringBuilder("Inventory{");
        sb.append("productMaster=").append(productMaster);
        sb.append(", unitCost=").append(unitCost);
        sb.append(", maxRetailPrice=").append(maxRetailPrice);
        sb.append(", orderQuantity=").append(orderQuantity);
        sb.append(", inStockQuantity=").append(inStockQuantity);
        sb.append(", backOrderQuantity=").append(backOrderQuantity);
        sb.append(", lastStockDate=").append(lastStockDate);
        sb.append(", lastSaleDate=").append(lastSaleDate);
        sb.append(", minimumQuantity=").append(minimumQuantity);
        sb.append(", maximumQuantity=").append(maximumQuantity);
        sb.append('}');
        return sb.toString();
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Inventory inventory = (Inventory) o;

        if (orderQuantity != inventory.orderQuantity) return false;
        if (inStockQuantity != inventory.inStockQuantity) return false;
        if (backOrderQuantity != inventory.backOrderQuantity) return false;
        if (minimumQuantity != inventory.minimumQuantity) return false;
        if (maximumQuantity != inventory.maximumQuantity) return false;
        if (productMaster != null ? !productMaster.equals(inventory.productMaster) : inventory.productMaster != null)
            return false;
        if (unitCost != null ? !unitCost.equals(inventory.unitCost) : inventory.unitCost != null) return false;
        if (maxRetailPrice != null ? !maxRetailPrice.equals(inventory.maxRetailPrice) : inventory.maxRetailPrice != null)
            return false;
        if (lastStockDate != null ? !lastStockDate.equals(inventory.lastStockDate) : inventory.lastStockDate != null)
            return false;
        return lastSaleDate != null ? lastSaleDate.equals(inventory.lastSaleDate) : inventory.lastSaleDate == null;
    }

    @Override
    public int hashCode() {
        int result = productMaster != null ? productMaster.hashCode() : 0;
        result = 31 * result + (unitCost != null ? unitCost.hashCode() : 0);
        result = 31 * result + (maxRetailPrice != null ? maxRetailPrice.hashCode() : 0);
        result = 31 * result + orderQuantity;
        result = 31 * result + inStockQuantity;
        result = 31 * result + backOrderQuantity;
        result = 31 * result + (lastStockDate != null ? lastStockDate.hashCode() : 0);
        result = 31 * result + (lastSaleDate != null ? lastSaleDate.hashCode() : 0);
        result = 31 * result + minimumQuantity;
        result = 31 * result + maximumQuantity;
        return result;
    }

    public ProductMaster getProductMaster() {
        return productMaster;
    }

    public void setProductMaster(ProductMaster productMaster) {
        this.productMaster = productMaster;
    }

    public BigDecimal getUnitCost() {
        return unitCost;
    }

    public void setUnitCost(BigDecimal unitCost) {
        this.unitCost = unitCost;
    }

    public BigDecimal getMaxRetailPrice() {
        return maxRetailPrice;
    }

    public void setMaxRetailPrice(BigDecimal maxRetailPrice) {
        this.maxRetailPrice = maxRetailPrice;
    }

    public int getOrderQuantity() {
        return orderQuantity;
    }

    public void setOrderQuantity(int orderQuantity) {
        this.orderQuantity = orderQuantity;
    }

    public int getInStockQuantity() {
        return inStockQuantity;
    }

    public void setInStockQuantity(int inStockQuantity) {
        this.inStockQuantity = inStockQuantity;
    }

    public int getBackOrderQuantity() {
        return backOrderQuantity;
    }

    public void setBackOrderQuantity(int backOrderQuantity) {
        this.backOrderQuantity = backOrderQuantity;
    }

    public Date getLastStockDate() {
        return lastStockDate;
    }

    public void setLastStockDate(Date lastStockDate) {
        this.lastStockDate = lastStockDate;
    }

    public Date getLastSaleDate() {
        return lastSaleDate;
    }

    public void setLastSaleDate(Date lastSaleDate) {
        this.lastSaleDate = lastSaleDate;
    }

    public int getMinimumQuantity() {
        return minimumQuantity;
    }

    public void setMinimumQuantity(int minimumQuantity) {
        this.minimumQuantity = minimumQuantity;
    }

    public int getMaximumQuantity() {
        return maximumQuantity;
    }

    public void setMaximumQuantity(int maximumQuantity) {
        this.maximumQuantity = maximumQuantity;
    }
}
