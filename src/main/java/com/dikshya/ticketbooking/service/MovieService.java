package com.dikshya.ticketbooking.service;

import com.dikshya.ticketbooking.entity.Movie;
import com.dikshya.ticketbooking.exception.ResourceNotFoundException;
import com.dikshya.ticketbooking.repository.MovieRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class MovieService {

    private MovieRepository movieRepository;


    public MovieService(MovieRepository movieRepository) {
        this.movieRepository = movieRepository;
    }


    public Movie addMovie(Movie movie) {
        return movieRepository.save(movie);
    }


    public List<Movie> getAllMovies() {
        return movieRepository.findAll();
    }

    public Movie getMovieByID(Long id) throws ResourceNotFoundException {

        Optional<Movie> optional = movieRepository.findById(id);
        Movie movie = null;
        if (optional.isPresent()) {
            movie = optional.get();
        } else {
            throw new RuntimeException(" movie not found for id :: " + id);
        }
        return movie;
    }


    public Movie UpdateMovie(Movie movie, Long id) {
        Movie existingMovie = movieRepository.findById(id).orElseThrow(
                () -> new ResourceNotFoundException("Movie", "id", "id"));

        existingMovie.setMovieName(movie.getMovieName());
        existingMovie.setDescription(movie.getDescription());
        existingMovie.setReleasedDate(movie.getReleasedDate());
        existingMovie.setIsShowing(movie.getIsShowing());
        movieRepository.save((existingMovie));

        return existingMovie;
    }

    public void deleteMovie(Long id){
        movieRepository.deleteById(id);
    }

}



