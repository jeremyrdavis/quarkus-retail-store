package com.redhat.demos.quarkusretailstore.invoicing.domain;

import com.redhat.demos.quarkusretailstore.invoicing.NoSuchInvoiceException;
import io.quarkus.hibernate.orm.panache.PanacheRepository;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import javax.enterprise.context.ApplicationScoped;
import javax.transaction.Transactional;

@ApplicationScoped
public class InvoiceRepository implements PanacheRepository<InvoiceRecord> {

    private static final Logger LOGGER = LoggerFactory.getLogger(InvoiceRepository.class);

    public Invoice findById(final String invoiceId) throws NoSuchInvoiceException {
        InvoiceRecord invoiceRecord = InvoiceRecord.findById(invoiceId);
        if (invoiceRecord == null) {
            throw new NoSuchInvoiceException(invoiceId);
        }
        return Invoice.from(invoiceRecord);
    }

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
