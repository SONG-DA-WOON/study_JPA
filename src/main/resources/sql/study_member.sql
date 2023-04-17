CREATE TABLE study_member(
                             MEMBER_ID INT AUTO_INCREMENT,
                             LOGIN_ID VARCHAR(20),
                             PASSWORD VARCHAR(100),
                             NAME VARCHAR(100),
                             ROLE VARCHAR(100),
                             reg_day DATETIME DEFAULT CURRENT_TIMESTAMP,
                             PRIMARY KEY (MEMBER_ID)
)