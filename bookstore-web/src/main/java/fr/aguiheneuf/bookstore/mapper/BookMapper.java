package fr.aguiheneuf.bookstore.mapper;

import fr.aguiheneuf.bookstore.dto.BookDto;
import fr.aguiheneuf.bookstore.model.Book;
import org.mapstruct.Mapper;

/**
 * @author Alexandre Guiheneuf
 */
@Mapper
public interface BookMapper {

    /**
     * Convert a {@link Book} to a {@link BookDto}
     *
     * @param book the book entity
     * @return the bookDto equivalent
     */
    BookDto getDtoFromEntity(Book book);
}
