package com.redhat.demos.quarkusretailstore.inventory.infrastrcuture;

import com.redhat.demos.quarkusretailstore.inventory.Inventory;
import com.redhat.demos.quarkusretailstore.inventory.InventoryJson;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import javax.inject.Inject;
import javax.ws.rs.*;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import java.util.Collection;

@Path("/inventory")
@Consumes(MediaType.APPLICATION_JSON)
@Produces(MediaType.APPLICATION_JSON)
public class InventoryResource {

    private static final Logger LOGGER = LoggerFactory.getLogger(InventoryResource.class);

    @Inject
    InventoryService inventoryService;

    @GET
    public Response getCompleteInventory() {

        Collection<Inventory> completeInventory = inventoryService.getCompeleteInventory();
        LOGGER.debug("Returning {} items", completeInventory.size());
        return Response.status(Response.Status.OK).entity(inventoryService.getCompeleteInventory()).build();
    }

    @POST
    public Response createInventory(final InventoryJson inventoryJson) {

        LOGGER.debug("received {}", inventoryJson);
        InventoryJson result = inventoryService.addInventory(inventoryJson);
        return Response.status(Response.Status.CREATED).entity(result).build();
    }
}
