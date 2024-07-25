package com.jsp.hotel_management_system.admin.controller;

import java.io.IOException;

import com.jsp.hotel_management_system.admin.dao.AdminDao;
import com.jsp.hotel_management_system.dto.Admin;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;


@WebServlet(value="/loginAdmin")
public class AdminLoginController extends HttpServlet{
	
	
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		// TODO Auto-generated method stub
		HttpSession httpSession=req.getSession();
		
		AdminDao dao=new AdminDao();
		
		String email=req.getParameter("email");
		String password=req.getParameter("password");
		
		Admin admin=dao.fetchAdminByEmailDao(email);
		
		
		if(admin!=null) {
			if(admin.getPassword().equals(password)) {
				httpSession.setAttribute("adminSession", email);
				req.getRequestDispatcher("admin-home.jsp").forward(req, resp);
			}else {
				req.setAttribute("msg", "password is wrong");
				req.getRequestDispatcher("admin-login.jsp").forward(req, resp);
			}
		}else {
			req.setAttribute("msg", "Email is incorrect");
			req.getRequestDispatcher("admin-login.jsp").forward(req, resp);
		}
	}
	
}
