package pl.edu.pjatk.cinemanetworkapi.model.entity;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;
import java.time.LocalDateTime;
import java.util.List;

@Entity
@Getter
@Setter
@NoArgsConstructor
@Table(name = "purchase", indexes = {
        @Index(name = "purchasecustomerid_idx", columnList = "customerid")
})
public class Purchase {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id", nullable = false)
    private Long id;

    @Column(name = "purchasedate")
    private LocalDateTime purchasedate;

    @Column(name = "price", precision = 5, scale = 2)
    private Double price;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "customerid")
    private Customer customer;

    @OneToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "buyid")
    private Buy buy;

    @OneToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "bookingid")
    private Booking booking;

    @OneToMany(fetch = FetchType.LAZY, mappedBy = "purchase")
    private List<Ticket> tickets;

    @Column(name = "correlationid")
    private Long correlationId;
}
