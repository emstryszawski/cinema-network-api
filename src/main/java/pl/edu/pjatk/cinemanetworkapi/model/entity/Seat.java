package pl.edu.pjatk.cinemanetworkapi.model.entity;

import lombok.*;
import org.hibernate.Hibernate;

import javax.persistence.*;
import java.util.LinkedHashSet;
import java.util.Objects;
import java.util.Set;

@Entity
@Getter
@Setter
@ToString
@RequiredArgsConstructor
@Table(name = "seat", schema = "cinema-network", indexes = {
        @Index(name = "seatscreeningroomid_idx", columnList = "screeningroomid")
})
public class Seat {
    @Id
    @Column(name = "id", nullable = false)
    private Integer id;

    @ManyToOne(fetch = FetchType.LAZY, optional = false)
    @JoinColumn(name = "screeningroomid", nullable = false)
    @ToString.Exclude
    private ScreeningRoom screeningRoom;

    @Column(name = "seatnumber", nullable = false)
    private Integer seaNumber;

    @Column(name = "rownumber", nullable = false)
    private Integer rowNumber;

    @OneToMany(mappedBy = "seat")
    @ToString.Exclude
    private Set<SeatBooking> seatBookings = new LinkedHashSet<>();

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || Hibernate.getClass(this) != Hibernate.getClass(o)) return false;
        Seat seat = (Seat) o;
        return id != null && Objects.equals(id, seat.id);
    }

    @Override
    public int hashCode() {
        return getClass().hashCode();
    }
}