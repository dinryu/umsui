--id, pw, name, ssn, regdate; 
CREATE SEQUENCE article_seq
START WITH 1000
INCREMENT BY 1
NOCACHE
NOCYCLE;

CREATE TABLE Member(
	id VARCHAR2(10), 
	name VARCHAR2(20),
	pw VARCHAR2(10), 
	ssn VARCHAR2(15),
	regdate DATE,
	PRIMARY KEY(id)
);
SELECT * FROM Member;
DROP TABLE Member;

-- id, title, content;
-- article_seq, hitcount;
-- regdate;
CREATE TABLE Board(
	article_seq NUMBER,
	id VARCHAR2(10),
	title VARCHAR2(20),
	content VARCHAR2(100),
	hitcount NUMBER,
	regdate	DATE,
	PRIMARY KEY(article_seq),
	FOREIGN KEY(id) REFERENCES Member(id) 
		ON DELETE CASCADE
);

SELECT * FROM Board;
SELECT * FROM tab;

-- phone, email, major, subject, PRIFILE

ALTER TABLE Member ADD phone VARCHAR2(13);
ALTER TABLE Member ADD email VARCHAR2(20);

CREATE TABLE Major(
    major_id VARCHAR2(10),
    title VARCHAR2(10),
    PRIMARY KEY(major_id)
);

CREATE TABLE Subject(
    subj_id VARCHAR2(10),
    title VARCHAR2(10),
    PRIMARY KEY(subj_id)    
);

CREATE TABLE Grade(
    grade_seq NUMBER,
    score VARCHAR2(10),
    exam_date VARCHAR2(10),
    PRIMARY KEY(grade_seq)
);

CREATE SEQUENCE grade_seq
START WITH 1000
INCREMENT BY 1
NOCACHE
NOCYCLE;

ALTER TABLE Member ADD major_id VARCHAR2(10);
ALTER TABLE Member
ADD CONSTRAINT member_fk_major
FOREIGN KEY (major_id)
REFERENCES Major (major_id)
ON DELETE CASCADE;
commit;

ALTER TABLE Subject ADD major_id VARCHAR2(10);
ALTER TABLE Subject
ADD CONSTRAINT subject_fk_major
FOREIGN KEY (major_id)
REFERENCES Major (major_id)
ON DELETE CASCADE;

ALTER TABLE Grade ADD subj_id VARCHAR2(10);
ALTER TABLE Grade
ADD CONSTRAINT grade_fk_subject
FOREIGN KEY (subj_id)
REFERENCES Subject (subj_id)
ON DELETE CASCADE;

ALTER TABLE Member ADD profile VARCHAR2(30);
ALTER TABLE Grade
ADD CONSTRAINT grade_fk_member
FOREIGN KEY (id)
REFERENCES Mamber (id)
ON DELETE CASCADE;

ALTER TABLE Subject
DROP CONSTRAINT subject_fk_major;

ALTER TABLE Grade
DROP CONSTRAINT grade_fk_subject;

ALTER TABLE Member
DROP CONSTRAINT member_fk_major;

SELECT * FROM Major;
SELECT * FROM Mamber;
SELECT * FROM Grade;
SELECT * FROM Subject;