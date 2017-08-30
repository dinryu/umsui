package com.gms.web.constant;

public class SQL {
	public static final String MEMBER_INSERT = String.format("INSERT INTO %s(%s,%s,%s,%s,%s,%s,%s,%s) VALUES(?,?,?,?,?,?,?,SYSDATE)",DB.TABLE_MEMBER,DB.MEMBER_ID,DB.MEMBER_NAME,DB.MEMBER_PASS,DB.MEMBER_SSN,DB.PHONE,DB.PROFILE,DB.EMAIL,DB.MEMBER_REGDATE);
	public static final String MEMBER_LIST = String.format("SELECT * FROM %s",DB.TABLE_MEMBER);
	public static final String MEMBER_FINDBYNAME = String.format("SELECT * FROM %s WHERE %s= ?",DB.TABLE_MEMBER,DB.MEMBER_NAME);
	public static final String MEMBER_FINDBYID = String.format("SELECT * FROM %s WHERE %s= ?",DB.TABLE_MEMBER,DB.MEMBER_ID);
	public static final String MEMBER_COUNT = String.format("SELECT COUNT(*) AS %s FROM %s","count",DB.TABLE_MEMBER);
	public static final String MEMBER_UPDATE = String.format("UPDATE %s SET %s= ? WHERE %s = ?",DB.TABLE_MEMBER,DB.MEMBER_PASS,DB.MEMBER_ID);
	public static final String MEMBER_DELETE = String.format("DELETE FROM %s WHERE %s =?",DB.TABLE_MEMBER,DB.MEMBER_ID);
	
	public static final String BOARD_INSERT = String.format("INSERT INTO %s(%s,%s,%s,%s,%s,%s) VALUES (article_seq.nextval,?,?,?,0,SYSDATE)",DB.TABLE_BOARD,DB.BOARD_SEQ,DB.MEMBER_ID,DB.TITLE,DB.BOARD_CONTENT,DB.BOARD_HITCNT,DB.REGDATE);
	public static final String BOARD_LIST = String.format("SELECT * FROM %s",DB.TABLE_BOARD);
	public static final String BOARD_FINDBYID = String.format("SELECT * FROM %s WHERE %s= ?",DB.TABLE_BOARD,DB.BOARD_ID);
	public static final String BOARD_FINDBYSEQ = String.format("SELECT * FROM %s WHERE %s= ?",DB.TABLE_BOARD,DB.BOARD_SEQ);
	public static final String BOARD_COUNT = String.format("SELECT COUNT(*) AS %s FROM %s","count",DB.TABLE_BOARD);
	public static final String BOARD_UPDATE = String.format("UPDATE %s SET %s= ?, %s=? WHERE %s = ?",DB.TABLE_BOARD,DB.TITLE,DB.BOARD_CONTENT,DB.BOARD_SEQ);
	public static final String BOARD_DELETE = String.format("DELETE FROM %s WHERE %s =?",DB.TABLE_BOARD,DB.BOARD_SEQ);
	
	public static final String MAJOR_INSERT = String.format("INSERT INTO %s(major_id,subj_id) VALUES(?,?,?,?)", DB.TABLE_MAJOR,DB.MAJOR_ID,DB.MEMBER_ID,DB.SUBJ_ID);
//	public static final String STUDENT_LIST=String.format("SELECT %s,%s,%s,%s,%s,%s,%s,%s FROM %s",DB.NUM,DB.ID,DB.MEMBER_NAME,DB.MEMBER_SSN,DB.REGDATE,DB.PHONE,DB.EMAIL,DB.TITLE,DB.TABLE_STUDENT);
	public static final String STUDENT_PAGE=String.format("SELECT T.* FROM (SELECT ROWNUM R, S.* FROM %s S)T WHERE T.R BETWEEN %s AND %s",DB.TABLE_STUDENT,DB.START,DB.END);
	public static final String STUDENT_LIST=" select t.* "
	                                       +" from (select rownum rnum, s.* " 
			                               +" from student s)t " 
	                                       +" where t.rnum between ? and ? ";
	public static final String STUDENT_COUNT = String.format("SELECT COUNT(*) AS %s FROM %s","count",DB.TABLE_STUDENT);
	public static final String STUDENT_COUNT1 = String.format("SELECT COUNT(*) AS %s FROM %s where name like ? ","count",DB.TABLE_STUDENT);
	public static final String STUDENT_FINDBYNAME = String.format("SELECT t2.* FROM(SELECT ROWNUM seq,t.* FROM(SELECT * FROM student WHERE %s like ?  ORDER BY num DESC)t) t2 WHERE t2.seq BETWEEN ? AND ? ",DB.TABLE_STUDENT, "name"); 
}
