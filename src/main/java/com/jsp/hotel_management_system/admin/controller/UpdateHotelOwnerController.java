package com.jsp.hotel_management_system.admin.controller;

import java.io.IOException;

import com.jsp.hotel_management_system.admin.dao.HotelOwnerDao;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;


@WebServlet(value="/update")
public class UpdateHotelOwnerController extends HttpServlet {
	
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		// TODO Auto-generated method stub
		HttpSession httpSession=req.getSession();
		int id=Integer.parseInt(req.getParameter("id"));
		String action=req.getParameter("action");
		
//		System.out.println(id+"  "+action);
		
		if(httpSession.getAttribute("adminSession")!=null) {
			
			HotelOwnerDao dao=new HotelOwnerDao();
			dao.updateHotelOwnerDao(id, action);
			
			resp.sendRedirect("admin-home.jsp");
		}else {
			req.setAttribute("msg", "Please login with admin and perform task");
			req.getRequestDispatcher("admin-login.jsp").forward(req, resp);
		}
		
	}
}
