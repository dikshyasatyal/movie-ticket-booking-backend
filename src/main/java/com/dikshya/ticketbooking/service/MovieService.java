package com.dikshya.ticketbooking.service;

import com.dikshya.ticketbooking.entity.Movie;
import com.dikshya.ticketbooking.repository.MovieRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class MovieService {

    private MovieRepository movieRepository;

    @Autowired
    public MovieService(MovieRepository movieRepository) {
        this.movieRepository = movieRepository;

    }


    public Movie addMovie(Movie movie){
        return movieRepository.save(movie);


    }

}
