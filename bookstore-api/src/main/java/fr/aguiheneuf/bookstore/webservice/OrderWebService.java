package fr.aguiheneuf.bookstore.webservice;

import javax.ws.rs.*;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

/**
 * @author Alexandre Guiheneuf
 */
@Path("/order")
public interface OrderWebService {

    @GET
    @Path("{idOrder: [0-9]{1,10}}")
    @Produces(MediaType.APPLICATION_JSON)
    Response findOrder(@PathParam("idOrder") Integer idOrder);
}
