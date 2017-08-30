package com.gms.web.dao;

import java.util.List;import java.util.Map;

import com.gms.web.command.Command;
import com.gms.web.domain.MemberBean;

public interface MemberDAO {
	public String insert(Map<?,?> map);
	public List<?> selectAll(Command cmd);
	public String countMembers(Command cmd);
	public MemberBean selectById(Command cmd);
	public List<?> selectByNames(Command cmd);
	public String update(MemberBean member);
	public String delete(Command cmd);
	//MemberBean[] list=new MemberBean[4];
}
