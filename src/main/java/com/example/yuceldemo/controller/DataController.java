package com.example.yuceldemo.controller;

import com.example.yuceldemo.dto.DataResponseDTO;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.bind.annotation.*;

import java.util.Collection;

@RestController
public class DataController {
    Logger logger = LoggerFactory.getLogger(DataController.class);
    @GetMapping("/")
    public Collection<DataResponseDTO> getAllData() {
        logger.info("getAllData");
        return null;
    }

    @GetMapping("/{code}")
    public DataResponseDTO getDataByCode(@PathVariable String code) {
        return null;
    }

    @DeleteMapping("/")
    public void deleteAllData() {
    }
}
