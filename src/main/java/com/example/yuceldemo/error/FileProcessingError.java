package com.example.yuceldemo.error;

import org.springframework.http.HttpStatus;
import org.springframework.web.server.ResponseStatusException;

public class FileProcessingError extends ResponseStatusException {
    public FileProcessingError(Exception originalError) {
        super(HttpStatus.BAD_REQUEST, originalError.getMessage());
    }
}
