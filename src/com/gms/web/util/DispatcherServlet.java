package com.gms.web.util;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class DispatcherServlet {
	public static void send(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		System.out.println("DispatcherServlet send start");
		request.getRequestDispatcher(Separator.cmd.getView()).forward(request, response);
		System.out.println("DispatcherServlet send end");
	}
}
