DROP sequence article_seq;

CREATE SEQUENCE seq
START WITH 2000
INCREMENT BY 1
NOCACHE
NOCYCLE;

--*****************************
-- [1]MAJOR table
-- 2017.08.02
-- 회원관리 테이블
-- member_id,name,password,ssn,regdate
--*****************************
CREATE TABLE MAJOR(
	MAJOR_id VARCHAR2(10), 
	TITLE VARCHAR2(10),
	PRIMARY KEY(MAJOR_id)
);
alter table major add member_id varchar2(10);
select * from major;

--*****************************
-- [2]SUBJECT table
-- 2017.08.02
-- 회원관리 테이블
-- member_id,name,password,ssn,regdate
--*****************************
CREATE TABLE SUBJECT(
	subj_id VARCHAR2(10), 
	TITLE VARCHAR2(10),
	major_id VARCHAR2(10),
	PRIMARY KEY(subj_id),
	FOREIGN KEY(major_id) REFERENCES Major(major_id) 
		ON DELETE CASCADE
);

--*****************************
-- [3]member tab
-- 2017.08.02
-- 회원관리 테이블
-- member_id,name,password,ssn,regdate
-- major_id,phone,email,profile
--*****************************
CREATE TABLE Member(
	id VARCHAR2(10), 
	name VARCHAR2(20),
	pw VARCHAR2(10), 
	ssn VARCHAR2(15),
	regdate DATE,
	major_id VARCHAR2(10),
	phone VARCHAR2(20),
	email VARCHAR2(20),
	profile VARCHAR2(20),
	PRIMARY KEY(id)
	FOREIGN KEY(major_id) REFERENCES Major(major_id) 
		ON DELETE CASCADE
);

--*****************************
-- [4]Prof tab
-- 2017.08.02
-- 회원관리 테이블
-- member_id,salary
--*****************************

CREATE TABLE Prof(
	member_id VARCHAR2(10),
    salary VARCHAR2(10),
    PRIMARY KEY(member_id),
	FOREIGN KEY(member_id) REFERENCES Member(member_id) 
		ON DELETE CASCADE
);

--*****************************
-- [5]Student tab
-- 2017.08.02
-- 회원관리 테이블
-- member_id,sut_no
--*****************************
CREATE TABLE Student(
	member_id VARCHAR2(10),
    sut_no varchar2(8),
    PRIMARY KEY(member_id),
	FOREIGN KEY(member_id) REFERENCES Member(member_id) 
		ON DELETE CASCADE
);

--*****************************
-- [6]Grade tab
-- 2017.08.02
-- 회원관리 테이블
-- member_id,score, exam_date, subj_id, member_id
--*****************************
CREATE TABLE Grade(
    grade_seq NUMBER,
    score VARCHAR2(3),
    exam_date VARCHAR2(12),
    subj_id VARCHAR2(10),
	member_id VARCHAR2(10),  
    PRIMARY KEY(grade_seq),
	FOREIGN KEY(member_id) REFERENCES Member(member_id) 
		ON DELETE CASCADE,
	FOREIGN KEY(subj_id) REFERENCES Subject(subj_id) 
		ON DELETE CASCADE
);
INSERT INTO grade(grade_seq,score,exam_date,subj_id,member_id)
VALUES(seq.nextval,'90','2017-03','java','kim');
INSERT INTO grade(grade_seq,score,exam_date,subj_id,member_id)
VALUES(seq.nextval,'80','2017-04','java','park');
INSERT INTO grade(grade_seq,score,exam_date,subj_id,member_id)
VALUES(seq.nextval,'70','2017-05','java','yang');

commit;
DROP TABLE Grade;
SELECT * FROM tab;

-- member_id를 입력하면 평균점수를 반환하는 서브쿼리문
SELECT avg(score) 
FROM (select distinct m.member_id id,m.name name ,mj.title major ,g.score score,sj.title subject,g.EXAM_DATE
from member m,student s,grade g, subject sj,major mj 
where m.member_id = s.member_id and m.member_id = g.member_id
    and sj.major_id =mj.MAJOR_ID and sj.subj_id=g.subj_id)t
where t.id='kim';


--*****************************
-- [7]Board tab
-- 2017.08.02
-- 회원관리 테이블
-- member_id,score, exam_date, subj_id, member_id
--*****************************

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


ALTER TABLE Member RENAME COLUMN id TO member_id; 
ALTER TABLE Grade RENAME COLUMN id TO member_id;

SELECT * FROM Member;
SELECT * FROM Board;
SELECT * FROM Student;
SELECT * FROM Prof;
SELECT * FROM tab;
-- SUB QUERY
SELECT distinct m.member_id,m.name,mj.title as major,g.score,sj.title as subject, g.exam_date
	FROM member m,student s, grade g, subject sj,major mj 
	WHERE m.member_id = s.member_id and m.member_id = g.member_id
	    and sj.major_id =mj.major_id and sj.subj_id=g.subj_id
	ORDER BY g.exam_date;
