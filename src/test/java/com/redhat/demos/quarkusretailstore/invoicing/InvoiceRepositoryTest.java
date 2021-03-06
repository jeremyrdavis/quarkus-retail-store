package com.redhat.demos.quarkusretailstore.invoicing;

import com.redhat.demos.quarkusretailstore.invoicing.api.InvoiceDTO;
import com.redhat.demos.quarkusretailstore.invoicing.domain.InvoiceRepository;
import io.quarkus.test.junit.QuarkusTest;
import org.junit.jupiter.api.Test;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import javax.inject.Inject;
import javax.transaction.Transactional;

import static org.junit.jupiter.api.Assertions.assertNotNull;

@QuarkusTest
public class InvoiceRepositoryTest {

    private static final Logger LOGGER = LoggerFactory.getLogger(InvoiceRepositoryTest.class);

    @Inject
    InvoiceRepository invoiceRepository;

    @Test @Transactional
    public void testPersisting() {

/*
        InvoiceDTO invoiceData = new InvoiceDTO(null, "Elmo");
        Invoice invoice = Invoice.createFrom(invoiceData);
        LOGGER.debug("Invoice after creation: {}", invoice);
        assertNotNull(invoice);
        invoiceRepository.persist(invoice);
        assertNotNull(invoice.getId());
        LOGGER.debug("Invoice after creation: {}", invoice);
*/
    }
}
