package fr.aguiheneuf.librairie.model;

import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import java.io.Serializable;
import java.math.BigDecimal;
import java.time.LocalDateTime;
import java.util.Set;

/**
 * Entity class
 * Contains informations for the order
 *
 * @author Alexandre Guiheneuf
 */
@Getter
@Setter
@EqualsAndHashCode(onlyExplicitlyIncluded = true)
@Entity
@Table(name = "t_order", schema = "bookstore")
public class Order implements Serializable {

    @Id
    @Column(name="id_order")
    @EqualsAndHashCode.Include
    private Integer id;

    @Column(name = "date_order", nullable = false)
    private LocalDateTime dateTime;

    @OneToMany(fetch = FetchType.LAZY, mappedBy = "order")
    private Set<OrderDetail> orderDetails;

    @Column(name="price_order", nullable = false)
    private BigDecimal price;

}
