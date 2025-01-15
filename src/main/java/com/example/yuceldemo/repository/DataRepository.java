package com.example.yuceldemo.repository;

import com.example.yuceldemo.model.Data;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface DataRepository extends JpaRepository<Data,Long> {
    Data getDataByCode(String code);
}
