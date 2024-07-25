package com.jsp.hotel_management_system.admin.controller;

import java.io.IOException;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;


@WebServlet(value="/ownerLogout")
public class OwnerLogoutController extends HttpServlet {
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		// TODO Auto-generated method stub
		HttpSession httpSession=req.getSession();
		
		if(httpSession.getAttribute("ownerSession")!=null) {
			httpSession.invalidate();
			req.setAttribute("msg", "Succesfully Logged out");
			req.getRequestDispatcher("login-hotel-owner.jsp").forward(req, resp);
		}else {
			req.setAttribute("msg", "You are not logged in");
			req.getRequestDispatcher("login-hotel-owner.jsp").forward(req, resp);
		}
	}
}
