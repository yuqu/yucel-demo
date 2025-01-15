package com.example.yuceldemo.dto;

import com.example.yuceldemo.helper.LocalDateConverter;
import com.opencsv.bean.CsvCustomBindByName;

import java.time.LocalDate;

public record DataDTO(
        String source,
        String codeListCode,
        String code,
        String displayValue,
        String longDescription,
        LocalDate fromDate,
        LocalDate toDate,
        Integer	sortingPriority
) {

}
