--*****************************
-- member table
-- 2017.08.02
-- 회원관리 테이블
-- member_id,name,password,ssn,regdate
-- major_id,phone,email,profile
--*****************************

INSERT INTO Member(id,name,password,ssn,regdate);
VALUES('hong','홍길동','1','800101-1032654',SYSDATE);

INSERT INTO Member(id,name,password,ssn,regdate);

UPDATE Member
SET ssn = '900117-2031222'
WHERE id = 'hanseul';

--*****************************
-- board table
-- 2017.08.02
-- article_seq,id,title,content,hitcount,regdate
--*****************************

INSERT INTO Board(article_seq,id,title,content,hitcount,regdate)
VALUES(article_seq.nextval,'hong','홍길동 안녕','앞이 위하여서, 살았으며,',0,SYSDATE);

INSERT INTO Board(article_seq, id, title, content, hitcount, regdate) VALUES (article_seq.nextval,?,?,?,0,SYSDATE)
DELETE FROM Board WHERE article_seq='1011' 

--************************
-- select 
--************************
SELECT * FROM Member;
SELECT * FROM Board;
SELECT * FROM Student;
SELECT * FROM Prof;
SELECT * FROM tab;

SELECT DISTINCT id FROM Board where title like '%길동%';
SELECT * FROM Board where title like '%길동%';
SELECT * FROM Board ORDER BY regdate desc; 
SELECT * FROM Member m, BOARD b WHERE m.id=b.id;
SELECT * FROM Member m, BOARD b, Grade g WHERE m.id=b.id and m.id=g.id;
SELECT ssn,NAME FROM Member m, Board b WHERE m.id=b.id AND ROWNUM <= 2;
SELECT * FROM Member WHERE name='박길동';
SELECT COUNT(*) AS Count FROM Member;

