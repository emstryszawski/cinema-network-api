package pl.edu.pjatk.cinemanetworkapi.model.dto;

import lombok.Data;

@Data
public class BuyRequest {
    private String deliveryMethod;
    private String paymentMethod;
}
