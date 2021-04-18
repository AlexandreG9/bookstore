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
public class OrderDetailDto implements Serializable {

    private BookDto book;

    private Integer quantity;

}
