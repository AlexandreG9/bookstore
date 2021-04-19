package fr.aguiheneuf.bookstore.webservice.impl;

import fr.aguiheneuf.bookstore.dto.OrderBooksRequestDto;
import fr.aguiheneuf.bookstore.service.OrderService;
import fr.aguiheneuf.bookstore.webservice.OrderWebService;
import lombok.extern.slf4j.Slf4j;
import org.glassfish.jersey.internal.guava.Preconditions;
import org.springframework.stereotype.Component;

import javax.ws.rs.core.Response;

/**
 * @author Alexandre Guiheneuf
 */
@Slf4j
@Component
public class OrderWebServiceImpl implements OrderWebService {

    private final OrderService orderService;

    public OrderWebServiceImpl(final OrderService orderService) {
        this.orderService = orderService;
    }
    
    @Override
    public Response findOrder(final Integer idOrder) {
        try {
            Preconditions.checkNotNull(idOrder);
            return orderService.findOrderById(idOrder)
                    .map(Response::ok)
                    .orElseGet(() -> Response.status(Response.Status.NOT_FOUND))
                    .build();
        } catch (final Exception e) {
            log.error("Cannot find order by id {}", idOrder, e);
            return Response.serverError().entity("Cannot find order").build();
        }
    }

    @Override
    public Response createOrder(final OrderBooksRequestDto orderBooksRequestDto) {
        try {
            Preconditions.checkNotNull(orderBooksRequestDto);
            Preconditions.checkNotNull(orderBooksRequestDto.getBookRequestDtos(), "No book to order");
            return Response.ok(orderService.createOrder(orderBooksRequestDto)).build();
        } catch (final IllegalStateException stateException) {
            log.warn("Books are not available", stateException);
            return Response.ok(stateException.getMessage()).build();
        } catch (final Exception e) {
            log.error("Cannot order books", e);
            return Response.serverError().entity("Technical error, cannot order books").build();
        }
    }
}
