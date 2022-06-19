package pl.edu.pjatk.cinemanetworkapi.model.dto;

import lombok.Builder;
import lombok.Data;

import java.time.LocalDateTime;

@Data
@Builder
public class BuyResponse {
    private String deliveryMethod;
    private String paymentMethod;
    private LocalDateTime paidDate;
    private Boolean paid;
}
