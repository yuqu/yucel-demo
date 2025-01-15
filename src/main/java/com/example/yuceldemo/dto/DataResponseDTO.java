package com.example.yuceldemo.dto;

import java.time.LocalDateTime;

public record DataResponseDTO(
        String source,
        String codeListCode,
        String code,
        String displayValue,
        String longDescription,
        LocalDateTime fromDate,
        LocalDateTime toDate,
        Integer	sortingPriority
) {

}
