package com.dikshya.ticketbooking.service;

import com.dikshya.ticketbooking.dto.request.ShowTimeRequestDto;
import com.dikshya.ticketbooking.entity.Movie;
import com.dikshya.ticketbooking.entity.ShowTime;
import com.dikshya.ticketbooking.exception.ResourceNotFoundException;
import com.dikshya.ticketbooking.repository.MovieRepository;
import com.dikshya.ticketbooking.repository.ShowTimeRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class ShowTimeService {
    private ShowTimeRepository showTimeRepository;
    private MovieRepository movieRepository;

    @Autowired
    public ShowTimeService(ShowTimeRepository showTimeRepository, MovieRepository movieRepository) {
        this.showTimeRepository = showTimeRepository;
        this.movieRepository = movieRepository;
    }

   public ShowTime addShowTime(ShowTimeRequestDto showTimeRequestDto) {
        Optional<Movie> isMoviePresent = movieRepository.findById(showTimeRequestDto.getMovieId());
        if (isMoviePresent.isPresent()) {
            ShowTime showTime = new ShowTime();
            // isMoviePresent.get() le movie repository ma front bata pathako movie id vettayo
            // vane tyo particular movie ko jun data ra id linca aauxa

            showTime.setMovie(isMoviePresent.get());
            showTime.setShowTime(showTimeRequestDto.getShowTime());
            showTime.setLastShowDate(showTimeRequestDto.getLastShowDate());
            showTimeRepository.save(showTime);
            return showTime;

        }
      throw new RuntimeException("Movie with id "+ isMoviePresent.get()+" not found");


    }


}
