package pl.edu.pjatk.cinemanetworkapi.model.entity;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;
import java.util.LinkedHashSet;
import java.util.Set;

@Entity
@Getter
@Setter
@NoArgsConstructor
@Table(name = "seat", indexes = {
        @Index(name = "seatscreeningroomid_idx", columnList = "screeningroomid")
})
public class Seat {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id", nullable = false)
    private Long id;

    @ManyToOne(fetch = FetchType.LAZY, optional = false)
    @JoinColumn(name = "screeningroomid", nullable = false)
    private ScreeningRoom screeningRoom;

    @Column(name = "seatnumber", nullable = false)
    private Integer seatNumber;

    @Column(name = "rownumber", nullable = false)
    private Integer rowNumber;

    @OneToMany(mappedBy = "seat")
    private Set<SeatBooking> seatBookings = new LinkedHashSet<>();
}