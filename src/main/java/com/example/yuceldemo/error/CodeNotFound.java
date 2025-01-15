package com.example.yuceldemo.error;

import org.springframework.http.HttpStatus;
import org.springframework.web.server.ResponseStatusException;

public class CodeNotFound extends ResponseStatusException {
    public CodeNotFound() {
        super(HttpStatus.NOT_FOUND, "Provided code could not be found.");
    }
}
