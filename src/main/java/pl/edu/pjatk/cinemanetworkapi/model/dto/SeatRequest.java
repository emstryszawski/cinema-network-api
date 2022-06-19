package pl.edu.pjatk.cinemanetworkapi.model.dto;


import lombok.Data;

import java.util.List;

@Data
public class SeatRequest {
    private List<Long> seatIds;
}
