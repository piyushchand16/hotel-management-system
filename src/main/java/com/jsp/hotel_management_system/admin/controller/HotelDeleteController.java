package com.jsp.hotel_management_system.admin.controller;

import java.io.IOException;

import com.jsp.hotel_management_system.admin.dao.HotelDao;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

@WebServlet(value="/deleteHotel")
public class HotelDeleteController extends HttpServlet{
	
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		// TODO Auto-generated method stub
		int id=Integer.parseInt(req.getParameter("id"));
		
		boolean ans=new HotelDao().deleteHotelById(id);
		if(ans) {
			req.setAttribute("msg", "hotel details deleted");
			req.getRequestDispatcher("home-hotel-owner.jsp").forward(req, resp);
		}else {
			req.setAttribute("msg", "hotel details not deleted");
			req.getRequestDispatcher("home-hotel-owner.jsp").forward(req, resp);
		}
	}

}
