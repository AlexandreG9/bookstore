package fr.aguiheneuf.bookstore.service.impl;

import fr.aguiheneuf.bookstore.dto.BookRequestDto;
import fr.aguiheneuf.bookstore.dto.OrderBooksRequestDto;
import fr.aguiheneuf.bookstore.dto.OrderDto;
import fr.aguiheneuf.bookstore.mapper.OrderMapper;
import fr.aguiheneuf.bookstore.mapper.StockRepository;
import fr.aguiheneuf.bookstore.model.Book;
import fr.aguiheneuf.bookstore.model.Order;
import fr.aguiheneuf.bookstore.model.OrderDetail;
import fr.aguiheneuf.bookstore.model.Stock;
import fr.aguiheneuf.bookstore.repository.BookRepository;
import fr.aguiheneuf.bookstore.repository.OrderRepository;
import fr.aguiheneuf.bookstore.service.OrderService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Isolation;
import org.springframework.transaction.annotation.Transactional;

import java.math.BigDecimal;
import java.time.LocalDateTime;
import java.util.Map;
import java.util.Optional;
import java.util.Set;
import java.util.stream.Collectors;

/**
 * @author Alexandre Guiheneuf
 */
@Slf4j
@Service
public class OrderServiceImpl implements OrderService {

    private final OrderRepository orderRepository;
    private final StockRepository stockRepository;
    private final BookRepository bookRepository;
    private final OrderMapper orderMapper;

    /**
     * Constructor
     *
     * @param orderRepository instance of {@link OrderRepository}
     * @param stockRepository instance of {@link StockRepository}
     * @param bookRepository instance of {@link BookRepository}
     * @param orderMapper instance of {@link OrderMapper}
     */
    @Autowired
    public OrderServiceImpl(final OrderRepository orderRepository, final StockRepository stockRepository,
                            final BookRepository bookRepository, final OrderMapper orderMapper) {
        this.orderRepository = orderRepository;
        this.stockRepository = stockRepository;
        this.bookRepository = bookRepository;
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

    @Override
    @Transactional(isolation = Isolation.SERIALIZABLE)
    public OrderDto createOrder(final OrderBooksRequestDto orderBooksRequestDto) {
        final long availableBooks = countAvailableBooks(orderBooksRequestDto.getBookRequestDtos());

        if (availableBooks != orderBooksRequestDto.getBookRequestDtos().size()) {
            log.warn("{} / {} available book", availableBooks, orderBooksRequestDto.getBookRequestDtos().size());
            throw new IllegalStateException("At least one of these books are unavailable. Order is impossible.");
        }

        final Order order = new Order();
        order.setDateTime(LocalDateTime.now());

        order.setOrderDetails(orderBooksRequestDto.getBookRequestDtos().stream()
                .map(bookRequestDto -> orderBook(bookRequestDto, order))
                .collect(Collectors.toList()));

        // Compute the total price
        order.setPrice(
                order.getOrderDetails().stream()
                        .map(orderDetail -> orderDetail.getBook().getPrice().multiply(BigDecimal.valueOf(orderDetail.getQuantity())))
                        .reduce(BigDecimal.ZERO, BigDecimal::add));

        // Save order
        final Order savedOrder = orderRepository.save(order);

        return orderMapper.getOrderDtoFromEntity(savedOrder);
    }

    private long countAvailableBooks(final Set<BookRequestDto> bookRequestDtos) {
        final Map<String, Stock> stock = stockRepository.findStocksByBook_IsbnIn(bookRequestDtos.stream()
                .map(BookRequestDto::getIsbn).collect(Collectors.toList()))
                .stream().collect(Collectors.toMap(s1 -> s1.getBook().getIsbn(), s2 -> s2));

        return bookRequestDtos.stream()
                .filter(b -> stock.get(b.getIsbn()) != null && stock.get(b.getIsbn()).getQuantity() >= b.getQuantity())
                .count();
    }

    private OrderDetail orderBook(final BookRequestDto bookRequestDto, final Order order) {
        final Book book = bookRepository.findById(bookRequestDto.getIsbn())
                .orElseThrow(() -> new IllegalStateException("The book with isbn " + bookRequestDto.getIsbn() + " doesn't exists"));

        final Stock stock = stockRepository.findByBook_Isbn(bookRequestDto.getIsbn())
                .orElseThrow(() -> new IllegalStateException("The stock for the book with isbn " + bookRequestDto.getIsbn() + " doesn't exists"));

        // Remove quantity from stock
        stock.setQuantity(stock.getQuantity() - bookRequestDto.getQuantity());

        final OrderDetail orderDetail = new OrderDetail();
        orderDetail.setBook(book);
        orderDetail.setQuantity(bookRequestDto.getQuantity());
        orderDetail.setOrder(order);

        return orderDetail;
    }

}
