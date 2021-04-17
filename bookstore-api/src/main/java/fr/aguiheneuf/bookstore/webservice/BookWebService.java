package fr.aguiheneuf.bookstore.webservice;

import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.core.Response;

/**
 * @author Alexandre Guiheneuf
 */
@Path("/book")
public interface BookWebService {

    @GET
    Response getBook();
}
