package com.redhat.demos.quarkusretailstore.invoicing;

/**
 * An immutable representation of the data making up an invoice
 */
public class InvoiceData {

    final Long id;

    final String customer;

    public InvoiceData(Long id, String customer) {
        this.id = id;
        this.customer = customer;
    }

    public Long getId() {
        return id;
    }

    public String getCustomer() {
        return customer;
    }
}
