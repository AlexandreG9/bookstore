package fr.aguiheneuf.bookstore.dto;

import lombok.Builder;
import lombok.Value;

import java.io.Serializable;
import java.math.BigDecimal;

/**
 * @author Alexandre Guiheneuf
 */
@Value
@Builder(toBuilder = true)
public class BookDto implements Serializable {

    private String isbn;

    private String title;

    private BigDecimal price;
}
