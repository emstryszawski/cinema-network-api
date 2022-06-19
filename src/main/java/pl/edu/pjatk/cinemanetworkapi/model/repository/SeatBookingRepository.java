package pl.edu.pjatk.cinemanetworkapi.model.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import pl.edu.pjatk.cinemanetworkapi.model.entity.SeatBooking;

@Repository
public interface SeatBookingRepository extends JpaRepository<SeatBooking, Long> {
}