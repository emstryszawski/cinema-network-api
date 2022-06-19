package pl.edu.pjatk.cinemanetworkapi.model.entity;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;
import java.time.LocalDateTime;
import java.util.LinkedHashSet;
import java.util.Set;

@Entity
@Getter
@Setter
@NoArgsConstructor
@Table(name = "seatbooking", indexes = {
        @Index(name = "seatid_idx", columnList = "seatid")
})
public class SeatBooking {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id", nullable = false)
    private Long id;

    @ManyToOne(fetch = FetchType.LAZY, optional = false)
    @JoinColumn(name = "seatid", nullable = false)
    private Seat seat;

    @Column(name = "availability", nullable = false, length = 20)
    private String availability;

    @Column(name = "startdate", nullable = false)
    private LocalDateTime startDate;

    @OneToMany(mappedBy = "seatBooking")
    private Set<Ticket> tickets = new LinkedHashSet<>();
}