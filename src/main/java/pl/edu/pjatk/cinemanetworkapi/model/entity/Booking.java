package pl.edu.pjatk.cinemanetworkapi.model.entity;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import java.time.LocalDateTime;

@Entity
@Getter
@Setter
@Table(name = "booking")
public class Booking {
    @Id
    @Column(name = "id", nullable = false)
    private Long id;

    @Column(name = "duedate", nullable = false)
    private LocalDateTime dueDate;

    @Column(name = "cancelable", nullable = false)
    private Boolean paid = false;
}