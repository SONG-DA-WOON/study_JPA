package com.example.sssss.repository;

import com.example.sssss.entity.Study_member;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import static org.junit.jupiter.api.Assertions.*;
@SpringBootTest
class StudyMemberRepositoryTest {

    @Autowired
    StudyMemberRepository studyMemberRepository;

    @Test
    void findByLoginId() {

        Study_member studyMember = studyMemberRepository.findByLoginId("kjaekdnsdl");

        System.out.println(studyMember);
    }
}