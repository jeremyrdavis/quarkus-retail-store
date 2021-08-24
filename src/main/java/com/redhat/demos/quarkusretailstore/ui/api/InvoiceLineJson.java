package com.redhat.demos.quarkusretailstore.ui.api;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.redhat.demos.quarkusretailstore.invoicing.UnitOfMeasure;
import com.redhat.demos.quarkusretailstore.invoicing.api.InvoiceLineDTO;
import com.redhat.demos.quarkusretailstore.invoicing.domain.InvoiceLine;

import java.math.BigDecimal;

public class InvoiceLineJson {

    final String skuId;

    final String productDescripiton;

    final BigDecimal billQuantity;

    final Double unitPrice;

    final BigDecimal extendedPrice;

    final UnitOfMeasure unitOfMeasure;

    @JsonCreator(mode = JsonCreator.Mode.PROPERTIES)
    public InvoiceLineJson(@JsonProperty("skuId") String skuId, @JsonProperty("productDescripiton") String productDescripiton, @JsonProperty("billQuantity") BigDecimal billQuantity, @JsonProperty("unitPrice") Double unitPrice, @JsonProperty("extendedPrice") BigDecimal extendedPrice, @JsonProperty("unitOfMeasure") UnitOfMeasure unitOfMeasure) {
        this.skuId = skuId;
        this.productDescripiton = productDescripiton;
        this.billQuantity = billQuantity;
        this.unitPrice = unitPrice;
        this.extendedPrice = extendedPrice;
        this.unitOfMeasure = unitOfMeasure;
    }

    public InvoiceLineJson(final InvoiceLineDTO invoiceLineDTO) {
        this.skuId = invoiceLineDTO.getSkuId();
        this.productDescripiton = invoiceLineDTO.getProductDescripiton();
        this.billQuantity = invoiceLineDTO.getBillQuantity();
        this.unitPrice = invoiceLineDTO.getUnitPrice();
        this.extendedPrice = invoiceLineDTO.getExtendedPrice();
        this.unitOfMeasure = invoiceLineDTO.getUnitOfMeasure();
    }

    @Override
    public String toString() {
        final StringBuilder sb = new StringBuilder("InvoiceLineJson{");
        sb.append("skuId='").append(skuId).append('\'');
        sb.append(", productDescripiton='").append(productDescripiton).append('\'');
        sb.append(", billQuantity=").append(billQuantity);
        sb.append(", unitPrice=").append(unitPrice);
        sb.append(", extendedPrice=").append(extendedPrice);
        sb.append(", unitOfMeasure=").append(unitOfMeasure);
        sb.append('}');
        return sb.toString();
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        InvoiceLineJson that = (InvoiceLineJson) o;

        if (skuId != null ? !skuId.equals(that.skuId) : that.skuId != null) return false;
        if (productDescripiton != null ? !productDescripiton.equals(that.productDescripiton) : that.productDescripiton != null)
            return false;
        if (billQuantity != null ? !billQuantity.equals(that.billQuantity) : that.billQuantity != null) return false;
        if (unitPrice != null ? !unitPrice.equals(that.unitPrice) : that.unitPrice != null) return false;
        if (extendedPrice != null ? !extendedPrice.equals(that.extendedPrice) : that.extendedPrice != null)
            return false;
        return unitOfMeasure == that.unitOfMeasure;
    }

    @Override
    public int hashCode() {
        int result = skuId != null ? skuId.hashCode() : 0;
        result = 31 * result + (productDescripiton != null ? productDescripiton.hashCode() : 0);
        result = 31 * result + (billQuantity != null ? billQuantity.hashCode() : 0);
        result = 31 * result + (unitPrice != null ? unitPrice.hashCode() : 0);
        result = 31 * result + (extendedPrice != null ? extendedPrice.hashCode() : 0);
        result = 31 * result + (unitOfMeasure != null ? unitOfMeasure.hashCode() : 0);
        return result;
    }

    public String getSkuId() {
        return skuId;
    }

    public String getProductDescripiton() {
        return productDescripiton;
    }

    public BigDecimal getBillQuantity() {
        return billQuantity;
    }

    public Double getUnitPrice() {
        return unitPrice;
    }

    public BigDecimal getExtendedPrice() {
        return extendedPrice;
    }

    public UnitOfMeasure getUnitOfMeasure() {
        return unitOfMeasure;
    }
}
