package com.example.sssss.service;

import com.example.sssss.entity.Study_record;
import com.example.sssss.repository.StudyRecordRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@Transactional
public class StudyRecordService {

    @Autowired
    private StudyRecordRepository studyRecordRepository;
    /* 전체 Row Select */
    public List<Study_record> doSelectAll() {

        return studyRecordRepository.findAll();
    }

    /* One Row Select */
    public Study_record doSelectOne(Long key_id) {

        return studyRecordRepository.findById(key_id).get();
    }

    /* Insert */
    public void doInsert(Study_record studyRecord) {
        studyRecordRepository.save(studyRecord);
    }

    /* Update */
    public void doUpdate(Study_record studyRecord) {
        studyRecordRepository.save(studyRecord);
    }

    /* Delete */
    public void doDelete(Long key_id) {
        studyRecordRepository.deleteById(key_id);
    }
}
