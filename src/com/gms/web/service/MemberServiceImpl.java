package com.gms.web.service;

import java.util.*;

import com.gms.web.command.Command;
import com.gms.web.dao.MemberDAO;
import com.gms.web.dao.MemberDAOImpl;
import com.gms.web.domain.MajorBean;
import com.gms.web.domain.MemberBean;
import com.gms.web.service.MemberService;

public class MemberServiceImpl implements MemberService {
	public static MemberServiceImpl getInstance() {
		return new MemberServiceImpl();
		}
	public MemberServiceImpl() {}
	@Override
	public String add(Map<String,Object> map) {
		System.out.println("MemberServiceimpl 진입");
		MemberBean m=(MemberBean)map.get("member");
		System.out.println("넘어온 회원 이름:"+m.getName());
		@SuppressWarnings("unchecked")
		List<MajorBean> list = (List<MajorBean>)map.get("major");
		System.out.println("넘어온 수강 과목"+list);
		MemberDAOImpl.getInstance().insert(map);
		return MemberDAOImpl.getInstance().insert(map);
	}
	@Override
	public List<?> list(Command cmd) {
		return MemberDAOImpl.getInstance().selectAll(cmd);
	}
	@Override
	public String countMembers(Command cmd) {
		return String.valueOf(MemberDAOImpl.getInstance().countMembers(cmd));
	}
	@Override
	public List<?> findByNames(Command cmd) {
		System.out.println("findByNames : "+cmd.getSearch());
		return MemberDAOImpl.getInstance().selectByNames(cmd);
	}
	@Override
	public MemberBean findById(Command cmd) {
		return MemberDAOImpl.getInstance().selectById(cmd);
	}
	@Override
	public String modify(MemberBean param) {
		String msg="";
		return msg;	
	}
	@Override
	public String remove(Command cmd) {
		String msg="";
		return msg;		
	}
	@Override
	public  Map<String, Object> login(MemberBean bean) {
		Map<String, Object> map = new HashMap<>();
		String page="";
		Command cmd = new Command();
		cmd.setSearch(bean.getId());
		MemberBean m = findById(cmd);
		if(m !=null){
			page = (m.getPw().equals(bean.getPw()))? "main":"login_fail";			
		}else{
			page="join";
		}
		map.put("page",page);
		map.put("user", m);
		return map;
	}
}