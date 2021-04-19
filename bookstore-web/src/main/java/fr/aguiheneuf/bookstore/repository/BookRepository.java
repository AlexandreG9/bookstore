package fr.aguiheneuf.bookstore.repository;

import fr.aguiheneuf.bookstore.model.Book;
import org.springframework.data.repository.CrudRepository;

/**
 * Generic repository for entity {@link Book}
 *
 * @author Alexandre Guiheneuf
 */
public interface BookRepository extends CrudRepository<Book, String> {

}
