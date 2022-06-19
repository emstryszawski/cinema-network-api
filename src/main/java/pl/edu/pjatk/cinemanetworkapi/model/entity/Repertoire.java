package pl.edu.pjatk.cinemanetworkapi.model.entity;

import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import java.time.LocalDateTime;
import java.util.LinkedHashSet;
import java.util.Set;

@Entity
@Getter
@Setter
@Table(name = "repertoir", indexes = {
        @Index(name = "movieid_idx", columnList = "movieid"),
        @Index(name = "repertoirscreeningroomid_idx", columnList = "screeningroomid"),
        @Index(name = "repertoircinemaid_idx", columnList = "cinemaid")
})
public class Repertoire {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id", nullable = false)
    private Long id;

    @Column(name = "screeningtype", nullable = false, length = 2)
    private String screeningType;

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
    private Boolean bookingpossible;

    @ManyToOne(fetch = FetchType.EAGER, optional = false)
    @JoinColumn(name = "cinemaid", nullable = false)
    @JsonIgnore
    private Cinema cinema;

    @ManyToOne(fetch = FetchType.EAGER, optional = false)
    @JoinColumn(name = "screeningroomid", nullable = false)
    @JsonIgnore
    private ScreeningRoom screeningRoom;

    @ManyToOne(fetch = FetchType.EAGER, optional = false)
    @JoinColumn(name = "movieid", nullable = false)
    private Movie movie;

    @OneToMany(mappedBy = "repertoire")
    @JsonIgnore
    private Set<Ticket> tickets = new LinkedHashSet<>();

}