package pl.edu.pjatk.cinemanetworkapi.model.dto;

import lombok.Data;

@Data
public class CustomerRequest {
    private String firstname;
    private String lastname;
    private String email;
    private String phoneNumber;
}
