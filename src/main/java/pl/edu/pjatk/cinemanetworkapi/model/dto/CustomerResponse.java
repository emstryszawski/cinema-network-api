package pl.edu.pjatk.cinemanetworkapi.model.dto;

import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class CustomerResponse {
    private String firstname;
    private String lastname;
    private String email;
    private String phoneNumber;
}
