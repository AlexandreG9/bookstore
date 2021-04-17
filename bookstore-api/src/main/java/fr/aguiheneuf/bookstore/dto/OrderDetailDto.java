package fr.aguiheneuf.bookstore.dto;

import lombok.Builder;
import lombok.Value;

import java.io.Serializable;

/**
 * @author Alexandre Guiheneuf
 */
@Value
@Builder(toBuilder = true)
public class OrderDetailDto implements Serializable {

    private BookDto book;

    private Integer quantity;

}
