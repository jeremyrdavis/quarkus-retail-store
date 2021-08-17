package com.redhat.demos.quarkusretailstore.invoicing;

import com.redhat.demos.quarkusretailstore.ui.LineItem;

import java.math.BigDecimal;
import java.util.Collection;

public class CreateInvoiceCommand {

    BigDecimal totalDollarAmout;

    Collection<LineItem> invoiceLines;

    String storeId;

    public BigDecimal getTotalDollarAmout() {
        return totalDollarAmout;
    }

    public void setTotalDollarAmout(BigDecimal totalDollarAmout) {
        this.totalDollarAmout = totalDollarAmout;
    }

    public Collection<LineItem> getInvoiceLines() {
        return invoiceLines;
    }

    public void setInvoiceLines(Collection<LineItem> invoiceLines) {
        this.invoiceLines = invoiceLines;
    }

    public String getStoreId() {
        return storeId;
    }

    public void setStoreId(String storeId) {
        this.storeId = storeId;
    }
}