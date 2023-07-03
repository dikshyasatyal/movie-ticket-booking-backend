package com.dikshya.ticketbooking.controller;

import com.dikshya.ticketbooking.entity.Movie;
import com.dikshya.ticketbooking.service.MovieService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/movie")
public class MovieController {

    private MovieService movieService;

    @Autowired
    public MovieController(MovieService movieService) {
        this.movieService = movieService;
    }

    @PostMapping()
    public Movie addMovie(@RequestBody Movie movie) {
        return movieService.addMovie(movie);
    }
    public MovieService getEmployeeService() {

        return movieService;
    }

    @GetMapping("{id}")
    public ResponseEntity<Movie> getMovieById(@PathVariable("id") Long movieId) {
        return new ResponseEntity<Movie>(movieService.getMovieByID(movieId), HttpStatus.OK);
    }
    @PutMapping("{id}")
    public ResponseEntity<Movie> updateMovie(@PathVariable("id")Long id ,
                                                   @RequestBody Movie movie) {

        return new ResponseEntity<Movie>(movieService.UpdateMovie(movie, id), HttpStatus.OK);
    }


    }
