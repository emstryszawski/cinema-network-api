package pl.edu.pjatk.cinemanetworkapi.model.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import pl.edu.pjatk.cinemanetworkapi.model.entity.Movie;

@Repository
public interface MovieRepository extends JpaRepository<Movie, Long> {

}