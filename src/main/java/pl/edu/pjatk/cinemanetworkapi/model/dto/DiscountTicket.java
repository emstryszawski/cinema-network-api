package pl.edu.pjatk.cinemanetworkapi.model.dto;

import lombok.Data;

@Data
public class DiscountTicket {
    private Long repertoireId;
    private Long cinemaId;
    private Long discountId;
    private Long numberOfTickets;
}
