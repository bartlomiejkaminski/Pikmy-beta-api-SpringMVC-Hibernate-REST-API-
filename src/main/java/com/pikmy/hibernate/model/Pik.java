package com.pikmy.hibernate.model;

import java.util.Date;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.ElementCollection;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;

@Entity
@Table(name="pik")
public class Pik {

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(name="ID", nullable=false)
	private Integer id;
	
	@NotNull
	@Column(name="ID_USER", nullable=false)
	private Integer id_user;
	
	@NotNull
	@Column(name="ID_CHANNEL", nullable=false)
	private Integer id_channel;
	
	@NotNull
	@Column(name="CONTENT", nullable=false)
	private String content;
	
	@NotNull
	@Column(name="PIK_DATE", nullable=false)
	private String pik_date;

	public Pik() {

	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
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

	public String getPik_date() {
		return pik_date;
	}

	public void setPik_date(String pik_date) {
		this.pik_date = pik_date;
	}
	
}
