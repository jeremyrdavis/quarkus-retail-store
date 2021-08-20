package com.redhat.demos.quarkusretailstore.invoicing.infrastructure;

import com.redhat.demos.quarkusretailstore.invoicing.CreateInvoiceCommand;
import com.redhat.demos.quarkusretailstore.invoicing.Invoice;
import com.redhat.demos.quarkusretailstore.invoicing.InvoiceRepository;
import com.redhat.demos.quarkusretailstore.invoicing.NoSuchInvoiceException;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import javax.inject.Inject;
import javax.ws.rs.*;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

@Path("/invoicing")
@Produces(MediaType.APPLICATION_JSON)
public class InvoicingResource {

    private static final Logger LOGGER = LoggerFactory.getLogger(InvoicingResource.class);

    @Inject
    InvoiceRepository invoiceRepository;

//    @POST
//    public Response createInvoice(final CreateInvoiceCommand createInvoiceCommand) {
//
//    }

    @GET
    public Response getInvoiceById(@QueryParam("invoiceId") final String invoiceId){

        try {
            Invoice invoice = invoiceRepository.findById(invoiceId);
            return Response.status(Response.Status.FOUND).entity(invoice).build();
        } catch (NoSuchInvoiceException e) {
            LOGGER.error(e.getMessage());
            return Response.status(Response.Status.NOT_FOUND).build();
        }
    }
}
