package com.jsp.hotel_management_system.admin.controller;

import java.io.IOException;

import com.jsp.hotel_management_system.admin.dao.HotelOwnerDao;
import com.jsp.hotel_management_system.dto.HotelOwner;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.MultipartConfig;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;

@WebServlet(value="/hotelOwnerLogin")
@MultipartConfig()
public class HotelOwnerLoginController extends HttpServlet{
	HotelOwnerDao dao=new HotelOwnerDao();
	
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		// TODO Auto-generated method stub
		HttpSession httpSession=req.getSession();
		
		String email = req.getParameter("email");
		String password = req.getParameter("password");
		HotelOwner owner=dao.findHotelOwnerByEmailDao(email);
		System.out.println(owner);
		if (owner != null) {
			if(owner.getVerify().equalsIgnoreCase("yes")) {
				if(password.equals(owner.getPassword())) {
					httpSession.setAttribute("ownerSession", email);
					req.getRequestDispatcher("home-hotel-owner.jsp").forward(req, resp);
				}else {
					req.setAttribute("msg", "Incorrect password");
					req.getRequestDispatcher("login-hotel-owner.jsp").forward(req, resp);
				}
			}else {
				req.setAttribute("msg", "you are not verified");
				req.getRequestDispatcher("login-hotel-owner.jsp").forward(req, resp);
			}
		} else {
			req.setAttribute("msg", "email not found");
			req.getRequestDispatcher("login-hotel-owner.jsp").forward(req, resp);
		}
	}
}
