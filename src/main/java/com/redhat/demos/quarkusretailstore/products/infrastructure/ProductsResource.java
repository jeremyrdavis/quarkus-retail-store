package com.redhat.demos.quarkusretailstore.products.infrastructure;

import com.redhat.demos.quarkusretailstore.products.NoSuchProductException;
import com.redhat.demos.quarkusretailstore.products.ProductMaster;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import javax.inject.Inject;
import javax.ws.rs.*;
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

    @GET
    @Path("/{id}")
    public Response getProduct(@PathParam("id") String skuId) {

        ProductMaster productMaster = null;
        try {
            productMaster = productsService.getProductById(skuId);
            LOGGER.debug("Returning {}", productMaster);
            return Response.status(200).entity(productMaster).build();
        } catch (NoSuchProductException e) {
            LOGGER.error(e.getMessage());
            return Response.status(Response.Status.NO_CONTENT).build();
        }

    }
}
