package com.redhat.demos.quarkusretailstore.invoicing;

import com.redhat.demos.quarkusretailstore.invoicing.api.InvoiceDTO;
import com.redhat.demos.quarkusretailstore.invoicing.api.InvoiceService;
import com.redhat.demos.quarkusretailstore.invoicing.domain.Invoice;

import javax.enterprise.context.ApplicationScoped;

@ApplicationScoped
public class InvoiceServiceImpl implements InvoiceService {


    @Override
    public void createInvoice(InvoiceDTO invoiceDTO) {

        Invoice invoice = Invoice.from(invoiceDTO);
    }

    @Override
    public InvoiceDTO findById(String id) throws NoSuchInvoiceException {
        return null;
    }
}
