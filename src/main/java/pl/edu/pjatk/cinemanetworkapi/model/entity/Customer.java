package pl.edu.pjatk.cinemanetworkapi.model.entity;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;

@Entity
@Getter
@Setter
@NoArgsConstructor
@Table(name = "customer")
public class Customer {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id", nullable = false)
    private Long id;

    @Column(name = "firstname", nullable = false, length = 50)
    private String firstname;

    @Column(name = "lastname", nullable = false, length = 50)
    private String lastname;

    @Column(name = "email", nullable = false, length = 85)
    private String email;

    @Column(name = "phonenumber", nullable = false, length = 9)
    private String phoneNumber;

    @OneToOne(fetch = FetchType.LAZY, mappedBy = "customer")
    private RegisteredUser registeredUser;
}
