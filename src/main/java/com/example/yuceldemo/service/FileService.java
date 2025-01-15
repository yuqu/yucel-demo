package com.example.yuceldemo.service;

import com.example.yuceldemo.model.DataEntity;
import com.example.yuceldemo.repository.DataRepository;
import com.opencsv.bean.CsvToBean;
import com.opencsv.bean.CsvToBeanBuilder;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.Reader;

@Service
public class FileService {
    final Logger logger = LoggerFactory.getLogger(FileService.class);

    final DataRepository dataRepository;

    @Autowired
    public FileService(DataRepository dataRepository) {
        this.dataRepository = dataRepository;
    }

    @Transactional
    public void processCsvFile(InputStream fileStream) throws IOException {
        try (Reader reader = new InputStreamReader(fileStream)) {
            CsvToBean<DataEntity> csvToBean = new CsvToBeanBuilder<DataEntity>(reader)
                    .withType(DataEntity.class)
                    .withIgnoreLeadingWhiteSpace(true)
                    .withIgnoreEmptyLine(true)
                    .build();

            dataRepository.saveAll(csvToBean.parse());

        } catch (Exception e) {
            logger.error(e.getMessage(), e);
            throw e;
        }
    }
}
