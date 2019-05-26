package com.phulv3.springbootjpa.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.phulv3.springbootjpa.model.Nhanvien;

/**
 * NhanvienRepository.java
 *
 * Version 1.0
 *
 * Date: 18-05-2019
 *
 * Copyright PhuLV3
 *
 * Modification Logs:
 * DATE                 AUTHOR          DESCRIPTION
 * -----------------------------------------------------------------------
 * 18-05-2019        	PhuLV3          Create
*/

@Repository
public interface NhanvienRepository extends JpaRepository<Nhanvien, Integer>{
	
	Nhanvien findByFullname(String fullname);
	
	@Query("Select nv from Nhanvien nv where nv.id = :id and nv.fullname = :fullname")
	Nhanvien findNhanvienByIdAndFullname(@Param("id") int id, @Param("fullname") String fullname);
	
}


