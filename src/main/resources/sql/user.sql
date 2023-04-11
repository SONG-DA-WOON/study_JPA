DROP TABLE user;

CREATE TABLE user(
    user_id int auto_increment primary key comment '회원 테이블 아이디',
    user_name varchar(255) null comment '회원 이름',
    user_email varchar(255) null comment '회원 이메일'
);


