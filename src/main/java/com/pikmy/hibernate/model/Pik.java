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
@Table(name="pik")
public class Pik {

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(name="ID_PIK", nullable=false, unique=true)
	private Integer id_pik;
	
	@Column(name="ID_USER", nullable=false)
	private Integer id_user;
	
	@Column(name="ID_CHANNEL", nullable=false)
	private Integer id_channel;
	
	@Column(name="CONTENT", nullable=false)
	private String content;
	
	@Column(name="PIK_DATE", nullable=false)
	private Date pik_date;
	
	@ElementCollection
	@OneToMany()
	private List<User> list_accepted;

	public Pik() {

	}
	
	public Pik(Integer id_pik, Integer id_user, Integer id_channel, String content, Date pik_date,
			List<User> list_accepted) {
		super();
		this.id_pik = id_pik;
		this.id_user = id_user;
		this.id_channel = id_channel;
		this.content = content;
		this.pik_date = pik_date;
		this.list_accepted = list_accepted;
	}

	public Integer getId_pik() {
		return id_pik;
	}

	public void setId_pik(Integer id_pik) {
		this.id_pik = id_pik;
	}

	public Integer getId_user() {
		return id_user;
	}

	public void setId_user(Integer id_user) {
		this.id_user = id_user;
	}

	public Integer getId_channel() {
		return id_channel;
	}

	public void setId_channel(Integer id_channel) {
		this.id_channel = id_channel;
	}

	public String getContent() {
		return content;
	}

	public void setContent(String content) {
		this.content = content;
	}

	public Date getPik_date() {
		return pik_date;
	}

	public void setPik_date(Date pik_date) {
		this.pik_date = pik_date;
	}

	public List<User> getList_accepted() {
		return list_accepted;
	}

	public void setList_accepted(List<User> list_accepted) {
		this.list_accepted = list_accepted;
	}
	
	
}
