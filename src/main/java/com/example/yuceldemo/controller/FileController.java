package com.example.yuceldemo.controller;

import com.example.yuceldemo.dto.UploadResponseDTO;
import com.example.yuceldemo.error.FileProcessingError;
import com.example.yuceldemo.service.FileService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

@RestController
public class FileController {
    final FileService fileService;

    @Autowired
    public FileController(FileService fileService) {
        this.fileService = fileService;
    }

    @PostMapping("/file")
    public UploadResponseDTO upload(@RequestParam("file") MultipartFile file) {
        if (file.isEmpty()) {
            throw new FileProcessingError("File is empty");
        }

        try {
            fileService.processCsvFile(file.getInputStream());
        } catch(Exception e) {
            throw new FileProcessingError(e);
        }

        return new UploadResponseDTO(
                "The file is uploaded successfully.",
                file.getOriginalFilename(),
                file.getSize()
        );
    }
}
