package com.pikmy.hibernate.model;

import java.net.URL;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="avatar")
public class Avatar {
	
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(name="ID_AVATAR", nullable=false, unique=true)
	private Integer id_avatar;
	
	@Column(name="URL_AVATAR", nullable=false)
	private URL url_avatar;

	public Avatar() {

	}
	
	public Avatar(Integer id_avatar, URL url_avatar) {
		super();
		this.id_avatar = id_avatar;
		this.url_avatar = url_avatar;
	}

	public Integer getId_avatar() {
		return id_avatar;
	}

	public void setId_avatar(Integer id_avatar) {
		this.id_avatar = id_avatar;
	}

	public URL getUrl_avatar() {
		return url_avatar;
	}

	public void setUrl_avatar(URL url_avatar) {
		this.url_avatar = url_avatar;
	}

	
}
