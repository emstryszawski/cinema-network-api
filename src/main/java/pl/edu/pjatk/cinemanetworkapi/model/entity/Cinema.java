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
@Table(name = "cinema")
public class Cinema {
    @Id
    @Column(name = "id", nullable = false)
    private Long id;

    @Column(name = "name", nullable = false, length = 35)
    private String name;

    @Column(name = "city", nullable = false, length = 50)
    private String city;

    @Column(name = "postcode", nullable = false, length = 6)
    private String postCode;

    @Column(name = "street", nullable = false, length = 50)
    private String street;

    @OneToMany(mappedBy = "cinema")
    private Set<ScreeningRoom> screeningRooms = new LinkedHashSet<>();

    @OneToMany(mappedBy = "cinema")
    private Set<Repertoire> repertoires = new LinkedHashSet<>();

    @OneToMany(mappedBy = "cinema")
    @JsonIgnore
    private Set<Ticket> tickets = new LinkedHashSet<>();
}