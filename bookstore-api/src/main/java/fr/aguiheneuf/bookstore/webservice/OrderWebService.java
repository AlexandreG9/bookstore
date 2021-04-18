package fr.aguiheneuf.bookstore.webservice;

import fr.aguiheneuf.bookstore.dto.OrderBooksRequestDto;

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

    @POST
    @Path("/create")
    @Consumes(MediaType.APPLICATION_JSON)
    @Produces(MediaType.APPLICATION_JSON)
    Response createOrder(OrderBooksRequestDto orderBooksRequestDto);
}
