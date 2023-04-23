package com.example.sssss.service;

import com.example.sssss.common.CmEncryp;
import com.example.sssss.entity.Study_member;
import com.example.sssss.entity.Study_record;
import com.example.sssss.repository.StudyMemberRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@Transactional
public class StudyMemberService {
    @Autowired
    private StudyMemberRepository studyMemberRepository;

    @Value("${encrypt.key16}")
    private String strkey16;

    // 리스트 조회
    public List<Study_member> doSelectAll() throws Exception {
        CmEncryp cmEncryp = new CmEncryp();
//        String strkey16 = "ABCdefg123456plm";

        List<Study_member> list = studyMemberRepository.findAll();

        /* 복호화 */
        for(Study_member studyMember : list) {
            studyMember.setEmail(cmEncryp.decryptAes(studyMember.getEmail(), strkey16));
        }

        return list;
    }

    // 단일 조회
    public Study_member doSelectOne(Long memberId) {

        return studyMemberRepository.findById(memberId).get();
    }

    // insert 할때
    public void doInsert(Study_member studyMember) throws Exception {
        CmEncryp cmEncryp = new CmEncryp();
//        String strkey16 = "ABCdefg123456plm";

        studyMember.setPassword(cmEncryp.encryptSha256(studyMember.getPassword()));
        studyMember.setEmail(cmEncryp.encryptAes(studyMember.getEmail(), strkey16));

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

    /**
    *
    * StudyMemberService의 설명을 여기에 작성한다
     * 아이디로 조회
    * @author SONG_DA_WOON
    * @version 1.0.0
    * 작성일 2023/04/23
    **/

    public Study_member doSelectLoginI(String loginId) {

        return studyMemberRepository.findByLoginId(loginId);
    }
}
