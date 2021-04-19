package fr.aguiheneuf.bookstore.dto;

import lombok.*;

import java.io.Serializable;

/**
 * Input object used to find book
 *
 * @see OrderBooksRequestDto
 * @author Alexandre Guiheneuf
 */
@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder(toBuilder = true)
public class BookRequestDto implements Serializable {

    /**
     * The id of the requested book
     */
    private String isbn;

    /**
     * The quantity of the requested book
     */
    private Integer quantity;
}
