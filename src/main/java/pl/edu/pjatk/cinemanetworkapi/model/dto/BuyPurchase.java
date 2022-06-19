package pl.edu.pjatk.cinemanetworkapi.model.dto;

import lombok.Builder;
import lombok.Data;
import pl.edu.pjatk.cinemanetworkapi.model.entity.Buy;
import pl.edu.pjatk.cinemanetworkapi.model.entity.Customer;

import java.time.LocalDateTime;

@Data
@Builder
public class BuyPurchase {
    private LocalDateTime purchaseDate;
    private Double price;
    private Customer customer;
    private Buy buy;
}
