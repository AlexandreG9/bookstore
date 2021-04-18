package fr.aguiheneuf.bookstore.dto;

import lombok.Data;
import lombok.NonNull;

import java.io.Serializable;

/**
 * @author Alexandre Guiheneuf
 */
@Data
public class BookRequestDto implements Serializable {
    private String isbn;

    private Integer quantity;
}
