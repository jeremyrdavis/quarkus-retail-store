package com.redhat.demos.quarkusretailstore.invoicing;

public class NoSuchInvoiceException extends Throwable {

    String invoiceId;

    public NoSuchInvoiceException(final String invoiceId) {
        this.invoiceId = invoiceId;
    }

    @Override
    public String getMessage() {
        return new StringBuilder("No invoice with the id ").append(invoiceId).append(" found.").toString();
    }

}
