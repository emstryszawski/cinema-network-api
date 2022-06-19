package pl.edu.pjatk.cinemanetworkapi.model.entity;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import pl.edu.pjatk.cinemanetworkapi.model.DeliveryMethodEnum;
import pl.edu.pjatk.cinemanetworkapi.model.PaymentMethodEnum;

import javax.persistence.*;
import java.time.LocalDateTime;

@Entity
@Getter
@Setter
@NoArgsConstructor
@Table(name = "buy")
public class Buy {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id", nullable = false)
    private Long id;

    @Column(name = "paiddate", nullable = false)
    private LocalDateTime paidDate;

    @Column(name = "paid", nullable = false)
    private Boolean paid = false;

    @Enumerated(EnumType.STRING)
    @Column(name = "paymentmethod", nullable = false, length = 50)
    private PaymentMethodEnum paymentMethod;

    @Column(name = "deliverymethod", nullable = false, length = 50)
    private DeliveryMethodEnum deliveryMethod;

    @Column(name = "correlationid")
    private Long correlationId;
}