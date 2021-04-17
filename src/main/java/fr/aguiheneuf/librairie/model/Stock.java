package fr.aguiheneuf.librairie.model;

import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import java.io.Serializable;

/**
 * Books stock in the bookstore
 *
 * @author Alexandre Guiheneuf
 */
@Getter
@Setter
@EqualsAndHashCode(of = "id")
@Entity
@Table(name = "t_stock", schema = "bookstore")
public class Stock implements Serializable {

    @Id
    @Column(name = "id_stock")
    private Integer id;

    @OneToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "isbn_book")
    private Book book;

    @Column(name = "quantity_stock")
    private Integer quantity;
}
