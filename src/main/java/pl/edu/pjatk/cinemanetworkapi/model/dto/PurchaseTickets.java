package pl.edu.pjatk.cinemanetworkapi.model.dto;

import lombok.Builder;
import lombok.Data;

import java.time.LocalDateTime;
import java.util.List;

@Data
@Builder
public class PurchaseTickets {
    private Long correlationId;
    private LocalDateTime purchaseDate;
    private Double price;
    private CustomerResponse customerResponse;
    private BuyResponse buyResponse;
    private List<TicketResponse> tickets;
}
