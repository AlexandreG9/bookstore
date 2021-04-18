package fr.aguiheneuf.bookstore.service;

import fr.aguiheneuf.bookstore.dto.OrderBooksRequestDto;
import fr.aguiheneuf.bookstore.dto.OrderDto;

import java.util.Optional;

/**
 * @author Alexandre Guiheneuf
 */
public interface OrderService {

    /**
     * Find order by id.
     * If no order found, return an empty Optional
     *
     * @param id the id of the order
     * @return The order if present, Optional.empty else
     */
    Optional<OrderDto> findOrderById(Integer id);

    OrderDto createOrder(OrderBooksRequestDto orderBooksRequestDto);

}
