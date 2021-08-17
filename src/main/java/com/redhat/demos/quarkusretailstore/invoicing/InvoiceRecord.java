package com.redhat.demos.quarkusretailstore.invoicing;

import io.quarkus.hibernate.orm.panache.PanacheEntity;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import java.util.Collection;

/**
 * Entity storing Invoice data
 */
@Entity
class InvoiceRecord extends PanacheEntity {

    @Id
    String invoiceId;

    @OneToOne
    InvoiceHeader invoiceHeader;

    @OneToMany
    Collection<InvoiceLine> invoiceLines;

    String customerName;

    public InvoiceRecord() {

    }

    public InvoiceRecord(final String customerName) {
        this.customerName = customerName;
    }

    @Override
    public String toString() {
        final StringBuilder sb = new StringBuilder("InvoiceRecord{");
        sb.append("customerName='").append(customerName).append('\'');
        sb.append(", id=").append(id);
        sb.append('}');
        return sb.toString();
    }

    public InvoiceHeader getInvoiceHeader() {
        return invoiceHeader;
    }

    public void setInvoiceHeader(InvoiceHeader invoiceHeader) {
        this.invoiceHeader = invoiceHeader;
    }

    public Collection<InvoiceLine> getInvoiceLines() {
        return invoiceLines;
    }

    public void setInvoiceLines(Collection<InvoiceLine> invoiceLines) {
        this.invoiceLines = invoiceLines;
    }

    public String getCustomerName() {
        return customerName;
    }

    public void setCustomerName(String customerName) {
        this.customerName = customerName;
    }
}
