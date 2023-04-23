package com.example.sssss.repository;

import com.example.sssss.entity.Study_member;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface StudyMemberRepository extends JpaRepository<Study_member, Long> {

    Study_member findByLoginId(String loginId);
}
