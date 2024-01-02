package com.zettamine.isa.service;

import java.sql.SQLException;
import java.util.List;
import java.util.Optional;

import com.zettamine.isa.dao.IsaDao;
import com.zettamine.isa.dao.ScheduleDaoImpl;
import com.zettamine.isa.dto.Schedule;
import com.zettamine.isa.dto.SearchCriteriaImpl;

public class ScheduleSurviceImpl implements IsaService<Schedule, SearchCriteriaImpl> {
	private static IsaDao<Schedule, SearchCriteriaImpl> isaDao;
	@Override
	public Optional<Schedule> get(Integer id) throws SQLException {
		// TODO Auto-generated method stub
		return Optional.empty();
	}

	@Override
	public List<Schedule> getAll() {
		isaDao=new ScheduleDaoImpl();
		List<Schedule> all = isaDao.getAll();
		return all;
	}

	@Override
	public List<Schedule> getBySearchCriteria(SearchCriteriaImpl criteria) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void save(Schedule schedule) {
		isaDao = new ScheduleDaoImpl();
		isaDao.save(schedule);
	}

	@Override
	public void update(Schedule t, String... params) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void delete(Schedule schedule) {
		isaDao = new ScheduleDaoImpl();
		isaDao.delete(schedule);
	}

}
