package pl.edu.pjatk.cinemanetworkapi.model.entity;

import javax.persistence.*;
import java.time.LocalDateTime;
import java.util.LinkedHashSet;
import java.util.Set;

@Entity
@Table(name = "purchase", indexes = {
        @Index(name = "purchasecustomerid_idx", columnList = "customerid")
})
public class Purchase {
    @Id
    @Column(name = "id", nullable = false)
    private Integer id;

    @Column(name = "purchasedate", nullable = false)
    private LocalDateTime purchasedate;

    @Column(name = "price", nullable = false)
    private Double price;

    @ManyToOne(fetch = FetchType.LAZY, optional = false)
    @JoinColumn(name = "customerid", nullable = false)
    private Customer customer;

    @OneToOne(fetch = FetchType.LAZY, mappedBy = "purchase")
    private Buy buy;

    @OneToMany(mappedBy = "purchase")
    private Set<Ticket> tickets = new LinkedHashSet<>();

    @OneToOne(fetch = FetchType.LAZY, mappedBy = "purchase")
    private Booking booking;
}