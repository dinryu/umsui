package com.gms.web.dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import com.gms.web.command.Command;
import com.gms.web.constant.DB;
import com.gms.web.constant.SQL;
import com.gms.web.constant.Vendor;
import com.gms.web.domain.MajorBean;
import com.gms.web.domain.MemberBean;
import com.gms.web.domain.StudentBean;
import com.gms.web.factory.DatabaseFactory;


public class MemberDAOImpl implements MemberDAO {
	Connection conn;
	public static MemberDAOImpl getInstance() {
		return new MemberDAOImpl();
	}
	private MemberDAOImpl() {
		conn=null;
	}
	
	@Override
	public String insert(Map<?,?> map) {
		String rs = "";
		MemberBean member = (MemberBean)map.get("member");
		@SuppressWarnings("unchecked")
		List<MajorBean> list=(List<MajorBean>)map.get("major");
		PreparedStatement pstmt=null;		
		try {
			conn=DatabaseFactory
					.createDatabase(Vendor.ORACLE, DB.USERNAME, DB.PASSWORD)
					.getConnection();
			conn.setAutoCommit(false);
			pstmt=conn.prepareStatement(SQL.MEMBER_INSERT);
			
			pstmt.setString(1, member.getId());
			pstmt.setString(2, member.getName());
			pstmt.setString(3, member.getPw());
			pstmt.setString(4, member.getBirthday());
			pstmt.setString(5, member.getPhone());
			pstmt.setString(6, member.getEmail());
			pstmt.setString(7, member.getProfile());			
			pstmt.executeUpdate();
			
			for(int i=0;i<list.size();i++){
				pstmt=conn.prepareStatement(SQL.MAJOR_INSERT);
				pstmt.setString(1, list.get(i).getMajorId());
				pstmt.setString(2, list.get(i).getTitle());
				pstmt.setString(3, list.get(i).getSubjId());
				pstmt.setString(4, list.get(i).getId());
				System.out.println("*MemberDAOImpl SQL.MAJOR_INSERT : "+SQL.MAJOR_INSERT);
				System.out.println("*MemberDAOImpl pstmt : "+pstmt);
				rs=String.valueOf(pstmt.executeUpdate());
				
			}			
			conn.commit();
		} catch (Exception e) {
			e.printStackTrace();
			if(conn !=null){
				try {
					conn.rollback();
				} catch (SQLException ex) {
					e.printStackTrace();
				}
			}
		}	
		return rs;
	}

	@Override
	public List<?> selectAll(Command cmd) {
		System.out.println("DAOImpl selectAll 진입");
		List<StudentBean> list = new ArrayList<>();
		try {
			conn=DatabaseFactory.createDatabase(Vendor.ORACLE, DB.USERNAME, DB.PASSWORD).getConnection();
			PreparedStatement pstmt =conn.prepareStatement(SQL.STUDENT_LIST);
			pstmt.setString(1, cmd.getStartRow());
			pstmt.setString(2, cmd.getEndRow());
			ResultSet rs =pstmt.executeQuery();
			StudentBean stud = null;
			while(rs.next()) {
				stud = new StudentBean();
				stud.setNum(rs.getString(DB.NUM));
				stud.setId(rs.getString(DB.ID));
				stud.setName(rs.getString(DB.MEMBER_NAME));
				stud.setSsn(rs.getString(DB.MEMBER_SSN));
				stud.setRegdate(rs.getString(DB.MEMBER_REGDATE));
				stud.setPhone(rs.getString(DB.PHONE));
				stud.setEmail(rs.getString(DB.EMAIL));
				stud.setTitle(rs.getString(DB.TITLE));
				list.add(stud);
			}
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		System.out.println("DAOImpl selectAll out");
		return list;
	}

	@Override
	public String countMembers(Command cmd) {
		int res =0;
		try {
			conn=DatabaseFactory.createDatabase(Vendor.ORACLE, DB.USERNAME, DB.PASSWORD).getConnection();
			PreparedStatement pstmt =conn.prepareStatement(SQL.STUDENT_COUNT1);
			if(cmd.getSearch() == null){
				pstmt.setString(1, "%");
			}else{
				pstmt.setString(1, "%"+cmd.getSearch()+"%");
			}			
			ResultSet rs =pstmt.executeQuery();
			
			if(rs.next()) {
				res=Integer.parseInt(rs.getString("count"));
			}
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return String.valueOf(res);
	}

	@Override
	public MemberBean selectById(Command cmd) {
		System.out.println("MemberBean selectById : "+cmd.getSearch());
		MemberBean member =null;
		try {
			PreparedStatement pstmt= DatabaseFactory.createDatabase(Vendor.ORACLE, DB.USERNAME, DB.PASSWORD).getConnection().prepareStatement(SQL.MEMBER_FINDBYID);
			pstmt.setString(1, cmd.getSearch());
			ResultSet rs = pstmt.executeQuery();
			
			if(rs.next()) {
				member= new MemberBean();
				member.setId(rs.getString(DB.MEMBER_ID));
				member.setName(rs.getString(DB.MEMBER_NAME));
				member.setPw(rs.getString(DB.MEMBER_PASS));
				member.setRegdate(rs.getString(DB.MEMBER_REGDATE));
				member.setSsn(rs.getString(DB.MEMBER_SSN));
				System.out.println(rs.getString(DB.MEMBER_ID));
			}
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return member;
	}

	@Override
	public List<StudentBean> selectByNames(Command cmd) {
		System.out.println("DAOImpl selectByNames 진입");
		List<StudentBean> list = new ArrayList<>();
		try {
			PreparedStatement pstmt= DatabaseFactory.createDatabase(Vendor.ORACLE, DB.USERNAME, DB.PASSWORD).getConnection().prepareStatement(SQL.STUDENT_FINDBYNAME);		
			pstmt.setString(1, "%"+cmd.getSearch()+"%");
			ResultSet rs = pstmt.executeQuery();
			StudentBean stud = null;
			while(rs.next()) {
				stud = new StudentBean();
				stud.setNum(rs.getString(DB.NUM));
				stud.setId(rs.getString(DB.ID));
				stud.setName(rs.getString(DB.MEMBER_NAME));
				stud.setSsn(rs.getString(DB.MEMBER_SSN));
				stud.setRegdate(rs.getString(DB.MEMBER_REGDATE));
				stud.setPhone(rs.getString(DB.PHONE));
				stud.setEmail(rs.getString(DB.EMAIL));
				stud.setTitle(rs.getString(DB.TITLE));
				list.add(stud);
			}
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		System.out.println("DAOImpl selectByNames list :"+list);
		return list;
	}

	@Override
	public String update(MemberBean member) {
		String rs="";
		try {
			PreparedStatement pstmt= DatabaseFactory.createDatabase(Vendor.ORACLE, DB.USERNAME, DB.PASSWORD).getConnection().prepareStatement(SQL.MEMBER_UPDATE);
			pstmt.setString(1, member.getPw());
			pstmt.setString(2, member.getId());
			rs=String.valueOf(pstmt.executeUpdate());
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return rs;
	}

	@Override
	public String delete(Command cmd) {
		String rs="";
		try {
			PreparedStatement pstmt= DatabaseFactory.createDatabase(Vendor.ORACLE, DB.USERNAME, DB.PASSWORD).getConnection().prepareStatement(SQL.MEMBER_DELETE);
			pstmt.setString(1, cmd.getSearch());
			rs=String.valueOf(pstmt.executeUpdate());
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return rs;
	}

}