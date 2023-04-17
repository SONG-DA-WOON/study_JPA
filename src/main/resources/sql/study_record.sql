CREATE TABLE study_record(
                             key_id INT AUTO_INCREMENT,
                             STUDY_DAY VARCHAR(20),
                             CONTENTS VARCHAR(100),
                             reg_day DATETIME  DEFAULT CURRENT_TIMESTAMP,
                             PRIMARY KEY (key_id)
);

INSERT INTO study_record (study_day, contents)
VALUES('2022.08.11','공부하자');

INSERT INTO study_record (study_day, contents)
VALUES('2022.08.11','공부하자2');