package pl.edu.pjatk.cinemanetworkapi.model.dto;

import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class TicketResponse {
    private String cinemaName;
    private String movieTitle;
    private String ticketTypeName;
    private Integer seatNumber;
    private Integer rowNumber;
}
