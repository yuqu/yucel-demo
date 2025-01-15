package com.example.yuceldemo;

import org.junit.jupiter.api.MethodOrderer;
import org.junit.jupiter.api.Order;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestMethodOrder;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.core.io.ClassPathResource;
import org.springframework.core.io.Resource;
import org.springframework.http.MediaType;
import org.springframework.mock.web.MockMultipartFile;
import org.springframework.test.web.servlet.MockMvc;

import static org.hamcrest.Matchers.hasSize;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.*;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;

@SpringBootTest
@AutoConfigureMockMvc
@TestMethodOrder(MethodOrderer.OrderAnnotation.class)
class YucelDemoApplicationTests {

    @Autowired
    private MockMvc mockMvc;

    @Test
    @Order(1)
    void whenNoDataIsUploaded_getAllData_shouldReturnEmptyArray() throws Exception {
        mockMvc.perform(get("/"))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$", hasSize(0)));
    }

    @Test
    @Order(2)
    void whenNoDataIsUploaded_getDataByCode_shouldReturnNotFound() throws Exception {
        mockMvc.perform(get("/code"))
                .andExpect(status().isNotFound());
    }

    @Test
    @Order(3)
    void whenNoDataIsUploaded_deleteAllData_shouldReturnOk() throws Exception {
        mockMvc.perform(delete("/"))
                .andExpect(status().isOk());
    }

    @Test
    @Order(4)
    void whenCorruptedCSVuploaded_uploadData_shouldReturnBadRequest() throws Exception {
        Resource fileResource = new ClassPathResource("yucel-demo-corrupted.csv");
        MockMultipartFile file = new MockMultipartFile("file",
                "yucel-demo-corrupted.csv",
                MediaType.TEXT_PLAIN_VALUE,
                fileResource.getInputStream()
        );

        mockMvc.perform(multipart("/file").file(file))
                .andExpect(status().isBadRequest());
    }

    @Test
    @Order(5)
    void whenValidCSVUploaded_uploadData_shouldReturnBadRequest() throws Exception {
        Resource fileResource = new ClassPathResource("yucel-demo.csv");
        MockMultipartFile file = new MockMultipartFile("file",
                "yucel-demo.csv",
                MediaType.TEXT_PLAIN_VALUE,
                fileResource.getInputStream()
        );

        mockMvc.perform(multipart("/file").file(file))
                .andExpect(status().isOk());
    }

    @Test
    @Order(6)
    void whenValidCSVUploaded_getAllData_shouldReturnAllData() throws Exception {
        mockMvc.perform(get("/"))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$", hasSize(18)));
    }

    @Test
    @Order(7)
    void whenValidCSVUploaded_getCode_shouldReturnCorrespondingData() throws Exception {
        mockMvc.perform(get("/61086009"))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$.code").value("61086009"));
    }

    @Test
    @Order(8)
    void whenValidCSVUploaded_deleteAllData_shouldReturnOk() throws Exception {
        mockMvc.perform(delete("/"))
                .andExpect(status().isOk());
    }

    @Test
    @Order(9)
    void whenAllDataIsDeleted_getAllData_shouldReturnEmpty() throws Exception {
        mockMvc.perform(get("/"))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$", hasSize(0)));
    }
}
