package com.redhat.demos.quarkusretailstore.invoicing.domain;

import com.redhat.demos.quarkusretailstore.invoicing.CreateInvoiceCommand;
import com.redhat.demos.quarkusretailstore.invoicing.api.InvoiceDTO;

import java.math.BigDecimal;
import java.util.Calendar;

/**
 * Domain object representing Invoices
 */
public class Invoice {

    InvoiceRecord invoiceRecord;

    public static Invoice from(InvoiceRecord invoiceRecord) {
        return new Invoice(invoiceRecord);
    }

    public static Invoice from(InvoiceDTO invoiceDTO) {
        InvoiceRecord invoiceRecord = new InvoiceRecord(
                invoiceDTO.getInvoiceId(),
                invoiceDTO.getInvoiceHeader(),
                invoiceDTO.getInvoiceLines(),
                invoiceDTO.getCustomerName()
        );
        return new Invoice(invoiceRecord);
    }

    public static Invoice createFrom(final CreateInvoiceCommand createInvoiceCommand) {

        InvoiceRecord invoiceRecord = new InvoiceRecord();
        BigDecimal totalDollarAmount = new BigDecimal(0.0);
        createInvoiceCommand.getInvoiceLines().forEach(lineItem -> {
            InvoiceLine invoiceLine = new InvoiceLine();
            invoiceLine.setSkuId(lineItem.getSkuId());
            invoiceLine.setUnitOfMeasure(lineItem.getUnitOfMeasure());
            invoiceLine.setExtendedPrice(lineItem.getBillQuantity().multiply(lineItem.getPrice()));
            invoiceLine.setBillQuantity(lineItem.getBillQuantity());
            invoiceLine.setProductDescripiton(lineItem.getProductDescripiton());
            invoiceRecord.invoiceLines.add(invoiceLine);
            totalDollarAmount.add(invoiceLine.getExtendedPrice());
        });
        InvoiceHeader invoiceHeader = new InvoiceHeader();
        invoiceHeader.setStoreId(createInvoiceCommand.getStoreId());
        invoiceHeader.setDate(Calendar.getInstance().getTime());
        invoiceHeader.setNumberOfLines(createInvoiceCommand.getInvoiceLines().size());
        //TODO fix this
        invoiceHeader.setTotalDollarAmount(totalDollarAmount.doubleValue());
        return new Invoice(invoiceRecord);
    }

    private Invoice(final InvoiceRecord record) {
        invoiceRecord = record;
    }

    public void update(final InvoiceDTO invoiceData) {

        invoiceRecord.customerName = invoiceData.getCustomerName();
    }

    public String getId() {
        return invoiceRecord.invoiceId;
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
