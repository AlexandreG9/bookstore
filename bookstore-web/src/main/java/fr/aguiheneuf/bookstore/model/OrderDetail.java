package fr.aguiheneuf.bookstore.model;

import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import java.io.Serializable;

/**
 * Compose {@link Order}
 * Contains the detail of a book order
 *
 * @author Alexandre Guiheneuf
 */
@Getter
@Setter
@EqualsAndHashCode(of = "id")
@Entity
@Table(name = "t_order_detail", schema = "bookstore")
public class OrderDetail implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name="id_order_detail")
    private Integer id;

    /**
     * The book associated this {@link OrderDetail}
     */
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "isbn_book")
    private Book book;

    /**
     * The order that contains this {@link OrderDetail}
     */
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "id_order")
    private Order order;

    /**
     * The quantity books
     */
    @Column(name = "quantity_book_order_detail")
    private Integer quantity;
}
