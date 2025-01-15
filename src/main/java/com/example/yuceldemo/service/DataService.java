package com.example.yuceldemo.service;

import com.example.yuceldemo.dto.DataDTO;
import com.example.yuceldemo.helper.DataMapper;
import com.example.yuceldemo.model.DataEntity;
import com.example.yuceldemo.repository.DataRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.Collection;
import java.util.Optional;

@Service
public class DataService {
    final DataRepository dataRepository;

    @Autowired
    public DataService(DataRepository dataRepository) {
        this.dataRepository = dataRepository;
    }

    @Transactional(readOnly = true)
    public Collection<DataDTO> getAllData() {
        final var dataEntities = dataRepository.findAll();
        return dataEntities.stream()
                .map(DataMapper::mapDataEntityToDto)
                .toList();
    }

    @Transactional(readOnly = true)
    public Optional<DataDTO> getDataByCode(String code) {
        final Optional<DataEntity> found = dataRepository.getDataByCode(code);
        return found.map(DataMapper::mapDataEntityToDto);
    }

    @Transactional
    public void deleteAllData() {
        dataRepository.deleteAllInBatch();
    }
}
