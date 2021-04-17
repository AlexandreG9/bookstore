package fr.aguiheneuf.bookstore.repository;

import fr.aguiheneuf.bookstore.model.Order;
import org.springframework.data.repository.CrudRepository;

/**
 * @author Alexandre Guiheneuf
 */
public interface OrderRepository extends CrudRepository<Order, Integer> {
}
