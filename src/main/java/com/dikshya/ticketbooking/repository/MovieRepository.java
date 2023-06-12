package com.dikshya.ticketbooking.repository;

import com.dikshya.ticketbooking.entity.Movie;
import org.springframework.data.jpa.repository.JpaRepository;

public interface MovieRepository extends JpaRepository <Movie,Long> {

}
