package pl.edu.pjatk.cinemanetworkapi.model.entity;

import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import java.util.LinkedHashSet;
import java.util.Set;

@Entity
@Getter
@Setter
@Table(name = "movie", indexes = {
        @Index(name = "categoryid_idx", columnList = "categoryid")
})
public class Movie {
    @Id
    @Column(name = "id", nullable = false)
    private Long id;

    @Column(name = "title", nullable = false, length = 100)
    private String title;

    @Column(name = "description", length = 2056)
    private String description;

    @ManyToOne(fetch = FetchType.EAGER, optional = false)
    @JoinColumn(name = "categoryid", nullable = false)
    private Category category;

    @Column(name = "duration", nullable = false)
    private Integer duration;

    @Column(name = "rrating", nullable = false, length = 5)
    private String rRating;

    @Column(name = "trailerpath", nullable = false, length = 256)
    private String trailerPath;

    @Column(name = "coverpicturepath", nullable = false, length = 256)
    private String coverPicturePath;

    @Column(name = "pathtofilmweb", nullable = false, length = 256)
    private String pathToFilmWeb;

    @OneToMany(mappedBy = "movie")
    @JsonIgnore
    private Set<Repertoire> repertoires = new LinkedHashSet<>();
}