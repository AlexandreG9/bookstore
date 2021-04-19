package fr.aguiheneuf.bookstore.webservice;

import fr.aguiheneuf.bookstore.dto.SearchBookRequestDto;

import javax.ws.rs.Consumes;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

/**
 * Webservice dedicated to Book
 *
 * @author Alexandre Guiheneuf
 */
@Path("/book")
public interface BookWebService {

    /**
     * Get a list of book from a list of ids in {@link SearchBookRequestDto}
     * If a book id is unknown, it will be ignored
     *
     * @param searchBookRequestDto Contains the list of books id
     * @return 200 : return the list of books
     *          500 : a technical error during the research of books
     */
    @POST
    @Path("/find")
    @Produces(MediaType.APPLICATION_JSON)
    @Consumes(MediaType.APPLICATION_JSON)
    Response findBooks(final SearchBookRequestDto searchBookRequestDto);
}
