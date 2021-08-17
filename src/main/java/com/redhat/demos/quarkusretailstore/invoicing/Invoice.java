package com.redhat.demos.quarkusretailstore.invoicing;

import java.math.BigDecimal;
import java.util.Calendar;

/**
 * Domain object representing Invoices
 */
public class Invoice {

    InvoiceRecord invoiceRecord;

    public static Invoice createFrom(final CreateInvoiceCommand createInvoiceCommand) {

        InvoiceRecord invoiceRecord = new InvoiceRecord();
        BigDecimal totalDollarAmount = new BigDecimal(0.0);
        createInvoiceCommand.invoiceLines.forEach(lineItem -> {
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
        invoiceHeader.setNumberOfLines(createInvoiceCommand.invoiceLines.size());
        //TODO fix this
        invoiceHeader.setTotalDollarAmount(totalDollarAmount.doubleValue());
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
