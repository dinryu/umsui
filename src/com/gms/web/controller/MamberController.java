package com.gms.web.controller;

import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;


import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.eclipse.jdt.internal.compiler.ast.ArrayAllocationExpression;
import org.eclipse.jdt.internal.compiler.ast.ParameterizedSingleTypeReference;

import com.gms.web.command.Command;
import com.gms.web.constant.Action;
import com.gms.web.dao.MemberDAOImpl;
import com.gms.web.domain.MajorBean;
import com.gms.web.domain.MemberBean;
import com.gms.web.domain.StudentBean;
import com.gms.web.proxy.BlockHandler;
import com.gms.web.proxy.PageHandler;
import com.gms.web.proxy.PageProxy;
import com.gms.web.service.MemberService;
import com.gms.web.service.MemberServiceImpl;
import com.gms.web.util.DispatcherServlet;
import com.gms.web.util.ParamsIterator;
import com.gms.web.util.Separator;


@WebServlet("/member.do")
public class MamberController extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void service(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		System.out.println("memberController separator 진입");
		Separator.init(request);
		System.out.println("memberController service 진입");
		MemberService service = MemberServiceImpl.getInstance();
		MemberBean member = new MemberBean();
		Map<?,?> map = new HashMap<>();
		PageProxy pxy= new PageProxy(request);
		Command cmd = new Command();
		pxy.setPageSize(5);
		pxy.setBlockSize(5);
		System.out.println("switch 시작");
		switch (Separator.cmd.getAction()) {
		case Action.MOVE:
			System.out.println("memberController move 진입");
			DispatcherServlet.send(request, response);
			break;
		case Action.JOIN:
			System.out.println("memberController join 진입");
			map = ParamsIterator.execute(request);
			System.out.println("map :"+ map);
			member.setId((String)map.get("id"));
			member.setPw((String)map.get("password"));
			member.setName((String)map.get("name"));
			member.setBirthday((String)map.get("birthday"));
			member.setGender((String)map.get("gender"));
			member.setEmail((String)map.get("email"));
			member.setPhone((String)map.get("phone"));
			member.setMajor((String)map.get("major"));
			member.setProfile("dog.jpg");			
			
			System.out.println("member :"+ member);	
			String[] subjects=((String)map.get("subject")).split(",");
			List<MajorBean> list = new ArrayList<>();
			MajorBean major = null;
			for(int i=0;i<subjects.length;i++){
				major = new MajorBean();
				major.setMajorId(String.valueOf((int)((Math.random() * 9999) + 1000)));
				major.setId((String)map.get("id"));
				major.setTitle((String)map.get("name"));
				major.setSubjId(subjects[i]);
				list.add(major);
			}
			System.out.println("list :"+ list);
			Map<String, Object> tempMap = new HashMap<>();
			tempMap.put("member", member);
			tempMap.put("major", list);
			String rs=service.add(tempMap);
			Separator.cmd.setDir("common");
			Separator.cmd.process();
			System.out.println("컨트롤러 인서트 결과 : "+rs);		
			DispatcherServlet.send(request, response);
			break;
		case Action.LIST:
			System.out.println("Action.LIST: 진입");
/*			@SuppressWarnings("unchecked") 
			List<StudentBean> memberlist=(List<StudentBean>)service.list();
			System.out.println("db에서 가저온 memberlist :"+memberlist);
			Agency a=new PageProxy();
			Map<?,?>r = a.delegateTo(null);
			request.setAttribute("prevBlock","0");
			request.setAttribute("pageNumber",request.getParameter("pageNumber"));
			request.setAttribute("list", memberlist);
			request.setAttribute("startPage", "1");
			System.out.println("Controllor 페이지수:"+memberlist.size()/5);
			int theNumberOfPages =(memberlist.size()%5!=0)?memberlist.size()/5+1:memberlist.size()/5;
			request.setAttribute("theNumberOfPages", theNumberOfPages);
			request.setAttribute("endPage",String.valueOf(theNumberOfPages));	*/
            System.out.println("PROXY 전 : "+request);
            cmd.setColumn(String.valueOf(map.get("column")));
			cmd.setSearch(String.valueOf(map.get("search")));
			pxy.setTheNumberOfRows(Integer.parseInt(service.countMembers(cmd)));
			pxy.setPageNumber(Integer.parseInt(request.getParameter("pageNumber")));
			pxy.execute(BlockHandler.attr(pxy),service.list(PageHandler.attr(pxy)));
            System.out.println("PROXY 후 : "+request);
			DispatcherServlet.send(request, response);
			break;
		case Action.SEARCH:
/*			
			map = ParamsIterator.execute(request);-
			System.out.println("Action.SEARCH: "+map);			
			pxy.setTheNumberOfRows(Integer.parseInt(service.countMembers(cmd)));-
			cmd=PageHandler.attr(pxy);-
			System.out.println("Action.SEARCH request:"+request.getParameter("pageNumber"));
			System.out.println("Action.SEARCH cmd:"+cmd.getPageNumber());
			cmd.setPageNumber(request.getParameter("pageNumber"));-
			cmd.setColumn("name");-
			cmd.setSearch(String.valueOf(map.get("search")));-				
			cmd.setStartRow(PageHandler.attr(pxy).getStartRow());
			cmd.setEndRow(PageHandler.attr(pxy).getEndRow());
//			request.setAttribute("list",service.findByNames(cmd));
			pxy.setPageNumber(Integer.parseInt(cmd.getPageNumber()));-			
			pxy.execute(BlockHandler.attr(pxy),service.findByNames(cmd));- 
			DispatcherServlet.send(request, response);
*/			
			map=ParamsIterator.execute(request);
			cmd.setSearch(String.valueOf(map.get("search")));
			pxy.setTheNumberOfRows(Integer.parseInt(service.countMembers(cmd)));
			cmd.setPageNumber(request.getParameter("pageNumber"));
			pxy.setPageNumber(Integer.parseInt(cmd.getPageNumber()));
			cmd=PageHandler.attr(pxy);
			cmd.setColumn("name");
			cmd.setSearch(String.valueOf(map.get("search")));
			//request.setAttribute("list", service.findByName(cmd));
			pxy.execute(BlockHandler.attr(pxy),service.findByNames(cmd));
			System.out.println("Action.SEARCH cmd:"+cmd.getPageNumber());
			DispatcherServlet.send(request, response);
			break;
		case Action.UPDATE:
			cmd.setSearch(request.getParameter("id"));
			service.modify(service.findById(cmd));
			DispatcherServlet.send(request, response);
			break;
		case Action.DELETE:
//			service.remove(request.getParameter("id"));
//			DispatcherServlet.send(request, response);
			response.sendRedirect(request.getContextPath()+"/member.do?action=list&page=member_list&pageNumber=1");
			break;
		case Action.DETAIL:
			cmd.setSearch(request.getParameter("id"));
			request.setAttribute("student",service.findById(cmd));
			DispatcherServlet.send(request, response);
			break;
		
		default: System.out.println("file....");
			break;
		}
	}
	
}
