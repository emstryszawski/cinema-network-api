package pl.edu.pjatk.cinemanetworkapi.model.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import pl.edu.pjatk.cinemanetworkapi.model.entity.Buy;

public interface BuyRepository extends JpaRepository<Buy, Long> {
}