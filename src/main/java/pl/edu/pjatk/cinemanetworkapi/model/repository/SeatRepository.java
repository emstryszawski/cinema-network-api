package pl.edu.pjatk.cinemanetworkapi.model.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import pl.edu.pjatk.cinemanetworkapi.model.entity.ScreeningRoom;
import pl.edu.pjatk.cinemanetworkapi.model.entity.Seat;

import java.util.List;

public interface SeatRepository extends JpaRepository<Seat, Long> {
    @Query("select s from Seat s where s.screeningRoom.id = ?1")
    List<Seat> findAllByScreeningRoomId(Long id);
}