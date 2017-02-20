package com.pikmy.hibernate.model;


import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;

@Entity
@Table(name="channel")
public class Channel {
	
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(name="ID", nullable=false)
	private Integer id;

	@NotNull
	@Column(name="NAME_CHANNEL", nullable=false)
	private String name_channel;
	
	@NotNull
	@Column(name="CHANNEL_DATE", nullable=false)
	private String channel_date;
	
	@ManyToMany
	private List<User> list_users;
	
	public Channel() {

	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getName_channel() {
		return name_channel;
	}

	public void setName_channel(String name_channel) {
		this.name_channel = name_channel;
	}

	public String getChannel_date() {
		return channel_date;
	}

	public void setChannel_date(String channel_date) {
		this.channel_date = channel_date;
	}

	public List<User> getList_users() {
		return list_users;
	}

	public void setList_users(List<User> list_users) {
		this.list_users = list_users;
	}

}
