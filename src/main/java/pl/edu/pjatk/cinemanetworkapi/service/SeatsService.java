package pl.edu.pjatk.cinemanetworkapi.service;

import org.springframework.stereotype.Service;
import pl.edu.pjatk.cinemanetworkapi.model.dto.PurchaseTickets;
import pl.edu.pjatk.cinemanetworkapi.model.dto.SeatRequest;
import pl.edu.pjatk.cinemanetworkapi.model.dto.SeatResponse;
import pl.edu.pjatk.cinemanetworkapi.model.entity.*;
import pl.edu.pjatk.cinemanetworkapi.model.repository.*;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

@Service
public class SeatsService {
    private SeatRepository seatRepository;
    private SeatBookingRepository seatBookingRepository;
    private ScreeningRoomRepository screeningRoomRepository;
    private TicketRepository ticketRepository;
    private PurchaseRepository purchaseRepository;


    public SeatsService(SeatRepository seatRepository,
                        SeatBookingRepository seatBookingRepository,
                        ScreeningRoomRepository screeningRoomRepository,
                        TicketRepository ticketRepository,
                        PurchaseRepository purchaseRepository) {
        this.seatRepository = seatRepository;
        this.seatBookingRepository = seatBookingRepository;
        this.screeningRoomRepository = screeningRoomRepository;
        this.ticketRepository = ticketRepository;
        this.purchaseRepository = purchaseRepository;
    }

    public List<SeatResponse> getAllSeatsInScreeningRoom(Long screeningRoomId) {
        List<Seat> allSeats = seatRepository.findAllByScreeningRoomId(screeningRoomId);
        return allSeats.stream()
                .map(seat -> SeatResponse.builder()
                        .screeningRoomId(seat.getScreeningRoom().getId())
                        .seatNumber(seat.getSeatNumber())
                        .rowNumber(seat.getRowNumber())
                        .build())
                .collect(Collectors.toList());
    }

    public void addNewSeatBooking(SeatRequest seatRequest, Long correlationId) {

        List<Long> seatIds = seatRequest.getSeatIds();
        List<Ticket> tickets = ticketRepository.findByCorrelationId(correlationId);
        List<SeatBooking> seatBookings = new ArrayList<>();
        for (Long seatId : seatIds) {
            SeatBooking seatBooking = new SeatBooking();
            Seat seat = seatRepository.findById(seatId).orElse(null);
            seatBooking.setSeat(seat);
            seatBooking.setAvailability("Booked");
            seatBooking.setStartDate(LocalDateTime.now());
            seatBookings.add(seatBooking);
            seatBookingRepository.save(seatBooking);
        }

        for (int i = 0; i < seatIds.size(); i++) {
            SeatBooking seatBooking = new SeatBooking();
            Seat seat = seatRepository.findById(seatIds.get(i)).orElse(null);
            seatBooking.setSeat(seat);
            seatBooking.setAvailability("Booked");
            seatBooking.setStartDate(LocalDateTime.now());
            tickets.get(i).setSeatBooking(seatBooking);
            seatBookingRepository.save(seatBooking);
        }
        ticketRepository.saveAll(tickets);
    }
}
