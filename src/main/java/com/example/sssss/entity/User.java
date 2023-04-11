package com.example.sssss.entity;

import lombok.Builder;
import lombok.Data;
import lombok.Generated;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;

public class User {
    private Long userId;
    private String userName;
    private String userEmail;
}
