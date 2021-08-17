package com.redhat.demos.quarkusretailstore.invoicing.api;

import com.redhat.demos.quarkusretailstore.invoicing.InvoiceData;

public interface InvoiceService {

    public void createInvoice(final InvoiceData invoiceData);
}
