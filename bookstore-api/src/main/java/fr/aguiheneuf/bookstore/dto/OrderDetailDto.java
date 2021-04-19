package fr.aguiheneuf.bookstore.dto;

import lombok.*;

import java.io.Serializable;

/**
 * Contains book and its quantity from an order
 *
 * @see OrderDto
 * @author Alexandre Guiheneuf
 */

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder(toBuilder = true)
public class OrderDetailDto implements Serializable {

    /**
     * The book
     */
    private BookDto book;

    /**
     * The quantity of corresponding book
     */
    private Integer quantity;

}
