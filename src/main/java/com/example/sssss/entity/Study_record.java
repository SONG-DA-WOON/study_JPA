package com.example.sssss.entity;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.hibernate.annotations.GenerationTime;
import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.annotation.LastModifiedBy;
import org.springframework.data.annotation.LastModifiedDate;

import javax.persistence.*;
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

    @org.hibernate.annotations.Generated(GenerationTime.ALWAYS)
    @Column(name = "reg_day", updatable = false)
    private LocalDateTime reg_day;

    @org.hibernate.annotations.Generated(GenerationTime.ALWAYS)
    @Column(name = "mod_day")
    private LocalDateTime mod_day;
}
