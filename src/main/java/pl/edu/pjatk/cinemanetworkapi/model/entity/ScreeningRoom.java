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
@Table(name = "screeningroom", schema = "cinema-network", indexes = {
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
    @ToString.Exclude
    private Cinema cinema;

    @Column(name = "rowsnumber", nullable = false)
    private Integer rowsNumber;

    @Column(name = "seatsnumber", nullable = false)
    private Integer seatsNumber;

    @OneToMany(mappedBy = "screeningRoom")
    @ToString.Exclude
    private Set<Seat> seats = new LinkedHashSet<>();

    @OneToMany(mappedBy = "screeningRoom")
    @ToString.Exclude
    private Set<Repertoir> repertoires = new LinkedHashSet<>();

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || Hibernate.getClass(this) != Hibernate.getClass(o)) return false;
        ScreeningRoom that = (ScreeningRoom) o;
        return id != null && Objects.equals(id, that.id);
    }

    @Override
    public int hashCode() {
        return getClass().hashCode();
    }
}