package com.example.yuceldemo.model;

import jakarta.persistence.*;

import java.time.LocalDateTime;

@Entity
public class Data {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    String source;

    String codeListCode;

    @Column(unique = true)
    String code;

    String displayValue;

    @Column(length = 2048)
    String longDescription;

    LocalDateTime fromDate;

    LocalDateTime toDate;

    Integer sortingPriority;

}
