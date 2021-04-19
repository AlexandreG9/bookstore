package fr.aguiheneuf.bookstore.model;

import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.Setter;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import java.math.BigDecimal;

/**
 * @author Alexandre Guiheneuf
 */
@Getter
@Setter
@Entity
@EqualsAndHashCode(of = "isbn")
@Table(name = "t_book", schema = "bookstore")
public class Book {

    /**
     * ISBN is unique identifier for a book
     */
    @Id
    @Column(name = "isbn_book")
    private String isbn;

    /**
     * The title of the book
     */
    @Column(name = "title_book", nullable = false)
    private String title;

    /**
     * The price of the book
     */
    @Column(name = "price_book")
    private BigDecimal price;

}
