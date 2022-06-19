package pl.edu.pjatk.cinemanetworkapi.model.entity;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import java.util.LinkedHashSet;
import java.util.Set;

@Entity
@Getter
@Setter
@Table(name = "screeningroom", indexes = {
        @Index(name = "cinemaid_idx", columnList = "cinemaid")
})
public class ScreeningRoom {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id", nullable = false)
    private Long id;

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
    private Set<Repertoire> repertoires = new LinkedHashSet<>();
}