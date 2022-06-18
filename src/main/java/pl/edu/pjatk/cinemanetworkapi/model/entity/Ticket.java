package pl.edu.pjatk.cinemanetworkapi.model.entity;

import lombok.*;
import org.hibernate.Hibernate;

import javax.persistence.*;
import java.util.Objects;

@Entity
@Getter
@Setter
@ToString
@RequiredArgsConstructor
@Table(name = "ticket", schema = "cinema-network", indexes = {
        @Index(name = "tickettypediscountid_idx", columnList = "tickettypediscountid"),
        @Index(name = "ticketpurchaseid_idx", columnList = "purchaseid"),
        @Index(name = "ticketrepertoirid_idx", columnList = "repertoirid"),
        @Index(name = "ticketcinemaid_idx", columnList = "cinemaid"),
        @Index(name = "ticketseatbooking_idx", columnList = "seatbookingid")
})
public class Ticket {
    @Id
    @Column(name = "id", nullable = false)
    private Integer id;

    @ManyToOne(fetch = FetchType.LAZY, optional = false)
    @JoinColumn(name = "cinemaid", nullable = false)
    @ToString.Exclude
    private Cinema cinema;

    @ManyToOne(fetch = FetchType.LAZY, optional = false)
    @JoinColumn(name = "repertoirid", nullable = false)
    @ToString.Exclude
    private Repertoir repertoir;

    @ManyToOne(fetch = FetchType.LAZY, optional = false)
    @JoinColumn(name = "purchaseid", nullable = false)
    @ToString.Exclude
    private Purchase purchase;

    @ManyToOne(fetch = FetchType.LAZY, optional = false)
    @JoinColumn(name = "tickettypediscountid", nullable = false)
    @ToString.Exclude
    private TicketTypeDiscount ticketTypeDiscount;

    @ManyToOne(fetch = FetchType.LAZY, optional = false)
    @JoinColumn(name = "seatbookingid", nullable = false)
    @ToString.Exclude
    private Seatbooking seatBooking;

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || Hibernate.getClass(this) != Hibernate.getClass(o)) return false;
        Ticket ticket = (Ticket) o;
        return id != null && Objects.equals(id, ticket.id);
    }

    @Override
    public int hashCode() {
        return getClass().hashCode();
    }
}