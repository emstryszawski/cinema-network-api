package pl.edu.pjatk.cinemanetworkapi.model.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import pl.edu.pjatk.cinemanetworkapi.model.entity.Booking;

public interface BookingRepository extends JpaRepository<Booking, Long> {
}