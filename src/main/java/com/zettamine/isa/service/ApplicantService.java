package com.zettamine.isa.service;

import java.sql.SQLException;
import java.util.List;
import java.util.Optional;

import com.zettamine.isa.dao.ApplicantDaoImpl;
import com.zettamine.isa.dao.IsaDao;
import com.zettamine.isa.dto.Applicant;
import com.zettamine.isa.dto.SearchCriteriaImpl;

public class ApplicantService implements IsaService<Applicant, SearchCriteriaImpl> {

	private static IsaDao<Applicant, SearchCriteriaImpl> isaDao;
	@Override
	public Optional<Applicant> get(Integer id) throws SQLException {
		Optional<Applicant> optional = isaDao.get(id);
		return optional;
	}

	@Override
	public List<Applicant> getAll() {
		isaDao = new ApplicantDaoImpl();
		List<Applicant> list = isaDao.getAll();
		return list;
	}

	@Override
	public List<Applicant> getBySearchCriteria(SearchCriteriaImpl criteria) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void save(Applicant applicant) {
		isaDao = new ApplicantDaoImpl();
		isaDao.save(applicant);
		System.out.println(applicant.toString());
	}

	@Override
	public void update(Applicant applicant, String... params) {
		isaDao = new ApplicantDaoImpl();
		isaDao.update(applicant, params);
	}

	@Override
	public void delete(Applicant applicant) {
		isaDao = new ApplicantDaoImpl();
		isaDao.delete(applicant);
		
	}

}
