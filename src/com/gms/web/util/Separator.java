package com.gms.web.util;

import javax.servlet.http.HttpServletRequest;

import com.gms.web.command.Command;
import com.gms.web.factory.CommandFactory;

public class Separator {
	public static Command cmd=new Command();	
	public static void init(HttpServletRequest request){
		String servletPath=request.getServletPath();
/*		String action=request.getParameter("action");
		String page=request.getParameter("page");		
		String dir=servletPath.substring(1,servletPath.indexOf("."));		
		cmd=CommandFactory.createCommand(dir,action,page);	
*/	
		
		cmd=CommandFactory.createCommand(
			servletPath.substring(1,servletPath.indexOf(".")),
			request.getParameter("action"),			
			request.getParameter("page"),
			request.getParameter("pageNumber"),
			request.getParameter("column"),
			request.getParameter("search"));
		System.out.println("Separator init : "+cmd);
	}
}
