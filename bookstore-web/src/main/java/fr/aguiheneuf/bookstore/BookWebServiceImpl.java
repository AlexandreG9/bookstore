package fr.aguiheneuf.bookstore;

import fr.aguiheneuf.bookstore.webservice.BookWebService;
import org.springframework.stereotype.Component;

import javax.ws.rs.core.Response;

/**
 * @author Alexandre Guiheneuf
 */
@Component
public class BookWebServiceImpl implements BookWebService {
    @Override
    public Response getBook() {
        return Response.ok().build();
    }
}
