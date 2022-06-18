package pl.edu.pjatk.cinemanetworkapi.model.entity;

import javax.persistence.*;
import java.util.LinkedHashSet;
import java.util.Set;

@Entity
@Table(name = "customer")
public class Customer {
    @Id
    @Column(name = "id", nullable = false)
    private Integer id;

    @Column(name = "firstname", nullable = false, length = 50)
    private String firstname;

    @Column(name = "lastname", nullable = false, length = 50)
    private String lastname;

    @Column(name = "email", nullable = false, length = 85)
    private String email;

    @Column(name = "phonenumber", nullable = false, length = 9)
    private String phoneNumber;

    @OneToOne(fetch = FetchType.LAZY, mappedBy = "customer")
    private Registereduser registeredUser;

    @OneToMany(mappedBy = "customer")
    private Set<Purchase> purchases = new LinkedHashSet<>();
}