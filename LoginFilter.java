package com.pack;

import java.io.IOException;

import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.annotation.WebFilter;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
@WebFilter("/log")
public class LoginFilter implements Filter//only implements java.servlet 
{

	@Override
	public void doFilter(ServletRequest req, ServletResponse res, FilterChain fc)throws IOException, ServletException 
	{
		
		
		UserBean ub = new UserLoginDAO().CheckLogin(req.getParameter("username"),req.getParameter("password"));
		if(ub==null)
		{
			HttpServletRequest request = (HttpServletRequest) req;
			HttpServletResponse response = (HttpServletResponse) res;

			request.setAttribute("msg", "Invalid Username or Password");
			request.getRequestDispatcher("Login.jsp")
			       .forward(request, response);
		}
		else
		{
			req.setAttribute("UserBean",ub);
			fc.doFilter(req, res);
			
		}
	}
   
}
