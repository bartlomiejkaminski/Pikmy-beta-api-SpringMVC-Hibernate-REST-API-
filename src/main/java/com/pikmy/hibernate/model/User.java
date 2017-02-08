package com.pikmy.hibernate.model;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

@Entity
@Table(name="user")
public class User {
	
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(name="ID_USER", nullable=false, unique=true)
	private Integer id_user;
	
	@Column(name="ID_AVATAR", nullable=false)
	private Integer id_avatar;
	
	@Column(name="NAME", nullable=false)
	private String name;
	
	@Column(name="PASSWORD", nullable=false)
	private String password;
	
	@Temporal(TemporalType.DATE)
	@Column(name="DATE", nullable=false)
	private Date date;
	
	public User() {
		
	}

	public User(Integer id_user, Integer id_avatar, String name, String password, Date date) {
		super();
		this.id_user = id_user;
		this.id_avatar = id_avatar;
		this.name = name;
		this.password = password;
		this.date = date;
	}

	public Integer getId_user() {
		return id_user;
	}

	public void setId_user(Integer id_user) {
		this.id_user = id_user;
	}

	public Integer getId_avatar() {
		return id_avatar;
	}

	public void setId_avatar(Integer id_avatar) {
		this.id_avatar = id_avatar;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public Date getDate() {
		return date;
	}

	public void setDate(Date date) {
		this.date = date;
	}

	
}
