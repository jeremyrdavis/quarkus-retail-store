package com.redhat.demos.quarkusretailstore.invoicing.api;

import com.redhat.demos.quarkusretailstore.invoicing.NoSuchInvoiceException;

public interface InvoiceService {

    public void createInvoice(final InvoiceDTO invoiceData);

    public InvoiceDTO findById(final String id) throws NoSuchInvoiceException;
}
