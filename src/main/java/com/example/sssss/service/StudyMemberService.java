package com.example.sssss.service;

import com.example.sssss.entity.Study_member;
import com.example.sssss.entity.Study_record;
import com.example.sssss.repository.StudyMemberRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@Transactional
public class StudyMemberService {
    @Autowired
    private StudyMemberRepository studyMemberRepository;

    // 리스트 조회
    public List<Study_member> doSelectAll() {
        return studyMemberRepository.findAll();
    }

    // 단일 조회
    public Study_member doSelectOne(Long memberId) {

        return studyMemberRepository.findById(memberId).get();
    }

    // insert 할때
    public void doInsert(Study_member studyMember) {
        studyMemberRepository.save(studyMember);
    }

    // update 할때
    public void doUpdate(Study_member studyMember) {
        studyMemberRepository.save(studyMember);
    }

    // delete 할때
    public void doDelete(Long memberId) {
        studyMemberRepository.deleteById(memberId);
    }
}
