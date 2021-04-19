package fr.aguiheneuf.bookstore.repository;

import fr.aguiheneuf.bookstore.model.Stock;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;

import java.util.List;
import java.util.Optional;

/**
 * Repository for entity {@link Stock}
 *
 * @author Alexandre Guiheneuf
 */
public interface StockRepository extends CrudRepository<Stock, Integer> {

    /**
     * Find list of {@link Stock} with a list of {@link fr.aguiheneuf.bookstore.model.Book} ids (isbn)
     *
     * @param isbn list of isbn
     * @return The list of {@link Stock}
     */
    @Query(value = "SELECT s FROM Stock s WHERE s.book.isbn in :isbnList")
    List<Stock> findStocksByBook_IsbnIn(@Param("isbnList") List<String> isbn);

    /**
     * Find a stock from a {@link fr.aguiheneuf.bookstore.model.Book} id (isbn)
     *
     * @param isbn the book id
     * @return An Optional {@link Stock}
     */
    Optional<Stock> findByBook_Isbn(String isbn);
}
