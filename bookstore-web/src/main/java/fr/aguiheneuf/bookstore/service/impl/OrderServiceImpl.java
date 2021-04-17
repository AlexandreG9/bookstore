package fr.aguiheneuf.bookstore.service.impl;

import fr.aguiheneuf.bookstore.dto.OrderDto;
import fr.aguiheneuf.bookstore.mapper.OrderMapper;
import fr.aguiheneuf.bookstore.repository.OrderRepository;
import fr.aguiheneuf.bookstore.service.OrderService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.Optional;

/**
 * @author Alexandre Guiheneuf
 */
@Service
public class OrderServiceImpl implements OrderService {

    private final OrderRepository orderRepository;

    private final OrderMapper orderMapper;

    /**
     * Constructor
     * @param orderRepository
     */
    @Autowired
    public OrderServiceImpl(final OrderRepository orderRepository, final OrderMapper orderMapper) {
        this.orderRepository = orderRepository;
        this.orderMapper = orderMapper;
    }

    @Transactional
    @Override
    public Optional<OrderDto> findOrderById(final Integer id) {
        if (id != null) {
            return orderRepository.findById(id).map(orderMapper::getOrderDtoFromEntity);
        }

        return Optional.empty();
    }
}
