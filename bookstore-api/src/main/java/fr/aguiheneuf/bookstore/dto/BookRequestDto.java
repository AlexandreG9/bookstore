package fr.aguiheneuf.bookstore.dto;

import lombok.*;

import java.io.Serializable;

/**
 * @author Alexandre Guiheneuf
 */
@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder(toBuilder = true)
public class BookRequestDto implements Serializable {
    private String isbn;

    private Integer quantity;
}
