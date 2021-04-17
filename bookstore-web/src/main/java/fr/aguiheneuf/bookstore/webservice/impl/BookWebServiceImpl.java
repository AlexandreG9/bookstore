package fr.aguiheneuf.bookstore.webservice.impl;

import fr.aguiheneuf.bookstore.dto.SearchBookRequestDto;
import fr.aguiheneuf.bookstore.service.BookService;
import fr.aguiheneuf.bookstore.webservice.BookWebService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.util.CollectionUtils;

import javax.ws.rs.core.Response;

/**
 * @author Alexandre Guiheneuf
 */
@Slf4j
@Component
public class BookWebServiceImpl implements BookWebService {

    private final BookService bookService;

    @Autowired
    public BookWebServiceImpl(final BookService bookService) {
        this.bookService = bookService;
    }

    @Override
    public Response findBooks(final SearchBookRequestDto searchBookRequestDto) {
        try {
            if (searchBookRequestDto != null && !CollectionUtils.isEmpty(searchBookRequestDto.getIsbnList())) {
                return Response.ok(bookService.findBook(searchBookRequestDto)).build();
            }
            return Response.noContent().build();
        } catch (Exception e) {
            log.error("Impossible to find book", e);
            return Response.serverError().entity("Error while searching books").build();
        }
    }
}
