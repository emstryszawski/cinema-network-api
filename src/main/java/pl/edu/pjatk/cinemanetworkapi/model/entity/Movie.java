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
@Table(name = "movie", schema = "cinema-network", indexes = {
        @Index(name = "categoryid_idx", columnList = "categoryid")
})
public class Movie {
    @Id
    @Column(name = "id", nullable = false)
    private Integer id;

    @Column(name = "title", nullable = false, length = 35)
    private String title;

    @Lob
    @Column(name = "description")
    private String description;

    @ManyToOne(fetch = FetchType.LAZY, optional = false)
    @JoinColumn(name = "categoryid", nullable = false)
    @ToString.Exclude
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
    @ToString.Exclude
    private Set<Repertoir> repertoires = new LinkedHashSet<>();

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || Hibernate.getClass(this) != Hibernate.getClass(o)) return false;
        Movie movie = (Movie) o;
        return id != null && Objects.equals(id, movie.id);
    }

    @Override
    public int hashCode() {
        return getClass().hashCode();
    }
}