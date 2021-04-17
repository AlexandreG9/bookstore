package fr.aguiheneuf.bookstore.webservice;

import fr.aguiheneuf.bookstore.dto.SearchBookRequestDto;

import javax.ws.rs.Consumes;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

/**
 * @author Alexandre Guiheneuf
 */
@Path("/book")
public interface BookWebService {

    @POST
    @Path("/find")
    @Produces(MediaType.APPLICATION_JSON)
    @Consumes(MediaType.APPLICATION_JSON)
    Response findBooks(final SearchBookRequestDto searchBookRequestDto);
}
