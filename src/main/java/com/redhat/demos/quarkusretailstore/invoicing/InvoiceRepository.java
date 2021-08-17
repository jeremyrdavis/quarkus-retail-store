package com.redhat.demos.quarkusretailstore.invoicing;

import io.quarkus.hibernate.orm.panache.PanacheRepository;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import javax.enterprise.context.ApplicationScoped;
import javax.transaction.Transactional;

@ApplicationScoped
public class InvoiceRepository implements PanacheRepository<InvoiceRecord> {

    private static final Logger LOGGER = LoggerFactory.getLogger(InvoiceRepository.class);

    @Transactional
    public Invoice persist(Invoice invoice) {

        LOGGER.debug("persisting {}", invoice);
        InvoiceRecord invoiceRecord = invoice.invoiceRecord;
        this.persist(invoiceRecord);
        LOGGER.debug("persisted {}", invoice);
        invoice.invoiceRecord = invoiceRecord;
        return invoice;
    }
}
