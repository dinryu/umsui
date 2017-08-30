package com.gms.web.command;

public class LoginCommand extends Command{
	public LoginCommand(String dir, String action,String page){
		super.dir=dir;
		super.action=action;
		super.page=page;
		super.process();
	}

}
