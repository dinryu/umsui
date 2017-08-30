package com.gms.web.service;

import java.util.*;

import com.gms.web.command.Command;
import com.gms.web.domain.MemberBean;

public interface MemberService {
	public String add(Map<String,Object> map);
	public List<?> list(Command cmd);
	public List<?> findByNames(Command cmd);
	public MemberBean findById(Command cmd);
	public String countMembers(Command cmd);
	public String modify(MemberBean member);
	public String remove(Command cmd);
    public Map<String, Object> login(MemberBean bean);	
    //MemberBean[] list=new MemberBean[4];
}