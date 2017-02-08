package com.pikmy.hibernate.model;

import java.util.Date;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.ElementCollection;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;

@Entity
@Table(name="channel")
public class Channel {
	
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(name="ID_CHANNEL", nullable=false, unique=true)
	private Integer id_channel;

	@Column(name="NAME_CHANNEL", nullable=false)
	private String name_channel;
	
	@Column(name="CHANNEL_DATE", nullable=false)
	private Date channel_date;
	
	@ElementCollection
	@OneToMany()
	private List<User> list_users;
	
	public Channel() {

	}

	public Channel(Integer id_channel, String name_channel, Date channel_date, List<User> list_users) {
		super();
		this.id_channel = id_channel;
		this.name_channel = name_channel;
		this.channel_date = channel_date;
		this.list_users = list_users;
	}

	public Integer getId_channel() {
		return id_channel;
	}

	public void setId_channel(Integer id_channel) {
		this.id_channel = id_channel;
	}

	public String getName_channel() {
		return name_channel;
	}

	public void setName_channel(String name_channel) {
		this.name_channel = name_channel;
	}

	public Date getChannel_date() {
		return channel_date;
	}

	public void setChannel_date(Date channel_date) {
		this.channel_date = channel_date;
	}

	public List<User> getList_users() {
		return list_users;
	}

	public void setList_users(List<User> list_users) {
		this.list_users = list_users;
	}

	
}
