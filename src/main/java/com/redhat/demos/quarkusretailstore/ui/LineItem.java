package com.redhat.demos.quarkusretailstore.ui;

import com.redhat.demos.quarkusretailstore.invoicing.UnitOfMeasure;

import java.math.BigDecimal;

public class LineItem {

    String skuId;

    String productDescripiton;

    BigDecimal price;

    int inStockQuantity;

    BigDecimal billQuantity;

    UnitOfMeasure unitOfMeasure;

    public String getSkuId() {
        return skuId;
    }

    public void setSkuId(String skuId) {
        this.skuId = skuId;
    }

    public String getProductDescripiton() {
        return productDescripiton;
    }

    public void setProductDescripiton(String productDescripiton) {
        this.productDescripiton = productDescripiton;
    }

    public BigDecimal getPrice() {
        return price;
    }

    public void setPrice(BigDecimal price) {
        this.price = price;
    }

    public int getInStockQuantity() {
        return inStockQuantity;
    }

    public void setInStockQuantity(int inStockQuantity) {
        this.inStockQuantity = inStockQuantity;
    }

    public BigDecimal getBillQuantity() {
        return billQuantity;
    }

    public void setBillQuantity(BigDecimal billQuantity) {
        this.billQuantity = billQuantity;
    }

    public UnitOfMeasure getUnitOfMeasure() {
        return unitOfMeasure;
    }

    public void setUnitOfMeasure(UnitOfMeasure unitOfMeasure) {
        this.unitOfMeasure = unitOfMeasure;
    }
}