package fr.aguiheneuf.bookstore.dto;

import lombok.*;

import java.util.List;

/**
 * Dto object used to find book through bookstore
 *
 * @author Alexandre Guiheneuf
 */
@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder(toBuilder = true)
public class SearchBookRequestDto {

    /**
     * The list of book's isbn
     */
    private List<String> isbnList;

}
