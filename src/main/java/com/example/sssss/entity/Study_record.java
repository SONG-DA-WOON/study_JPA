package com.example.sssss.entity;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import java.time.LocalDateTime;

// 예전에는 VO = Value Object
// Entity 는 밑에 어노테이션을 넣어줘야된다.
// 1대1 로 메핑한다 해서 ORM Object Relation Mapping

@Entity
@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class Study_record {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long key_id;
    private String study_day;
    private String contents;
    private LocalDateTime reg_day;
}
