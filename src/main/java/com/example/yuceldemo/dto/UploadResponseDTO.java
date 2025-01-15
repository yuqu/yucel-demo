package com.example.yuceldemo.dto;

public record UploadResponseDTO(
        String message,
        String fileName,
        long size
) {
}
