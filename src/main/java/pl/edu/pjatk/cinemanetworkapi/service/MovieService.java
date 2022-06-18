package pl.edu.pjatk.cinemanetworkapi.service;

import org.springframework.stereotype.Service;
import pl.edu.pjatk.cinemanetworkapi.model.entity.Movie;
import pl.edu.pjatk.cinemanetworkapi.model.repository.MovieRepository;

import java.util.List;

@Service
public class MovieService {
    private final MovieRepository movieRepository;

    public MovieService(MovieRepository movieRepository) {
        this.movieRepository = movieRepository;
    }

    public List<Movie> getAllMovies() {
        return movieRepository.findAll();
    }

    public Movie getMovie(int id) {
        return movieRepository.findById(id).orElse(null);
    }
}
