package fr.aguiheneuf.bookstore.dto;

import lombok.*;

import java.io.Serializable;
import java.math.BigDecimal;

/**
 * @author Alexandre Guiheneuf
 */
@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder(toBuilder = true)
public class BookDto implements Serializable {

    private String isbn;

    private String title;

    private BigDecimal price;
}
