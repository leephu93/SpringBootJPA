package com.phulv3.springbootjpa.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import com.phulv3.springbootjpa.model.Nhanvien;
import com.phulv3.springbootjpa.service.NhanvienService;

/**
 * NhanvienController.java
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
 * 19-05-2019        	PhuLV3          Create
*/

@Controller
public class NhanvienController {

	@Autowired
	NhanvienService nhanvienservice;

	@RequestMapping(value = "/add-nhanvien", method = RequestMethod.GET)
	public String addNhanvienPage(Model model) {
		model.addAttribute("nhanvien", new Nhanvien());
		return "addNhanvien";
	}

	@RequestMapping(value = "/add-nhanvien", method = RequestMethod.POST)
	public String addNhanvien(@ModelAttribute Nhanvien nhanvien, Model model) {
		if (nhanvienservice.insertEmployeeIntoDB(nhanvien) != null) {
			return "redirect:/";
		} else {
			model.addAttribute("nhanvien", new Nhanvien());
			return "addNhanvien";
		}
	}

	@RequestMapping(value = "/delete-nhanvien/{id}", method = RequestMethod.GET)
	public String deleteNhanvienPage(@PathVariable("id") String id, Model model) {
		model.addAttribute("nhanvien", nhanvienservice.getEmployeeByIdInDB(id));
		return "redirect:/";
	}
	
	@RequestMapping(value = "/delete-nhanvien", method = RequestMethod.POST)
	public String deleteNhanvien(@RequestParam("id") int id) {
		nhanvienservice.deleteEmployeeByIdInDB(id);
		return "redirect:/";
	}
	
	@RequestMapping(value = "/edit-nhanvien/{id}", method = RequestMethod.GET)
	public String editNhanvienPage(@PathVariable("id") String id, Model model) {
		model.addAttribute("nhanvien", nhanvienservice.getEmployeeByIdInDB(id));
		return "redirect:/";
	}
	
	@RequestMapping(value = "/edit-nhanvien", method = RequestMethod.POST)
	public String editNhanvien(@ModelAttribute Nhanvien nhanvien) {
		nhanvienservice.updateEmployeeByIdInDB(nhanvien);
		return "redirect:/";
	}

}
