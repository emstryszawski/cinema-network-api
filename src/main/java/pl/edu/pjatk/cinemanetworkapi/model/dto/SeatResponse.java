package pl.edu.pjatk.cinemanetworkapi.model.dto;

import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class SeatResponse {
    private Long screeningRoomId;
    private Integer seatNumber;
    private Integer rowNumber;
}
