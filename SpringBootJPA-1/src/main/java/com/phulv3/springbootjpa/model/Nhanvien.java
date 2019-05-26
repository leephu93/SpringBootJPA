package com.phulv3.springbootjpa.model;

import java.io.Serializable;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.OneToMany;
import javax.persistence.Table;

/**
 * Nhanvien.java
 *
 * Version 1.0
 *
 * Date: 18-05-2019
 *
 * Copyright PhuLV3
 *
 * Modification Logs: DATE AUTHOR DESCRIPTION
 * -----------------------------------------------------------------------
 * 19-05-2019 PhuLV3 Create
 */

@Entity
@Table(name = "NHANVIEN")
public class Nhanvien implements Serializable {

	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "ID")
	private int id;

	@Column(name = "FULLNAME", nullable = false)
	private String fullname;

	@Column(name = "AGE", nullable = false)
	private int age;

	@Column(name = "PHONE", nullable = false)
	private String phone;

	@OneToMany(fetch = FetchType.LAZY, cascade = CascadeType.ALL, mappedBy="nhanvien")
//	@JoinColumn(name = "NHANVIEN_ID")
	private List<XE> listXe;

	@ManyToMany
	@JoinTable(name = "NHANVIEN_SANPHAM", joinColumns = {
			@JoinColumn(name = "ID_NHANVIEN", referencedColumnName = "id") }, inverseJoinColumns = {
					@JoinColumn(name = "ID_SANPHAM", referencedColumnName = "id") })
	private List<Sanpham> listSanpham;

	public Nhanvien() {
		// TODO Auto-generated constructor stub
	}

	public Nhanvien(String fullname, int age, String phone, List<XE> listXe, List<Sanpham> listSanpham) {
		super();
		this.fullname = fullname;
		this.age = age;
		this.phone = phone;
		this.listXe = listXe;
		this.listSanpham = listSanpham;
	}

	public Nhanvien(int id, String fullname, int age, String phone, List<XE> listXe, List<Sanpham> listSanpham) {
		super();
		this.id = id;
		this.fullname = fullname;
		this.age = age;
		this.phone = phone;
		this.listXe = listXe;
		this.listSanpham = listSanpham;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getFullname() {
		return fullname;
	}

	public void setFullname(String fullname) {
		this.fullname = fullname;
	}

	public int getAge() {
		return age;
	}

	public void setAge(int age) {
		this.age = age;
	}

	public String getPhone() {
		return phone;
	}

	public void setPhone(String phone) {
		this.phone = phone;
	}

	public List<XE> getListXe() {
		return listXe;
	}

	public void setListXe(List<XE> listXe) {
		this.listXe = listXe;
	}

	public List<Sanpham> getListSanpham() {
		return listSanpham;
	}

	public void setListSanpham(List<Sanpham> listSanpham) {
		this.listSanpham = listSanpham;
	}

	@Override
	public String toString() {
		return String.format("[ID: %d, FULLNAME: %s, AGE: %d, PHONE: %s]", id, fullname, age, phone);
	}

}
