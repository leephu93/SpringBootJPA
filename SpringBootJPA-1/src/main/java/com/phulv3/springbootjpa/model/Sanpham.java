package com.phulv3.springbootjpa.model;

import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.Table;

/**
 * Sanpham.java
 *
 * Version 1.0
 *
 * Date: 19-05-2019
 *
 * Copyright PhuLV3
 *
 * Modification Logs: DATE AUTHOR DESCRIPTION
 * -----------------------------------------------------------------------
 * 19-05-2019 PhuLV3 Create
 */

@Entity
@Table(name = "SANPHAM")
public class Sanpham {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "ID")
	private int id;

	@Column(name = "NAME")
	private String name;

	@Column(name = "PRICE")
	private float price;

	@Column(name = "QUANTITY")
	private int quantity;

	@ManyToMany
	@JoinTable(name = "NHANVIEN_SANPHAM", joinColumns = {
			@JoinColumn(name = "ID_SANPHAM", referencedColumnName = "id") }, inverseJoinColumns = {
					@JoinColumn(name = "ID_NHANVIEN", referencedColumnName = "id") })
	private List<Nhanvien> listNhanvien;

	public Sanpham() {
		// TODO Auto-generated constructor stub
	}

	public Sanpham(String name, float price, int quantity, List<Nhanvien> listNhanvien) {
		super();
		this.name = name;
		this.price = price;
		this.quantity = quantity;
		this.listNhanvien = listNhanvien;
	}

	public Sanpham(int id, String name, float price, int quantity, List<Nhanvien> listNhanvien) {
		super();
		this.id = id;
		this.name = name;
		this.price = price;
		this.quantity = quantity;
		this.listNhanvien = listNhanvien;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public float getPrice() {
		return price;
	}

	public void setPrice(float price) {
		this.price = price;
	}

	public int getQuantity() {
		return quantity;
	}

	public void setQuantity(int quantity) {
		this.quantity = quantity;
	}

	public List<Nhanvien> getListNhanvien() {
		return listNhanvien;
	}

	public void setListNhanvien(List<Nhanvien> listNhanvien) {
		this.listNhanvien = listNhanvien;
	}

}
