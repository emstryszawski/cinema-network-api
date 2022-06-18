package pl.edu.pjatk.cinemanetworkapi.model.entity;

import javax.persistence.*;
import java.util.LinkedHashSet;
import java.util.Set;

@Entity
@Table(name = "tickettypediscount")
public class TicketTypeDiscount {
    @Id
    @Column(name = "id", nullable = false)
    private Integer id;

    @Column(name = "name", nullable = false, length = 25)
    private String name;

    @Column(name = "discountvalue", nullable = false)
    private Integer discountValue;

    @OneToMany(mappedBy = "ticketTypeDiscount")
    private Set<Ticket> tickets = new LinkedHashSet<>();
}