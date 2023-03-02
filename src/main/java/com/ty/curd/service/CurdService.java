package com.ty.curd.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ty.curd.dao.StudentDao;
import com.ty.curd.dto.CurdDto;

@Service
public class CurdService {
	@Autowired
	private StudentDao dao;
	

	public CurdDto saveStudent(CurdDto dto) {
		CurdDto dto1=new CurdDto();
		dto1.setName(dto.getName());
		dto1.setAge(dto.getAge());
		dto1.setMbl(dto.getMbl());
		dto1.setPassword(dto.getPassword());
		
		return dao.saveStudent(dto1);
	}


	public boolean validateLogin(int id, String password) {
		return dao.validateLogin(id,password);
	}


	public CurdDto getAllStudent(int id) {
		// TODO Auto-generated method stub
		return null;
	}


	public List<CurdDto> getAllStudent() {
		return dao.getAllStudent();
	}


	public CurdDto deleteStudent(int id) {
		CurdDto allStudent=dao.searchStudent(id);
		if (allStudent==null) {
			return null;
		}else {
			return dao.deleteEmployee(allStudent);
		}
	}


	public CurdDto searchTrain(int id) {
		return dao.searchStudent(id);
	}


	public CurdDto updateTrain(int id, CurdDto dto) {
		CurdDto dto1=new CurdDto();
		dto1.setStudentId(dto.getStudentId());
		dto1.setName(dto.getName());
		dto1.setAge(dto.getAge());
		dto1.setMbl(dto.getMbl());
		dto1.setPassword(dto.getPassword());
		return dao.updateStudent(dto1);
	}


	
}
