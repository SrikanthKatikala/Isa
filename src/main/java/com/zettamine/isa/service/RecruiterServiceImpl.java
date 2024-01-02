package com.zettamine.isa.service;

import java.sql.SQLException;
import java.util.List;
import java.util.Optional;

import com.zettamine.isa.dao.IsaDao;
import com.zettamine.isa.dao.RecruiterDaoImpl;
import com.zettamine.isa.dto.Recruiter;
import com.zettamine.isa.dto.SearchCriteria;
import com.zettamine.isa.dto.SearchCriteriaImpl;

public class RecruiterServiceImpl implements IsaService {
	public static IsaDao<Recruiter, SearchCriteriaImpl> isaDao;
	
	
	
	@Override
	public Optional get(Integer id) {
		
		
		return null;
	}

	@Override
	public List getAll() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List getBySearchCriteria(SearchCriteriaImpl criteria) {
		isaDao= new RecruiterDaoImpl();
		List<Recruiter>  list= isaDao.getBySearchCriteria(criteria);
		return list;
	}

	@Override
	public void save(Object t) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void update(Object t, String... params) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void delete(Object t) {
		// TODO Auto-generated method stub
		
	}

}
