package fr.aguiheneuf.bookstore.webservice;

import fr.aguiheneuf.bookstore.dto.OrderBooksRequestDto;

import javax.ws.rs.*;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

/**
 * Webservice dedicated to Order books
 *
 * @author Alexandre Guiheneuf
 */
@Path("/order")
public interface OrderWebService {

    /**
     * Find an order from id
     *
     * @param idOrder the id's order
     * @return 200 : the order
     *          404 : if the order was not found
     *          500 : if an error occurred during the process
     */
    @GET
    @Path("{idOrder: [0-9]{1,10}}")
    @Produces(MediaType.APPLICATION_JSON)
    Response findOrder(@PathParam("idOrder") Integer idOrder);

    /**
     * Create an order
     *
     * @param orderBooksRequestDto contains the books and quantity to order
     * @return 200 : if body contains {@link fr.aguiheneuf.bookstore.dto.OrderDto}, the order was created. Or else
     *              a book is not available
     *          500 : an error occurred during the process
     */
    @POST
    @Path("/create")
    @Consumes(MediaType.APPLICATION_JSON)
    @Produces(MediaType.APPLICATION_JSON)
    Response createOrder(OrderBooksRequestDto orderBooksRequestDto);
}
