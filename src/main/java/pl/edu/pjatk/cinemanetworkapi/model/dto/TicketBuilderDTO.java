package pl.edu.pjatk.cinemanetworkapi.model.dto;

import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class TicketBuilderDTO {
    private Integer ticketId;
    private Integer cinemaId;
    private Integer repertoireId;
    private Integer purchaseId;
    private Integer ticketTypeDiscountId;
    private Integer seatBookingId;
}
