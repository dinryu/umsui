package com.gms.web.factory;

import com.gms.web.command.*;
import com.gms.web.constant.Action;
import com.gms.web.domain.MemberBean;
import com.gms.web.service.MemberService;

public class CommandFactory  {
	public static Command createCommand(String dir, String action,String page,String pageNumber, String column,String search){
		Command cmd=null;
		if(action==null){
			action=Action.MOVE;
		}
		switch(action){
		case Action.MOVE: case Action.LOGIN: case Action.LOGOUT: case Action.JOIN:
		case Action.UPDATE: case Action.DELETE: case Action.DETAIL: 
			cmd=new MoveCommand(dir, action, page);
			break;	
		case Action.LIST:
			cmd=new ListCommand(dir, action, page, pageNumber);
		case Action.SEARCH:
			cmd=new SearchCommand(dir, action, page, pageNumber, column, search);
		default: System.out.println("CommandFactory : Command Fail");
			break;
		}
		
		return cmd;
	}

}
