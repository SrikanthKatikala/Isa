package com.zettamine.isa.service;

import java.util.List;
import java.util.Optional;

import com.zettamine.isa.dao.IsaDao;
import com.zettamine.isa.dto.SearchCriteria;
import com.zettamine.isa.dto.SearchCriteriaImpl;
import com.zettamine.isa.dto.Skill;
import com.zettamine.isa.dao.*;

public class SkillServiceImpl implements IsaService<Skill, SearchCriteriaImpl> {

	public static IsaDao<Skill, SearchCriteriaImpl> isaDao;
	
	
	public Optional<Skill> get(Integer id) {
		// TODO Auto-generated method stub
		return Optional.empty();
	}

	@Override
	public List<Skill> getAll() {
		isaDao = new SkillDaoImpl();
		List<Skill> all = isaDao.getAll();
		return all;
	}

	@Override
	public List<Skill> getBySearchCriteria(SearchCriteriaImpl criteria) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void save(Skill skill) {
		isaDao = new SkillDaoImpl();
		isaDao.save(skill);
		System.out.println("Service  "+skill.toString());
		//return save;
	}

	@Override
	public void update(Skill t, String... params) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void delete(Skill t) {
		// TODO Auto-generated method stub
		
	}


	
}
