package com.redhat.demos.quarkusretailstore.invoicing.api;

import com.redhat.demos.quarkusretailstore.invoicing.NoSuchInvoiceException;

public interface InvoiceService {

    public InvoiceDTO createInvoice(final InvoiceDTO invoiceDTO);

    public InvoiceDTO findById(final String id) throws NoSuchInvoiceException;
}
