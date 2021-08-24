package com.redhat.demos.quarkusretailstore.invoicing.infrastructure;

import com.redhat.demos.quarkusretailstore.invoicing.NoSuchInvoiceException;
import com.redhat.demos.quarkusretailstore.invoicing.api.InvoiceDTO;
import com.redhat.demos.quarkusretailstore.invoicing.api.InvoiceService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import javax.inject.Inject;
import javax.ws.rs.*;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

@Path("/invoicing")
@Consumes(MediaType.APPLICATION_JSON)
@Produces(MediaType.APPLICATION_JSON)
public class InvoicingResource {

    private static final Logger LOGGER = LoggerFactory.getLogger(InvoicingResource.class);

    @Inject
    InvoiceService invoiceService;

//    @POST
//    public Response createInvoice(final CreateInvoiceCommand createInvoiceCommand) {
//
//    }

    @GET
    @Path("/{invoiceId}")
    public Response getInvoiceById(@PathParam("invoiceId") final String invoiceId){

        try {
            InvoiceDTO invoice = invoiceService.findById(invoiceId);
            return Response.status(Response.Status.FOUND).entity(invoice).build();
        } catch (NoSuchInvoiceException e) {
            LOGGER.error(e.getMessage());
            return Response.status(Response.Status.NOT_FOUND).build();
        }
    }
}
