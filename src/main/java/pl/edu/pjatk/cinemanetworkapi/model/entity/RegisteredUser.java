package pl.edu.pjatk.cinemanetworkapi.model.entity;

import javax.persistence.*;
import java.time.LocalDate;

@Entity
@Table(name = "registereduser", indexes = {
        @Index(name = "customerid_idx", columnList = "customerid")
})
public class RegisteredUser {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id", nullable = false)
    private Long id;

    @Column(name = "password", nullable = false, length = 256)
    private String password;

    @Column(name = "birthdate", nullable = false)
    private LocalDate birthdate;

    @OneToOne(fetch = FetchType.LAZY, optional = false)
    @JoinColumn(name = "customerid", nullable = false)
    private Customer customer;
}