package pl.edu.pjatk.cinemanetworkapi.model.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import pl.edu.pjatk.cinemanetworkapi.model.entity.ScreeningRoom;

public interface ScreeningRoomRepository extends JpaRepository<ScreeningRoom, Long> {
}