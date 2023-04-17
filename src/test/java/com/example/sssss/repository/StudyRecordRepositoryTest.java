package com.example.sssss.repository;

import com.example.sssss.entity.Study_record;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
class StudyRecordRepositoryTest {

    @Autowired
    private StudyRecordRepository studyRecordRepository;

    @Test
    public void testSelectAll() {
        List<Study_record> studyRecords = studyRecordRepository.findAll();

        for(Study_record record : studyRecords) {
            System.out.println(record.getContents());
        }
    }
}