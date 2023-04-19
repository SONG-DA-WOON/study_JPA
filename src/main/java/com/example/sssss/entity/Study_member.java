package com.example.sssss.entity;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.hibernate.annotations.GenerationTime;

import javax.persistence.*;
import java.time.LocalDateTime;

@Entity
@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
@Table(name = "study_member")
public class Study_member {

    /* IDENTITY - @GeneratedValue(strategy = GenerationType.IDENTITY)
                   기본키 생성은 데이터 베이스에게 위임하는 방식으로 id 값을 따로 할당하지 않아도 데이터베이스가 자동으로 AUTO INCREMENT를 하여 기본키를 생성해준다.

       SEQUENCE - @GeneratedValue(strategy = GenerationType.SEQUENCE)
                   데이터 베이스의 Sequence Object를 사용하여 데이터베이스가 자동으로 기본키를 생성해준다.

       TABLE - @GeneratedValue(strategy = GenerationType.TABLE)
       AUTO - @GeneratedValue(strategy  = GenerationType.AUTO)
                기본 설정 값으로 각 데이터베이스에 따라 기본키를 자동으로 생성한다.
     */

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "member_id")
    private Long memberId;
    private String loginId;
    private String password;
    private String name;
    private String email;
    private String role;
    @org.hibernate.annotations.Generated(GenerationTime.ALWAYS)
    @Column(name = "reg_day", updatable = false)
    private LocalDateTime regDay;
}
