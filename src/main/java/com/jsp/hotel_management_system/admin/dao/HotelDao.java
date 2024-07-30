package com.jsp.hotel_management_system.admin.dao;

import java.util.List;

import com.jsp.hotel_management_system.dto.Hotel;

import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityTransaction;
import jakarta.persistence.Persistence;

public class HotelDao {
	
	EntityManager em=Persistence.createEntityManagerFactory("hotel-project").createEntityManager();
	EntityTransaction et=em.getTransaction();
	
	public Hotel saveHotelDao(Hotel hotel) {
		try {
			et.begin();
			em.persist(hotel);
			et.commit();
			return hotel;
		} catch (Exception e) {
			// TODO: handle exception
			return null;
		}
	}
	
	public List<Hotel> getAllHotelDetailsDao(){
		return em.createQuery("FROM Hotel").getResultList();
	}
	
	public boolean deleteHotelById(int id) {
		Hotel hotel=em.find(Hotel.class, id);
		
		if(hotel!=null) {
			et.begin();
			em.remove(hotel);
			et.commit();
			return true;
		}else {
			return false;
		}
	}

}
