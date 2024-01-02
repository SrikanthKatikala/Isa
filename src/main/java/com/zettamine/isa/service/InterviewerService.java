package com.zettamine.isa.service;

import java.sql.SQLException;
import java.util.List;
import java.util.Optional;

import com.zettamine.isa.dao.InterviewerDaoImpl;
import com.zettamine.isa.dao.IsaDao;
import com.zettamine.isa.dto.Interviewer;
import com.zettamine.isa.dto.SearchCriteriaImpl;

public class InterviewerService implements IsaService<Interviewer, SearchCriteriaImpl> {
	private static IsaDao<Interviewer, SearchCriteriaImpl> isaDao;
	@Override
	public Optional<Interviewer> get(Integer id) throws SQLException {
		
		return Optional.empty();
	}

	@Override
	public List<Interviewer> getAll() {
		isaDao = new InterviewerDaoImpl();
		List<Interviewer> all = isaDao.getAll();
		return all;
	}

	@Override
	public List<Interviewer> getBySearchCriteria(SearchCriteriaImpl criteria) {
		isaDao = new InterviewerDaoImpl();
		List<Interviewer> list = isaDao.getBySearchCriteria(criteria);
		return list;
	}

	@Override
	public void save(Interviewer inteviewer) {
		isaDao = new InterviewerDaoImpl();
		isaDao.save(inteviewer);
	}

	@Override
	public void update(Interviewer inteviewer, String... params) {
		isaDao = new InterviewerDaoImpl();
		isaDao.update(inteviewer, params);
	}

	@Override
	public void delete(Interviewer inteviewer) {
		isaDao = new InterviewerDaoImpl();
		isaDao.delete(inteviewer);
	}
	 
	public List<Interviewer> getInterviewerByApplicantId(Integer id){
		InterviewerDaoImpl daoImpl = new InterviewerDaoImpl();
		List<Interviewer> list = daoImpl.getInterviewerByApplicantId(id);
		return list;
		
	}
}
