package com.tank.challengeme.servlet;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.springframework.web.servlet.DispatcherServlet;

public class FrontServlet extends DispatcherServlet{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	@Override
	protected void doDispatch(HttpServletRequest arg0, HttpServletResponse arg1)
			throws Exception { 
		HttpSession session =arg0.getSession();
		if(session!=null && session.getAttribute("username")==null){
			arg1.sendRedirect("/challengeme/login.xhtml");
		}
		// TODO Auto-generated method stub
		super.doDispatch(arg0, arg1);
	}

}
