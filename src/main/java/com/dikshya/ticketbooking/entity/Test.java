package com.dikshya.ticketbooking.entity;

import jakarta.persistence.*;

@Entity

@Table
public class Test {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @Column(name="full_name",nullable = false)
    private String name;

}
