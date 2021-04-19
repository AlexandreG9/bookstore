package fr.aguiheneuf.bookstore.service;

import fr.aguiheneuf.bookstore.dto.BookDto;
import fr.aguiheneuf.bookstore.dto.SearchBookRequestDto;

import java.util.List;

/**
 * Service dedicated to Book process
 *
 * @author Alexandre Guiheneuf
 */
public interface BookService {

    /**
     * Get a list of book from a {@link SearchBookRequestDto}
     *
     * @param searchBookRequestDto the search request
     * @return List of {@link BookDto}
     */
    List<BookDto> findBook(SearchBookRequestDto searchBookRequestDto);

}
