package com.redhat.demos.quarkusretailstore.invoicing;

import io.quarkus.hibernate.orm.panache.PanacheEntity;

import javax.persistence.Entity;

/**
 * Entity storing Invoice data
 */
@Entity
class InvoiceRecord extends PanacheEntity {

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
}
