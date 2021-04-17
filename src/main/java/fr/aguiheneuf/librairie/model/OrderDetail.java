package fr.aguiheneuf.librairie.model;

import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import java.io.Serializable;

/**
 * @author Alexandre Guiheneuf
 */
@Getter
@Setter
@EqualsAndHashCode(of = "id")
@Entity
@Table(name = "t_order_detail", schema = "bookstore")
public class OrderDetail implements Serializable {

    @Id
    @Column(name="id_order_detail")
    private Integer id;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "isbn_book")
    private Book book;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "id_order")
    private Order order;

    @Column(name = "quantity_book_order_detail")
    private Integer quantity;
}
