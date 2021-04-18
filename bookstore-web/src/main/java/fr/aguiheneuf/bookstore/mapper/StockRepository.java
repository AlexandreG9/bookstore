package fr.aguiheneuf.bookstore.mapper;

import fr.aguiheneuf.bookstore.model.Stock;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;

import java.util.List;
import java.util.Optional;

/**
 * @author Alexandre Guiheneuf
 */
public interface StockRepository extends CrudRepository<Stock, Integer> {

    @Query(value = "SELECT s FROM Stock s WHERE s.book.isbn in :isbnList")
    List<Stock> findStocksByBook_IsbnIn(@Param("isbnList") List<String> isbn);

    Optional<Stock> findByBook_Isbn(String isbn);
}
