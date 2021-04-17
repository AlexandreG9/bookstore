package fr.aguiheneuf.bookstore.service;

import fr.aguiheneuf.bookstore.dto.BookDto;
import fr.aguiheneuf.bookstore.dto.SearchBookRequestDto;

import java.util.List;

/**
 * @author Alexandre Guiheneuf
 */
public interface BookService {

    List<BookDto> findBook(SearchBookRequestDto searchBookRequestDto);

}
