package fr.aguiheneuf.bookstore.dto;

import lombok.*;

import java.util.List;

/**
 * Dto object used to find book through bookstore
 *
 * @author Alexandre Guiheneuf
 */
@Data
public class SearchBookRequestDto {

    private List<String> isbnList;

}
