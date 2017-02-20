package com.pikmy.hibernate.model;


import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.ManyToMany;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;

@Entity
@Table(name="user")
public class User {
	
	@Id
	@NotNull
	@Column(name="ID", nullable=false)
	private String id;
	
	@NotNull
	@Column(name="FIRST_NAME", nullable=false)
	private String first_name;
	
	@NotNull
	@Column(name="LAST_NAME", nullable=false)
	private String last_name;
	
	@NotNull
	@Column(name="EMAIL", nullable=false)
	private String email;
	
	@NotNull
	@Column(name="GENDER", nullable=false)
	private String gender;
	
	@NotNull
	@Column(name="BIRTHDAY", nullable=false)
	private String birthday;
	
	@ManyToMany
	private List<Channel> list_channel;
	
	public User() {
		
	}

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public String getFirst_name() {
		return first_name;
	}

	public void setFirst_name(String first_name) {
		this.first_name = first_name;
	}

	public String getLast_name() {
		return last_name;
	}

	public void setLast_name(String last_name) {
		this.last_name = last_name;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getGender() {
		return gender;
	}

	public void setGender(String gender) {
		this.gender = gender;
	}

	public String getBirthday() {
		return birthday;
	}

	public void setBirthday(String birthday) {
		this.birthday = birthday;
	}

	public List<Channel> getList_channel() {
		return list_channel;
	}

	public void setList_channel(List<Channel> list_channel) {
		this.list_channel = list_channel;
	}
	
}
