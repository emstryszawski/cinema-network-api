package pl.edu.pjatk.cinemanetworkapi.model.entity;

import lombok.*;
import org.hibernate.Hibernate;
import pl.edu.pjatk.cinemanetworkapi.model.AvailabilityEnum;

import javax.persistence.*;
import java.util.LinkedHashSet;
import java.util.Objects;
import java.util.Set;

@Entity
@Getter
@Setter
@ToString
@RequiredArgsConstructor
@Table(name = "seatbooking", schema = "cinema-network", indexes = {
        @Index(name = "seatid_idx", columnList = "seatid")
})
public class SeatBooking {
    @Id
    @Column(name = "id", nullable = false)
    private Integer id;

    @ManyToOne(fetch = FetchType.LAZY, optional = false)
    @JoinColumn(name = "seatid", nullable = false)
    @ToString.Exclude
    private Seat seat;

    @Enumerated(EnumType.STRING)
    @Column(name = "availability", nullable = false, length = 20)
    private AvailabilityEnum availability;

    @Column(name = "startdate", nullable = false)
    private Integer startDate;

    @OneToMany(mappedBy = "seatBooking")
    @ToString.Exclude
    private Set<Ticket> tickets = new LinkedHashSet<>();

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || Hibernate.getClass(this) != Hibernate.getClass(o)) return false;
        SeatBooking that = (SeatBooking) o;
        return id != null && Objects.equals(id, that.id);
    }

    @Override
    public int hashCode() {
        return getClass().hashCode();
    }
}