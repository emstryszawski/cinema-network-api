package pl.edu.pjatk.cinemanetworkapi.model.entity;

import javax.persistence.*;
import java.util.LinkedHashSet;
import java.util.Set;

@Entity
@Table(name = "screeningroom", indexes = {
        @Index(name = "cinemaid_idx", columnList = "cinemaid")
})
public class ScreeningRoom {
    @Id
    @Column(name = "id", nullable = false)
    private Integer id;

    @Column(name = "roomnumber", nullable = false)
    private Integer roomNumber;

    @ManyToOne(fetch = FetchType.LAZY, optional = false)
    @JoinColumn(name = "cinemaid", nullable = false)
    private Cinema cinema;

    @Column(name = "rowsnumber", nullable = false)
    private Integer rowsNumber;

    @Column(name = "seatsnumber", nullable = false)
    private Integer seatsNumber;

    @OneToMany(mappedBy = "screeningRoom")
    private Set<Seat> seats = new LinkedHashSet<>();

    @OneToMany(mappedBy = "screeningRoom")
    private Set<Repertoir> repertoires = new LinkedHashSet<>();
}