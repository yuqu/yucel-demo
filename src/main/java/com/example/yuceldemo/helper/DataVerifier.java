package com.example.yuceldemo.helper;

import com.example.yuceldemo.model.DataEntity;
import com.opencsv.bean.BeanVerifier;
import com.opencsv.exceptions.CsvConstraintViolationException;
import jakarta.validation.*;

import java.util.Set;

public class DataVerifier implements BeanVerifier<DataEntity> {
    final ValidatorFactory factory = Validation.buildDefaultValidatorFactory();
    final Validator validator = factory.getValidator();

    @Override
    public boolean verifyBean(DataEntity dataEntity) throws CsvConstraintViolationException {
        Set<ConstraintViolation<DataEntity>> violations = validator.validate(dataEntity);
        if (!violations.isEmpty()) {
            for (ConstraintViolation<DataEntity> violation : violations) {
                throw new CsvConstraintViolationException(dataEntity, violation.getMessage());
            }
        }

        return true;
    }
}