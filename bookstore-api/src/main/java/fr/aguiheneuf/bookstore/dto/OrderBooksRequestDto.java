package fr.aguiheneuf.bookstore.dto;

import lombok.Data;

import java.io.Serializable;
import java.util.Set;

/**
 * @author Alexandre Guiheneuf
 */
@Data
public class OrderBooksRequestDto implements Serializable {

    private Set<BookRequestDto> bookRequestDtos;

}
