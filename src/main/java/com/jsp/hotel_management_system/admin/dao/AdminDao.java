package com.jsp.hotel_management_system.admin.dao;

import com.jsp.hotel_management_system.dto.Admin;

import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityTransaction;
import jakarta.persistence.Persistence;
import jakarta.persistence.Query;

public class AdminDao {
	
	EntityManager em=Persistence.createEntityManagerFactory("hotel-project").createEntityManager();
	EntityTransaction et=em.getTransaction();
	
	public Admin fetchAdminByEmailDao(String email) {
		Query query=em.createQuery("select a from Admin a where a.email=?1");
		query.setParameter(1, email);
		try {
			return (Admin)query.getSingleResult();
		} catch (Exception e) {
			// TODO: handle exception
//			e.printStackTrace();
			return null;
		}	
	}
}
