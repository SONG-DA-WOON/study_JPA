package com.example.sssss.repository;

import com.example.sssss.entity.Study_record;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface StudyRecordRepository extends JpaRepository<Study_record, Long> {
}
