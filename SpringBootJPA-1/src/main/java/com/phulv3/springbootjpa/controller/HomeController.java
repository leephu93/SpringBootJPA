package com.phulv3.springbootjpa.controller;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import com.phulv3.springbootjpa.model.Nhanvien;
import com.phulv3.springbootjpa.model.Sanpham;
import com.phulv3.springbootjpa.repository.NhanvienRepository;
import com.phulv3.springbootjpa.repository.SanphamRepository;
import com.phulv3.springbootjpa.service.NhanvienService;

/**
 * HomeController.java
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

@Controller
public class HomeController {

	@Autowired
	NhanvienService nhanvienservice;

	@RequestMapping(value = "/", method = RequestMethod.GET)
	public String homePage(Model model) {
		List<Nhanvien> listNhanvien = nhanvienservice.getAllEmployeeInDB();
		model.addAttribute("listNhanvien", listNhanvien);
		return "home";
	}

//	@RequestMapping(value = "/test", method = RequestMethod.GET)
//	@ResponseBody
//	public String testPage(Model model) {
//		List<Sanpham> listSanpham = new ArrayList<Sanpham>();
//		listSanpham.add(new Sanpham("Chả Lụa", 25000f, 45, null));
//		listSanpham.add(new Sanpham("Giày BiTis", 55600f, 67, null));
//		listSanpham.add(new Sanpham("Nón Lá", 78000f, 47, null));
//		sanphamrepository.saveAll(listSanpham);
//		Nhanvien nv1 = new Nhanvien("Hồ Thị Bích Loan", 31, "0126555544", null, listSanpham);
//		Nhanvien nv2 = new Nhanvien("Tô Ánh Nguyệt", 25, "0523535555", null, listSanpham);
//		List<Nhanvien> listNhanvien = new ArrayList<Nhanvien>();
//		listNhanvien.add(nv1);
//		listNhanvien.add(nv2);
//		nhanvienrepository.saveAll(listNhanvien);
//		return "OKAY";
//	}

}
