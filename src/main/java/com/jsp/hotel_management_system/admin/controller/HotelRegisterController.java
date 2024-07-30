package com.jsp.hotel_management_system.admin.controller;

import java.io.IOException;
import java.io.InputStream;

import com.jsp.hotel_management_system.admin.dao.HotelDao;
import com.jsp.hotel_management_system.admin.dao.HotelOwnerDao;
import com.jsp.hotel_management_system.dto.Hotel;
import com.jsp.hotel_management_system.dto.HotelOwner;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.MultipartConfig;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;
import jakarta.servlet.http.Part;

@WebServlet(value="/hotelRegister")
@MultipartConfig
//using this for bringing file 
public class HotelRegisterController extends HttpServlet  {
	
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		HttpSession httpSession=req.getSession();
		
		String name=req.getParameter("name");
		String city=req.getParameter("city");
		String address=req.getParameter("address");
		double price=Double.parseDouble(req.getParameter("price"));
		
		Part part=req.getPart("image");
		
		InputStream inputStream=part.getInputStream();
		if(httpSession.getAttribute("ownerSession")!=null) {
			
			String email=(String)httpSession.getAttribute("ownerSession");
			HotelOwner hotelOwner=new HotelOwnerDao().findHotelOwnerByEmailDao(email);
			
			Hotel hotel=new Hotel(name, city, address, price, null, inputStream.readAllBytes(), hotelOwner);
			Hotel hotel2=new HotelDao().saveHotelDao(hotel);
			
			req.setAttribute("msg", "hotel registered successfully");
			req.getRequestDispatcher("login-hotel-owner.jsp").forward(req, resp);
			
		}else {
			req.setAttribute("msg", "please login as hotel owner and then register");
			req.getRequestDispatcher("login-hotel-owner.jsp").forward(req, resp);
		}
		
		
		
	}
}
