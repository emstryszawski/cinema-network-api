package pl.edu.pjatk.cinemanetworkapi.model.entity;

import lombok.*;
import org.hibernate.Hibernate;

import javax.persistence.*;
import java.time.LocalDateTime;
import java.util.Objects;

@Entity
@Getter
@Setter
@ToString
@RequiredArgsConstructor
@Table(name = "booking", schema = "cinema-network", indexes = {
        @Index(name = "bookingpurchaseid_idx", columnList = "purchaseid")
})
public class Booking {
    @Id
    @Column(name = "id", nullable = false)
    private Integer id;

    @Column(name = "duedate", nullable = false)
    private LocalDateTime dueDate;

    @Column(name = "cancelable", nullable = false)
    private Boolean cancelable = false;

    @OneToOne(fetch = FetchType.LAZY, optional = false)
    @JoinColumn(name = "purchaseid", nullable = false)
    @ToString.Exclude
    private Purchase purchase;

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || Hibernate.getClass(this) != Hibernate.getClass(o)) return false;
        Booking booking = (Booking) o;
        return id != null && Objects.equals(id, booking.id);
    }

    @Override
    public int hashCode() {
        return getClass().hashCode();
    }
}