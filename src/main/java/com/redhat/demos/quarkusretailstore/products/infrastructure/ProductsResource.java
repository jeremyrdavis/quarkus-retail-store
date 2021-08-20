package com.redhat.demos.quarkusretailstore.products.infrastructure;

import com.redhat.demos.quarkusretailstore.products.ProductMaster;
import com.redhat.demos.quarkusretailstore.products.ProductsService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import javax.inject.Inject;
import javax.ws.rs.Consumes;
import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import java.util.*;

@Path("/products")
@Consumes(MediaType.APPLICATION_JSON)
@Produces(MediaType.APPLICATION_JSON)
public class ProductsResource {

    private static final Logger LOGGER = LoggerFactory.getLogger(ProductsResource.class);

    @Inject
    ProductsService productsService;

    @GET
    public Response getProducts() {

        Collection<ProductMaster> allProducts = productsService.getAllProducts();
        LOGGER.debug("Returning {} products", allProducts.size());
        return Response.status(200).entity(allProducts).build();
    }
}
