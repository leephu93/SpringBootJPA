package com.phulv3.springbootjpa.service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import com.phulv3.springbootjpa.model.Nhanvien;
import com.phulv3.springbootjpa.model.XE;
import com.phulv3.springbootjpa.repository.NhanvienRepository;

@Service
public class NhanvienService {
	
	@Autowired
	NhanvienRepository nhanvienrepository;

	public List<Nhanvien> getAllEmployeeInDB(){
		return nhanvienrepository.findAll(new Sort(Sort.Direction.ASC, "id"));
	}
	
	public Nhanvien insertEmployeeIntoDB(Nhanvien nhanvien) {
		List<XE> listXe = new ArrayList<XE>();
		listXe.add(new XE("Yamaha Noza 2019"));
		listXe.add(new XE("Yamaha Grande 2019"));
		nhanvien.setListXe(listXe);
		return nhanvienrepository.save(nhanvien);
	}
	
	public Nhanvien getEmployeeByIdInDB(String id) {
		try {
			int idChoiced = Integer.parseInt(id);
			return nhanvienrepository.findById(idChoiced).get();
		} catch (Exception e) {
			e.printStackTrace();
		}
		return null;
	}
	
	public Boolean deleteEmployeeByIdInDB(Integer id) {
		if(id != null) {
			nhanvienrepository.deleteById(id);
			return true;
		}
		else {
			return false;
		}
	}
	
	public Boolean updateEmployeeByIdInDB(Nhanvien nhanvien) {
		if(nhanvien != null) {
			nhanvienrepository.saveAndFlush(nhanvien);
			return true;
		}
		else {
			return false;
		}
	}
	
}
