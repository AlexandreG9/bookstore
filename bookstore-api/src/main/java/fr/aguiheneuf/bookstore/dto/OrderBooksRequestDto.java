package fr.aguiheneuf.bookstore.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;
import java.util.Set;

/**
 * @author Alexandre Guiheneuf
 */
@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder(toBuilder = true)
public class OrderBooksRequestDto implements Serializable {

    private Set<BookRequestDto> bookRequestDtos;

}
