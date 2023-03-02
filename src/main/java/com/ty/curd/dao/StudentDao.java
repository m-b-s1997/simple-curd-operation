package com.ty.curd.dao;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Query;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.ty.curd.dto.CurdDto;

@Repository
public class StudentDao {

	@Autowired
	private EntityManagerFactory factory;

	public CurdDto saveStudent(CurdDto dto1) {
		EntityManager manager = factory.createEntityManager();
		EntityTransaction transaction = manager.getTransaction();

		try {
			transaction.begin();
			manager.persist(dto1);
			transaction.commit();
			return dto1;
		} catch (Exception e) {
			e.printStackTrace();
			transaction.rollback();
			return null;
		}

	}

	public boolean validateLogin(int id, String password) {
		EntityManager manager = factory.createEntityManager();
		Query query = manager.createQuery("FROM CurdDto WHERE studentId=?1 and password=?2");
		query.setParameter(1, id);
		query.setParameter(2, password);
		List<CurdDto> list = query.getResultList();
		
		return !list.isEmpty();
	}

	public List<CurdDto> getAllStudent() {
		EntityManager manager = factory.createEntityManager();
		Query query = manager.createQuery("FROM CurdDto");
		List<CurdDto> list = query.getResultList();
		return list;
	}

	public CurdDto searchStudent(int id) {
		EntityManager manager = factory.createEntityManager();
		
		return manager.find(CurdDto.class,id);
	}

	public CurdDto deleteEmployee(CurdDto allStudent) {
		
		EntityManager manager = factory.createEntityManager();
		EntityTransaction transaction = manager.getTransaction();
		
		try {
			transaction.begin();
			CurdDto dto= manager.merge(allStudent);
			manager.remove(dto);
			transaction.commit();
			return dto;
		} catch (Exception e) {
			e.printStackTrace();
			transaction.rollback();
			return null;
		}	
		
	}

	public CurdDto updateStudent(CurdDto dto1) {
		EntityManager manager = factory.createEntityManager();
		EntityTransaction transaction = manager.getTransaction();
		
		try {
			transaction.begin();
			manager.merge(dto1);
			transaction.commit();
			return dto1;
		} catch (Exception e) {
			e.printStackTrace();
			transaction.rollback();
			return null;
		}
	}

	}

