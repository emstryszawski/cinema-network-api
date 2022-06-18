package pl.edu.pjatk.cinemanetworkapi.model.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import pl.edu.pjatk.cinemanetworkapi.model.entity.Movie;

public interface MovieRepository extends JpaRepository<Movie, Integer> {

}