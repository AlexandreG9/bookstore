package fr.aguiheneuf.bookstore.dto;

import lombok.Builder;
import lombok.Value;

import java.io.Serializable;
import java.math.BigDecimal;
import java.time.LocalDateTime;
import java.util.Set;

/**
 * @author Alexandre Guiheneuf
 */
@Value
@Builder(toBuilder = true)
public class OrderDto implements Serializable {

    private Integer orderNumber;

    private LocalDateTime dateTime;

    private Set<OrderDetailDto> orderDetails;

    private BigDecimal price;
}
