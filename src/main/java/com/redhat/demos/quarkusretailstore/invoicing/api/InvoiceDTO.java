package com.redhat.demos.quarkusretailstore.invoicing.api;

import com.redhat.demos.quarkusretailstore.invoicing.domain.InvoiceHeader;
import com.redhat.demos.quarkusretailstore.invoicing.domain.InvoiceLine;

import java.util.Collection;

/**
 * An immutable representation of the data making up an invoice
 */
public class InvoiceDTO {

    final String invoiceId;

    final InvoiceHeader invoiceHeader;

    final Collection<InvoiceLine> invoiceLines;

    final String customerName;

    public InvoiceDTO(String invoiceId, InvoiceHeader invoiceHeader, Collection<InvoiceLine> invoiceLines, String customerName) {
        this.invoiceId = invoiceId;
        this.invoiceHeader = invoiceHeader;
        this.invoiceLines = invoiceLines;
        this.customerName = customerName;
    }

    @Override
    public String toString() {
        final StringBuilder sb = new StringBuilder("InvoiceDTO{");
        sb.append("invoiceId='").append(invoiceId).append('\'');
        sb.append(", invoiceHeader=").append(invoiceHeader);
        sb.append(", invoiceLines=").append(invoiceLines);
        sb.append(", customerName='").append(customerName).append('\'');
        sb.append('}');
        return sb.toString();
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        InvoiceDTO that = (InvoiceDTO) o;

        if (invoiceId != null ? !invoiceId.equals(that.invoiceId) : that.invoiceId != null) return false;
        if (invoiceHeader != null ? !invoiceHeader.equals(that.invoiceHeader) : that.invoiceHeader != null)
            return false;
        if (invoiceLines != null ? !invoiceLines.equals(that.invoiceLines) : that.invoiceLines != null) return false;
        return customerName != null ? customerName.equals(that.customerName) : that.customerName == null;
    }

    @Override
    public int hashCode() {
        int result = invoiceId != null ? invoiceId.hashCode() : 0;
        result = 31 * result + (invoiceHeader != null ? invoiceHeader.hashCode() : 0);
        result = 31 * result + (invoiceLines != null ? invoiceLines.hashCode() : 0);
        result = 31 * result + (customerName != null ? customerName.hashCode() : 0);
        return result;
    }

    public String getInvoiceId() {
        return invoiceId;
    }

    public InvoiceHeader getInvoiceHeader() {
        return invoiceHeader;
    }

    public Collection<InvoiceLine> getInvoiceLines() {
        return invoiceLines;
    }

    public String getCustomerName() {
        return customerName;
    }
}

