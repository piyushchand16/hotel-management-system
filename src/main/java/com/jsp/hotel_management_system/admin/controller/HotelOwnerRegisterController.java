package com.jsp.hotel_management_system.admin.controller;

import java.io.IOException;

import com.jsp.hotel_management_system.admin.dao.HotelOwnerDao;
import com.jsp.hotel_management_system.dto.HotelOwner;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

@WebServlet(value = "/hotelOwnerRegister")
public class HotelOwnerRegisterController extends HttpServlet {

	HotelOwnerDao dao = new HotelOwnerDao();

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		// TODO Auto-generated method stub
		String name = req.getParameter("name");
		String email = req.getParameter("email");
		String password = req.getParameter("password");
		long phone = Long.parseLong(req.getParameter("phone"));

		HotelOwner owner = new HotelOwner(name, email, password, phone,null);

		owner = dao.saveHotelOwnerDao(owner);
		if (owner != null) {
			req.setAttribute("msg", "Account created succesfully");
			req.getRequestDispatcher("register-hotel-owner.jsp").forward(req, resp);
		} else {
			req.setAttribute("msg", "not registered");
			req.getRequestDispatcher("register-hotel-owner.jsp").forward(req, resp);
		}
	}

}
