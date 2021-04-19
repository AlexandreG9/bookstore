package fr.aguiheneuf.bookstore.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;
import java.util.Set;

/**
 * An input object to order books
 *
 * @author Alexandre Guiheneuf
 */
@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder(toBuilder = true)
public class OrderBooksRequestDto implements Serializable {

    /**
     * The list of requested books
     */
    private Set<BookRequestDto> bookRequestDtos;

}
