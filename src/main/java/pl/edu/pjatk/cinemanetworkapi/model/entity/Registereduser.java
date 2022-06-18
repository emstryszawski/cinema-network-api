package pl.edu.pjatk.cinemanetworkapi.model.entity;

import javax.persistence.*;
import java.time.LocalDate;

@Entity
@Table(name = "registereduser", indexes = {
        @Index(name = "customerid_idx", columnList = "customerid")
})
public class Registereduser {
    @Id
    @Column(name = "id", nullable = false)
    private Integer id;

    @Column(name = "password", nullable = false, length = 256)
    private String password;

    @Column(name = "birthdate", nullable = false)
    private LocalDate birthdate;

    @OneToOne(fetch = FetchType.LAZY, optional = false)
    @JoinColumn(name = "customerid", nullable = false)
    private Customer customer;
}