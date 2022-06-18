package pl.edu.pjatk.cinemanetworkapi.model.entity;

import pl.edu.pjatk.cinemanetworkapi.model.DeliveryMethodEnum;
import pl.edu.pjatk.cinemanetworkapi.model.PaymentMethodEnum;

import javax.persistence.*;
import java.time.LocalDateTime;

@Entity
@Table(name = "buy", indexes = {
        @Index(name = "buypurchaseid_idx", columnList = "purchaseid")
})
public class Buy {
    @Id
    @Column(name = "id", nullable = false)
    private Integer id;

    @Column(name = "paiddate", nullable = false)
    private LocalDateTime paidDate;

    @Column(name = "paid", nullable = false)
    private Boolean paid = false;

    @Enumerated(EnumType.STRING)
    @Column(name = "paymentmethod", nullable = false, length = 50)
    private PaymentMethodEnum paymentMethod;

    @Column(name = "deliverymethod", nullable = false, length = 50)
    private DeliveryMethodEnum deliveryMethod;

    @OneToOne(fetch = FetchType.LAZY, optional = false)
    @JoinColumn(name = "purchaseid", nullable = false)
    private Purchase purchase;
}