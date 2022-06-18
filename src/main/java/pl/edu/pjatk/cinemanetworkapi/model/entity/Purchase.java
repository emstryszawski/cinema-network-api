package pl.edu.pjatk.cinemanetworkapi.model.entity;

import lombok.*;
import org.hibernate.Hibernate;

import javax.persistence.*;
import java.math.BigDecimal;
import java.time.Instant;
import java.util.LinkedHashSet;
import java.util.Objects;
import java.util.Set;

@Entity
@Getter
@Setter
@ToString
@RequiredArgsConstructor
@Table(name = "purchase", schema = "cinema-network", indexes = {
        @Index(name = "purchasecustomerid_idx", columnList = "customerid")
})
public class Purchase {
    @Id
    @Column(name = "id", nullable = false)
    private Integer id;

    @Column(name = "purchasedate", nullable = false)
    private Instant purchaseDate;

    @Column(name = "price", nullable = false, precision = 5, scale = 2)
    private BigDecimal price;

    @ManyToOne(fetch = FetchType.LAZY, optional = false)
    @JoinColumn(name = "customerid", nullable = false)
    @ToString.Exclude
    private Customer customer;

    @OneToOne(fetch = FetchType.LAZY, mappedBy = "purchase")
    @ToString.Exclude
    private Buy buys;

    @OneToMany(mappedBy = "purchase")
    @ToString.Exclude
    private Set<Ticket> tickets = new LinkedHashSet<>();

    @OneToOne(fetch = FetchType.LAZY, mappedBy = "purchase")
    @ToString.Exclude
    private Booking bookings;

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || Hibernate.getClass(this) != Hibernate.getClass(o)) return false;
        Purchase purchase = (Purchase) o;
        return id != null && Objects.equals(id, purchase.id);
    }

    @Override
    public int hashCode() {
        return getClass().hashCode();
    }
}