package com.spring.entities;


import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "wish")
public class WishEntity {
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private int id;
	@Column(name = "title")
	private String wishTitleString;
	@Column(name="content")
	private String wishContentString;
	@Column(name="date")
	private String wishDate;
	public WishEntity() {
		super();
		// TODO Auto-generated constructor stub
	}
	public WishEntity(int id, String wishTitleString, String wishContentString, String wishDate) {
		super();
		this.id = id;
		this.wishTitleString = wishTitleString;
		this.wishContentString = wishContentString;
		this.wishDate = wishDate;
	}
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getWishTitleString() {
		return wishTitleString;
	}
	public void setWishTitleString(String wishTitleString) {
		this.wishTitleString = wishTitleString;
	}
	public String getWishContentString() {
		return wishContentString;
	}
	public void setWishContentString(String wishContentString) {
		this.wishContentString = wishContentString;
	}
	public String getWishDate() {
		return wishDate;
	}
	public void setWishDate(String wishDate) {
		this.wishDate = wishDate;
	}
	@Override
	public String toString() {
		return "WishEntity [id=" + id + ", wishTitleString=" + wishTitleString + ", wishContentString="
				+ wishContentString + ", wishDate=" + wishDate + "]";
	}

	
}
