package com.jsp.hotel_management_system.admin.dao;

import java.util.List;

import com.jsp.hotel_management_system.dto.HotelOwner;

import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityTransaction;
import jakarta.persistence.Persistence;
import jakarta.persistence.Query;

public class HotelOwnerDao {
	
	
	EntityManager em=Persistence.createEntityManagerFactory("hotel-project").createEntityManager();
	EntityTransaction et=em.getTransaction();
	
	public HotelOwner saveHotelOwnerDao(HotelOwner owner) {
		try {
			
			et.begin();
			em.persist(owner);
			et.commit();
			return owner;
			
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
			return null;
		}
	}
	
	public HotelOwner findHotelOwnerByEmailDao(String email) {
		try {
			Query query=em.createNativeQuery("select * from hotelowner where email=?1", HotelOwner.class);
			query.setParameter(1, email);	
			return (HotelOwner) query.getSingleResult();
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
			return null;
		}
	}
	
	public List<HotelOwner> getAllHotelOwnerDao(){
		try {
			return em.createQuery("from HotelOwner").getResultList();
			
		} catch (Exception e) {
			// TODO: handle exception
			return null;
		}
	}
	
	public boolean updateHotelOwnerDao(int id,String action) {
		try {
			et.begin();
			Query query=em.createQuery("update HotelOwner h set h.verify= :action where h.id= :id");
			query.setParameter("action", action);
			query.setParameter("id", id);
		    query.executeUpdate();
		    et.commit();
		    return true;
		} catch (Exception e) {
			// TODO: handle exception
			System.out.println("exception hit");
			e.printStackTrace();
			return false;
		}
	}

}
