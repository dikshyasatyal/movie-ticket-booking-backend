package com.dikshya.ticketbooking.dto.request;

import jakarta.persistence.criteria.CriteriaBuilder;
import lombok.Getter;
import lombok.Setter;

import java.time.LocalDate;
@Getter
@Setter
public class ShowTimeRequestDto {
    private Long id;
    private String showTime;
    private LocalDate lastShowDate;

    private  Long movieId;

}
