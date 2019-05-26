package com.phulv3.springbootjpa.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.phulv3.springbootjpa.model.Sanpham;
import com.phulv3.springbootjpa.repository.SanphamRepository;

/**
 * SanphamController.java
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

@Controller
@RequestMapping("/sanpham")
public class SanphamController {
	
	@Autowired
	SanphamRepository sanphamrepository;
	
	@RequestMapping(value="/", method=RequestMethod.GET)
	public String sanphaPage(Model model) {
		List<Sanpham> listSanpham = sanphamrepository.findAll();
		System.out.println(listSanpham.size());
		return "sanpham";
	}
	
}


