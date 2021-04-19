package fr.aguiheneuf.bookstore.model;

import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import java.io.Serializable;
import java.math.BigDecimal;
import java.time.LocalDateTime;
import java.util.List;

/**
 * Entity class
 * Contains informations for books order
 *
 * @author Alexandre Guiheneuf
 */
@Getter
@Setter
@EqualsAndHashCode(of = "id")
@Entity
@Table(name = "t_order", schema = "bookstore")
public class Order implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_order")
    private Integer id;

    /**
     * The creation date of the order
     */
    @Column(name = "date_order", nullable = false)
    private LocalDateTime dateTime;

    /**
     * Contains détail of the order
     */
    @OneToMany(fetch = FetchType.LAZY, mappedBy = "order", cascade = CascadeType.ALL)
    private List<OrderDetail> orderDetails;

    /**
     * The total price of the order
     */
    @Column(name = "price_order", nullable = false)
    private BigDecimal price;

}
