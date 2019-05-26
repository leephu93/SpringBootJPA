package com.phulv3.springbootjpa.model;

import java.io.Serializable;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

/**
 * XE.java
 *
 * Version 1.0
 *
 * Date: 19-05-2019
 *
 * Copyright PhuLV3
 *
 * Modification Logs:
 * DATE                 AUTHOR          DESCRIPTION
 * -----------------------------------------------------------------------
 * 19-05-2019        	PhuLV3          Create
*/

@Entity
@Table(name = "XE")
public class XE implements Serializable {

	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "ID")
	private int id;

	@Column(name = "NAME")
	private String name;

	@ManyToOne(cascade = CascadeType.ALL)
	@JoinColumn(name = "NHANVIEN_ID", nullable = false)
	private Nhanvien nhanvien;

	public XE() {
		// TODO Auto-generated constructor stub
	}
	
	public XE(String name) {
		super();
		this.name = name;
	}

	public XE(String name, Nhanvien nhanvien) {
		super();
		this.name = name;
		this.nhanvien = nhanvien;
	}

	public XE(int id, String name, Nhanvien nhanvien) {
		super();
		this.id = id;
		this.name = name;
		this.nhanvien = nhanvien;
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

	public Nhanvien getNhanvien() {
		return nhanvien;
	}

	public void setNhanvien(Nhanvien nhanvien) {
		this.nhanvien = nhanvien;
	}

}
