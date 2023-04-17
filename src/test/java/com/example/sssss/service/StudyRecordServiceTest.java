package com.example.sssss.service;

import com.example.sssss.entity.Study_record;
import com.example.sssss.repository.StudyRecordRepository;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.transaction.annotation.Transactional;

import java.time.LocalDateTime;

import static org.junit.jupiter.api.Assertions.*;
@SpringBootTest
class StudyRecordServiceTest {
    @Autowired
    private StudyRecordService studyRecordService;
    @Test
    void doInsert() {

        Study_record studyRecord = Study_record.builder()
                .study_day("2023.04.17")
                .contents("하이")
                .reg_day(LocalDateTime.now())
                .build();

        studyRecordService.doInsert(studyRecord);
    }

    @Test
    void doUpdate() {
        // 한 행을 다 업데이트 하는 방법
        /*
        Study_record study_record = new Study_record();

        study_record.setContents("테스트로 업데이트");
        study_record.setKey_id(3L);
        study_record.setReg_day(LocalDateTime.now());
        study_record.setStudy_day("2023.04.17");

        */

        // 수정할 값만 수정하는 방법
        Study_record study_record = studyRecordService.doSelectOne(3L);
        study_record.setContents("콘텐츠만 수정 !");

        studyRecordService.doUpdate(study_record);
    }

    @Test
    // 지워지면 안되는데이터고, 만약 테스트 한걸 보고 싶다면 트렌젝션 걸기
    // 롤백 처리 된다
    @Transactional
    void doDelete() {
        studyRecordService.doDelete(3L);
    }
}