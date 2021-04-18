package fr.aguiheneuf.bookstore.dto;

import lombok.Builder;
import lombok.Value;

import java.io.Serializable;
import java.math.BigDecimal;
import java.time.LocalDateTime;
import java.util.List;

/**
 * @author Alexandre Guiheneuf
 */
@Value
@Builder(toBuilder = true)
public class OrderDto implements Serializable {

    private Integer orderNumber;

    private LocalDateTime dateTime;

    private List<OrderDetailDto> orderDetails;

    private BigDecimal price;
}
