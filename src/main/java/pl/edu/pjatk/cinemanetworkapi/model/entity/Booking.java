package pl.edu.pjatk.cinemanetworkapi.model.entity;

import javax.persistence.*;
import java.time.LocalDateTime;

@Entity
@Table(name = "booking", indexes = {
        @Index(name = "bookingpurchaseid_idx", columnList = "purchaseid")
})
public class Booking {
    @Id
    @Column(name = "id", nullable = false)
    private Integer id;

    @Column(name = "duedate", nullable = false)
    private LocalDateTime dueDate;

    @Column(name = "cancelable", nullable = false)
    private Boolean paid = false;

    @OneToOne(fetch = FetchType.LAZY, optional = false)
    @JoinColumn(name = "purchaseid", nullable = false)
    private Purchase purchase;
}