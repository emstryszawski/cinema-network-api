package pl.edu.pjatk.cinemanetworkapi.model.entity;

import lombok.*;
import org.hibernate.Hibernate;
import pl.edu.pjatk.cinemanetworkapi.model.DeliveryMethodEnum;
import pl.edu.pjatk.cinemanetworkapi.model.PaymentMethodEnum;

import javax.persistence.*;
import java.time.LocalDateTime;
import java.util.Objects;

@Entity
@Getter
@Setter
@ToString
@RequiredArgsConstructor
@Table(name = "buy", schema = "cinema-network", indexes = {
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

    @Enumerated(EnumType.STRING)
    @Column(name = "deliverymethod", nullable = false, length = 50)
    private DeliveryMethodEnum deliveryMethod;

    @OneToOne(fetch = FetchType.LAZY, optional = false)
    @JoinColumn(name = "purchaseid", nullable = false)
    @ToString.Exclude
    private Purchase purchase;

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || Hibernate.getClass(this) != Hibernate.getClass(o)) return false;
        Buy buy = (Buy) o;
        return id != null && Objects.equals(id, buy.id);
    }

    @Override
    public int hashCode() {
        return getClass().hashCode();
    }
}