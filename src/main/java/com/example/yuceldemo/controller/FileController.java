package com.example.yuceldemo.controller;

import com.example.yuceldemo.dto.UploadResponseDTO;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

@RestController
public class FileController {
    @PostMapping("/file")
    public UploadResponseDTO upload(@RequestParam("file") MultipartFile file) {
        return new UploadResponseDTO(
                "The file is uploaded successfully.",
                file.getOriginalFilename(),
                file.getSize()
        );
    }
}
