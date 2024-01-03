package com.zettamine.isa.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import com.zettamine.isa.config.ConnectionFactory;
import com.zettamine.isa.dto.Applicant;
import com.zettamine.isa.dto.Interviewer;
import com.zettamine.isa.dto.SearchCriteriaImpl;

public class InterviewerDaoImpl implements IsaDao<Interviewer, SearchCriteriaImpl> {

	private static Connection con;
	private static PreparedStatement pst;
	@Override
	public Optional<Interviewer> get(Integer id) throws SQLException {
		
		return Optional.empty();
	}

	@Override
	public List<Interviewer> getAll() {
		con=ConnectionFactory.getDBConne();
		String getAll = "select * from isa.interviewer";
		try {
			pst= con.prepareStatement(getAll);
			ResultSet rs = pst.executeQuery();
			List<Interviewer> list = new ArrayList<Interviewer>();
			while(rs.next()) {
				list.add(new Interviewer(rs.getInt(1), rs.getString(2), rs.getString(3), rs.getString(4), rs.getInt(5)));
			}
			return list;
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return null;
	}

	@Override
	public List<Interviewer> getBySearchCriteria(SearchCriteriaImpl criteria) {
		
		con=ConnectionFactory.getDBConne();
		String get = "select * from isa.interviewer where interviewer_id =?";
		try {
			pst= con.prepareStatement(get);
			pst.setInt(1, criteria.getInterviewerId());
			ResultSet rs = pst.executeQuery();
			List<Interviewer> list = new ArrayList<Interviewer>();
			if(rs.next()) {
				System.out.println("im nside");
				list.add(new Interviewer(rs.getInt(1), rs.getString(2), rs.getString(3), rs.getString(4), rs.getInt(5)));
			}
			return list;
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return null;
	}

	@Override
	public void save(Interviewer interviewer) {
		con=ConnectionFactory.getDBConne();
		String insert = "insert into isa.interviewer(interviewer_name, email, phone_number, primary_skill) values (?,?,?,?)";
		try {
			pst= con.prepareStatement(insert);
			pst.setString(1, interviewer.getInterviewerName());
			pst.setString(2, interviewer.getEmail());
			pst.setString(3, interviewer.getPhoneNumber());
			pst.setInt(4, interviewer.getPrimarySkill());
			int num = pst.executeUpdate();
			if (num!=0) {
				System.out.println("data inserted");
			} else {
				System.out.println("No data Inserted");
			}
			
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
	}

	@Override
	public void update(Interviewer interviewer , String... params) {
		System.out.println(interviewer);
		con=ConnectionFactory.getDBConne();
		String update = "update isa.interviewer set interviewer_name= ?, email = ?, phone_number=?, primary_skill=? where interviewer_id =?";
		try {
			pst= con.prepareStatement(update);
			Integer id = Integer.parseInt(params[0]);
			pst.setString(1, interviewer.getInterviewerName());
			pst.setString(2, interviewer.getEmail());
			pst.setString(3, interviewer.getPhoneNumber());
			pst.setInt(4, interviewer.getPrimarySkill());
			pst.setInt(5, id);
			int num = pst.executeUpdate();
			if (num!=0) {
				System.out.println("data updated");
			} else {
				System.out.println("No data updated");
			}
			
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
	}

	@Override
	public void delete(Interviewer interviewer) {
		con=ConnectionFactory.getDBConne();
		String delete = "delete from isa.interviewer where interviewer_id =?";
		try {
			pst= con.prepareStatement(delete);
		
			pst.setInt(1, interviewer.getInterviewerId());
			int num = pst.executeUpdate();
			if (num!=0) {
				System.out.println("data deleted");
			} else {
				System.out.println("No data deleted");
			}
			
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
	
	public List<Interviewer> getInterviewerByApplicantId(Integer id){
		
		String select = "select * from isa.interviewer where primary_skill In (select primary_skill from isa.applicant where applicant_id=?)";
		con=ConnectionFactory.getDBConne();
		try {
			pst= con.prepareStatement(select);
			pst.setInt(1, id);
			ResultSet rs = pst.executeQuery();
			List<Interviewer> list = new ArrayList<Interviewer>();
			while(rs.next()) {
				list.add(new Interviewer(rs.getInt(1), rs.getString(2), rs.getString(3), rs.getString(4), rs.getInt(5)));
			}
			return list;
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return null;
	}

}
