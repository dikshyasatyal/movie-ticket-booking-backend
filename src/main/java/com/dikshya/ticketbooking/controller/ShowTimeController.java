package com.dikshya.ticketbooking.controller;

import com.dikshya.ticketbooking.dto.request.ShowTimeRequestDto;
import com.dikshya.ticketbooking.dto.response.MovieShowResponse;
import com.dikshya.ticketbooking.entity.ShowTime;
import com.dikshya.ticketbooking.service.ShowTimeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/show-time")
public class ShowTimeController {
    private ShowTimeService showTimeService;

    @Autowired
    public ShowTimeController(ShowTimeService showTimeService) {
        this.showTimeService = showTimeService;
    }
    @PostMapping()
    public ResponseEntity<MovieShowResponse> addShowTimeForMovie(@RequestBody ShowTimeRequestDto showTimeDTO) {
        ShowTime showTime = showTimeService. addShowTime(showTimeDTO);
        MovieShowResponse movieShow = MovieShowResponse.builder()
                .id(showTime.getId())
                .movieName(showTime.getMovie().getMovieName())
                .movieDescription(showTime.getMovie().getDescription())
                .showTime(showTime.getShowTime())
                .lastShowDate(showTime.getLastShowDate())
                .build();



        return ResponseEntity.ok(movieShow);
    }
}
