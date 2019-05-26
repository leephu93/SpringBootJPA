package com.phulv3.springbootjpa.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.phulv3.springbootjpa.model.Sanpham;

/**
 * SanphamRepository.java
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

@Repository
public interface SanphamRepository extends JpaRepository<Sanpham, Integer>{

}


