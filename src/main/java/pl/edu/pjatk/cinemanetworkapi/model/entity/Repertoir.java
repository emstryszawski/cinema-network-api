package pl.edu.pjatk.cinemanetworkapi.model.entity;

import lombok.*;
import org.hibernate.Hibernate;
import pl.edu.pjatk.cinemanetworkapi.model.ScreeningTypeEnum;

import javax.persistence.*;
import java.time.LocalDateTime;
import java.util.LinkedHashSet;
import java.util.Objects;
import java.util.Set;

@Entity
@Getter
@Setter
@ToString
@RequiredArgsConstructor
@Table(name = "repertoir", schema = "cinema-network", indexes = {
        @Index(name = "movieid_idx", columnList = "movieid"),
        @Index(name = "repertoirscreeningroomid_idx", columnList = "screeningroomid"),
        @Index(name = "repertoircinemaid_idx", columnList = "cinemaid")
})
public class Repertoir {
    @Id
    @Column(name = "id", nullable = false)
    private Integer id;

    @Enumerated(EnumType.STRING)
    @Column(name = "screeningtype", nullable = false, length = 2)
    private ScreeningTypeEnum screeningtype;

    @Column(name = "startdatetime", nullable = false)
    private LocalDateTime startDateTime;

    @Column(name = "enddatetime", nullable = false)
    private LocalDateTime endDateTime;

    @Column(name = "dayoftheweek", nullable = false, length = 12)
    private String dayOfTheWeek;

    @Column(name = "language", nullable = false, length = 2)
    private String language;

    @Column(name = "subtitles")
    private Boolean subtitles;

    @Column(name = "dubbing")
    private Boolean dubbing;

    @Column(name = "lector")
    private Boolean lector;

    @Column(name = "bookingpossible")
    private Boolean bookingPossible;

    @ManyToOne(fetch = FetchType.LAZY, optional = false)
    @JoinColumn(name = "cinemaid", nullable = false)
    @ToString.Exclude
    private Cinema cinema;

    @ManyToOne(fetch = FetchType.LAZY, optional = false)
    @JoinColumn(name = "screeningroomid", nullable = false)
    @ToString.Exclude
    private ScreeningRoom screeningRoom;

    @ManyToOne(fetch = FetchType.LAZY, optional = false)
    @JoinColumn(name = "movieid", nullable = false)
    @ToString.Exclude
    private Movie movie;

    @OneToMany(mappedBy = "repertoir")
    @ToString.Exclude
    private Set<Ticket> tickets = new LinkedHashSet<>();

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || Hibernate.getClass(this) != Hibernate.getClass(o)) return false;
        Repertoir repertoir = (Repertoir) o;
        return id != null && Objects.equals(id, repertoir.id);
    }

    @Override
    public int hashCode() {
        return getClass().hashCode();
    }
}