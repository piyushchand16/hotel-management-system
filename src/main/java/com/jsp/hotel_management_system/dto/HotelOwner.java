package com.jsp.hotel_management_system.dto;

import java.io.Serializable;
import java.util.List;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;
import lombok.Data;
import lombok.Value;


@Data
@Entity
public class HotelOwner implements Serializable {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id;
	private String name;
	@Column(unique = true,nullable = false)
	private String email;
	private String password;
	private Long phone;
	private String verify;
	
	@OneToMany
	private List<Hotel> hotel;

	 
	public HotelOwner() {
		super();
	}


	public HotelOwner(int id, String name, String email, String password, Long phone, String verify,
			List<Hotel> hotel) {
		super();
		this.id = id;
		this.name = name;
		this.email = email;
		this.password = password;
		this.phone = phone;
		this.verify = verify;
		this.hotel = hotel;
	}


	public HotelOwner(String name, String email, String password, Long phone, String verify, List<Hotel> hotel) {
		super();
		this.name = name;
		this.email = email;
		this.password = password;
		this.phone = phone;
		this.verify = verify;
		this.hotel = hotel;
	}

//register
	public HotelOwner(String name, String email, String password, Long phone, String verify) {
		super();
		this.name = name;
		this.email = email;
		this.password = password;
		this.phone = phone;
		this.verify = "no";
	}


	public HotelOwner(String name, String email, String password, Long phone) {
		super();
		this.name = name;
		this.email = email;
		this.password = password;
		this.phone = phone;
	}
	
	
	
	

	
	
}
