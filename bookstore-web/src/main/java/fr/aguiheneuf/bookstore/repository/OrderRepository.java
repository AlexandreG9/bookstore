package fr.aguiheneuf.bookstore.repository;

import fr.aguiheneuf.bookstore.model.Order;
import org.springframework.data.repository.CrudRepository;

/**
 * Generic repository for {@link Order}
 *
 * @author Alexandre Guiheneuf
 */
public interface OrderRepository extends CrudRepository<Order, Integer> {
}
