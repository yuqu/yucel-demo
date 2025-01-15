package com.example.yuceldemo.helper;

import com.example.yuceldemo.dto.DataDTO;
import com.example.yuceldemo.model.DataEntity;

public class DataMapper {
    public static DataDTO mapDataEntityToDto(DataEntity dataEntity) {
        return new DataDTO(
                dataEntity.getSource(),
                dataEntity.getCodeListCode(),
                dataEntity.getCode(),
                dataEntity.getDisplayValue(),
                dataEntity.getLongDescription(),
                dataEntity.getFromDate(),
                dataEntity.getToDate(),
                dataEntity.getSortingPriority()
        );
    }

    public static DataEntity mapDataDtoToEntity(DataDTO dataDTO) {
        var dataEntity = new DataEntity();
        dataEntity.setSource(dataDTO.source());
        dataEntity.setCodeListCode(dataDTO.codeListCode());
        dataEntity.setCode(dataDTO.code());
        dataEntity.setDisplayValue(dataDTO.displayValue());
        dataEntity.setLongDescription(dataDTO.longDescription());
        dataEntity.setFromDate(dataDTO.fromDate());
        dataEntity.setToDate(dataDTO.toDate());
        dataEntity.setSortingPriority(dataDTO.sortingPriority());
        return dataEntity;
    }
}
