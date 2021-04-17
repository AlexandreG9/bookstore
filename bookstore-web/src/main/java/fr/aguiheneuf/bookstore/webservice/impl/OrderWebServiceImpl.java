package fr.aguiheneuf.bookstore.webservice.impl;

import fr.aguiheneuf.bookstore.service.OrderService;
import fr.aguiheneuf.bookstore.webservice.OrderWebService;
import lombok.extern.slf4j.Slf4j;
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
            return orderService.findOrderById(idOrder)
                    .map(Response::ok)
                    .orElseGet(() -> Response.status(Response.Status.NOT_FOUND))
                    .build();
        } catch (final Exception e) {
            log.error("Cannot find order by id {}", idOrder, e);
            return Response.serverError().entity("Cannot find order").build();
        }
    }
}
