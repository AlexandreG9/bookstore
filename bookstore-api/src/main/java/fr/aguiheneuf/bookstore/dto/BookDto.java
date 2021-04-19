package fr.aguiheneuf.bookstore.dto;

import lombok.*;

import java.io.Serializable;
import java.math.BigDecimal;

/**
 * Contains book's informations
 *
 * @author Alexandre Guiheneuf
 */
@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder(toBuilder = true)
public class BookDto implements Serializable {

    /**
     * The isbn of the book
     */
    private String isbn;

    /**
     * The title
     */
    private String title;

    /**
     * The price of the book
     */
    private BigDecimal price;
}
