package pl.edu.pjatk.cinemanetworkapi.model.entity;

import javax.persistence.*;
import java.util.LinkedHashSet;
import java.util.Set;

@Entity
@Table(name = "cinema")
public class Cinema {
    @Id
    @Column(name = "id", nullable = false)
    private Integer id;

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
    private Set<Repertoir> repertoires = new LinkedHashSet<>();

    @OneToMany(mappedBy = "cinema")
    private Set<Ticket> tickets = new LinkedHashSet<>();

}