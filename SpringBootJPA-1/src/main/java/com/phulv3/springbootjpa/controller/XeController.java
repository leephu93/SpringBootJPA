package com.phulv3.springbootjpa.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.phulv3.springbootjpa.model.Nhanvien;
import com.phulv3.springbootjpa.model.XE;
import com.phulv3.springbootjpa.repository.NhanvienRepository;
import com.phulv3.springbootjpa.repository.XeRepository;

/**
 * XeController.java
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
@RequestMapping("/xe")
public class XeController {
	
	@Autowired
	XeRepository xerepository;
	
	@Autowired
	NhanvienRepository nhanvienrepository;
	
	@RequestMapping(value="/{id}", method=RequestMethod.GET)
	public String xePage(@PathVariable("id") String id, Model model) {
		try {
			int idChoiced = Integer.parseInt(id);
			Nhanvien nhanvien = nhanvienrepository.findById(idChoiced).get();
			List<XE> listXe = nhanvien.getListXe();
			model.addAttribute("listXe", listXe);
			return "xe";
		} catch (Exception e) {
//			e.printStackTrace();
		}
		return "redirect:/";
	}
	
}


