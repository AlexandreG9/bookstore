package fr.aguiheneuf.bookstore.dto;

import lombok.*;

import java.io.Serializable;
import java.math.BigDecimal;
import java.time.LocalDateTime;
import java.util.List;

/**
 * Describe an order
 *
 * @author Alexandre Guiheneuf
 */
@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder(toBuilder = true)
public class OrderDto implements Serializable {

    /**
     * The order number
     */
    private Integer orderNumber;

    /**
     * The creation date of the order
     */
    private LocalDateTime dateTime;

    /**
     * Contains list of books and quantity ordered
     */
    private List<OrderDetailDto> orderDetails;

    /**
     * Total price of the order
     */
    private BigDecimal price;
}
