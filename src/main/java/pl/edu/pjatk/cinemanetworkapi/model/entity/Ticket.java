package pl.edu.pjatk.cinemanetworkapi.model.entity;

import javax.persistence.*;

@Entity
@Table(name = "ticket", indexes = {
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
    private Cinema cinema;

    @ManyToOne(fetch = FetchType.LAZY, optional = false)
    @JoinColumn(name = "repertoirid", nullable = false)
    private Repertoir repertoir;

    @ManyToOne(fetch = FetchType.LAZY, optional = false)
    @JoinColumn(name = "purchaseid", nullable = false)
    private Purchase purchase;

    @ManyToOne(fetch = FetchType.LAZY, optional = false)
    @JoinColumn(name = "tickettypediscountid", nullable = false)
    private TicketTypeDiscount ticketTypeDiscount;

    @ManyToOne(fetch = FetchType.LAZY, optional = false)
    @JoinColumn(name = "seatbookingid", nullable = false)
    private SeatBooking seatBooking;
}