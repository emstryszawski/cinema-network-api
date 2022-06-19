package pl.edu.pjatk.cinemanetworkapi.service;

import org.springframework.stereotype.Service;
import pl.edu.pjatk.cinemanetworkapi.model.DeliveryMethodEnum;
import pl.edu.pjatk.cinemanetworkapi.model.PaymentMethodEnum;
import pl.edu.pjatk.cinemanetworkapi.model.dto.BuyRequest;
import pl.edu.pjatk.cinemanetworkapi.model.entity.Buy;
import pl.edu.pjatk.cinemanetworkapi.model.entity.Purchase;
import pl.edu.pjatk.cinemanetworkapi.model.repository.BuyRepository;
import pl.edu.pjatk.cinemanetworkapi.model.repository.PurchaseRepository;

import java.time.LocalDateTime;

@Service
public class BuyService {
    private final BuyRepository buyRepository;
    private final PurchaseRepository purchaseRepository;

    public BuyService(BuyRepository buyRepository, PurchaseRepository purchaseRepository) {
        this.buyRepository = buyRepository;
        this.purchaseRepository = purchaseRepository;
    }

    public void addBuy(BuyRequest buyRequest, Long correlationId) {
        Purchase purchase = purchaseRepository.findByCorrelationId(correlationId);
        Buy buy = new Buy();
        buy.setDeliveryMethod(DeliveryMethodEnum.valueOf(buyRequest.getDeliveryMethod()));
        buy.setPaymentMethod(PaymentMethodEnum.valueOf(buyRequest.getPaymentMethod()));
        buy.setPaidDate(LocalDateTime.now());
        buy.setPaid(true);
        buy.setCorrelationId(correlationId);

        buyRepository.save(buy);
        purchase.setBuy(buy);
        purchaseRepository.save(purchase);
    }
}
