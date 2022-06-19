package pl.edu.pjatk.cinemanetworkapi.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Repository;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import pl.edu.pjatk.cinemanetworkapi.model.dto.SeatResponse;
import pl.edu.pjatk.cinemanetworkapi.model.entity.Seat;
import pl.edu.pjatk.cinemanetworkapi.service.SeatsService;

import java.util.List;

@Repository
@RequestMapping("/seats")
public class SeatsController {
    private SeatsService seatsService;

    @Autowired
    public SeatsController(SeatsService seatsService) {
        this.seatsService = seatsService;
    }

    @GetMapping("/{id}")
    public ResponseEntity<List<SeatResponse>> getAllSeatsInScreeningRoom(@PathVariable Long id) {
        return ResponseEntity.ok(seatsService.getAllSeatsInScreeningRoom(id));
    }
}
