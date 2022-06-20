package pl.edu.pjatk.cinemanetworkapi.model.entity;

import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;

@Entity
@Getter
@Setter
@NoArgsConstructor
@Table(name = "ticket", indexes = {
        @Index(name = "tickettypediscountid_idx", columnList = "tickettypediscountid"),
        @Index(name = "ticketpurchaseid_idx", columnList = "purchaseid"),
        @Index(name = "ticketrepertoirid_idx", columnList = "repertoirid"),
        @Index(name = "ticketcinemaid_idx", columnList = "cinemaid"),
        @Index(name = "ticketseatbooking_idx", columnList = "seatbookingid")
})
public class Ticket {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id", nullable = false)
    private Long id;

    @ManyToOne(fetch = FetchType.LAZY, optional = true)
    @JoinColumn(name = "cinemaid", nullable = true)
    private Cinema cinema;

    @ManyToOne(fetch = FetchType.LAZY, optional = true)
    @JoinColumn(name = "repertoirid", nullable = true)
    private Repertoire repertoire;

    @ManyToOne(fetch = FetchType.LAZY, optional = true)
    @JoinColumn(name = "purchaseid", nullable = true)
    @JsonIgnore
    private Purchase purchase;

    @ManyToOne(fetch = FetchType.LAZY, optional = true)
    @JoinColumn(name = "tickettypediscountid", nullable = true)
    private TicketTypeDiscount ticketTypeDiscount;

    @ManyToOne(fetch = FetchType.LAZY, optional = true)
    @JoinColumn(name = "seatbookingid", nullable = true)
    @JsonIgnore
    private SeatBooking seatBooking;

    @Column(name = "correlationid")
    private Long correlationId;
}
