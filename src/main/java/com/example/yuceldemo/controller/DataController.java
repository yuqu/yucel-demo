package com.example.yuceldemo.controller;

import com.example.yuceldemo.dto.DataDTO;
import com.example.yuceldemo.error.CodeNotFound;
import com.example.yuceldemo.service.DataService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import java.util.Collection;

@RestController
public class DataController {
    final DataService dataService;

    @Autowired
    public DataController(DataService dataService) {
        this.dataService = dataService;
    }


    @GetMapping("/")
    public Collection<DataDTO> getAllData() {
        return dataService.getAllData();
    }

    @GetMapping("/{code}")
    public DataDTO getDataByCode(@PathVariable String code) {
        final var optionalData = dataService.getDataByCode(code);

        return optionalData.orElseThrow(CodeNotFound::new);
    }

    @DeleteMapping("/")
    public void deleteAllData() {
        dataService.deleteAllData();
    }
}
