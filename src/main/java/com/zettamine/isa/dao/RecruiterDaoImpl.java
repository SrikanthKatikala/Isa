package com.zettamine.isa.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import com.zettamine.isa.config.ConnectionFactory;
import com.zettamine.isa.dto.Recruiter;
import com.zettamine.isa.dto.SearchCriteria;
import com.zettamine.isa.dto.SearchCriteriaImpl;


public class RecruiterDaoImpl implements IsaDao<Recruiter, SearchCriteriaImpl> {
	private static Connection con;
	private static PreparedStatement pst;
	
	
	@Override
	public Optional<Recruiter> get(Integer id) throws SQLException {
		
		return Optional.empty();
	}

	@Override
	public List<Recruiter> getAll() {
		
		return null;
	}

	@Override
	public List<Recruiter> getBySearchCriteria(SearchCriteriaImpl criteria)  {
		String select ="select * from isa.recruiter where user_name=? and user_password=?";
		List<Recruiter> list = new ArrayList<Recruiter>();
		try {
			con = ConnectionFactory.getDBConne();
			pst = con.prepareStatement(select);
			pst.setString(1, criteria.getUserName());
			pst.setString(2, criteria.getUserPassword());
			ResultSet resultSet = pst.executeQuery();
			
			while (resultSet.next()) {
				Recruiter recruiter = new Recruiter();
				recruiter.setRecruiterId(resultSet.getInt("recruiter_id"));
				recruiter.setUserName(resultSet.getString("user_name"));
				list.add(recruiter);
			} 
		}
		catch(Exception e) {
			e.printStackTrace();
		}
		return list;
	}

	@Override
	public void save(Recruiter recruiter) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void update(Recruiter recruiter, String... params) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void delete(Recruiter recruiter) {
		// TODO Auto-generated method stub
		
	}

}
