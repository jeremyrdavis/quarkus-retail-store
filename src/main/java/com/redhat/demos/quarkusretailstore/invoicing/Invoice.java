package com.redhat.demos.quarkusretailstore.invoicing;

import javax.enterprise.context.ApplicationScoped;

/**
 * Domain object representing Invoices
 */
public class Invoice {

    InvoiceRecord invoiceRecord;

    public static Invoice createFrom(final InvoiceData invoiceData) {

        InvoiceRecord invoiceRecord = new InvoiceRecord(invoiceData.getCustomer());
        return new Invoice(invoiceRecord);
    }

    private Invoice(final InvoiceRecord record) {
        invoiceRecord = record;
    }

    public void update(final InvoiceData invoiceData) {

        invoiceRecord.customerName = invoiceData.customer;
    }

    public Long getId() {
        return invoiceRecord.id;
    }

    public String getCustomer(){
        return invoiceRecord.customerName;
    }

    @Override
    public String toString() {
        final StringBuilder sb = new StringBuilder("Invoice{");
        sb.append("invoiceRecord=").append(invoiceRecord);
        sb.append('}');
        return sb.toString();
    }
}
