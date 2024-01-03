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
import com.zettamine.isa.dto.SearchCriteriaImpl;
import com.zettamine.isa.dto.Skill;

public class ApplicantDaoImpl implements IsaDao<Applicant, SearchCriteriaImpl> {
	private static Connection con;
	private static PreparedStatement pst;
	@Override
	public Optional<Applicant> get(Integer id) throws SQLException {
		
		return Optional.empty();
	}

	@Override
	public List<Applicant> getAll() {
		con=ConnectionFactory.getDBConne();
		String getAll = "select * from isa.applicant";
		try {
			pst= con.prepareStatement(getAll);
			ResultSet rs = pst.executeQuery();
			List<Applicant> list = new ArrayList<Applicant>();
			while(rs.next()) {
				list.add(new Applicant(rs.getInt(1), rs.getString(2), rs.getString(3), rs.getString(4), rs.getString(5), rs.getString(6), rs.getInt(7)));
			}
			return list;
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return null;
	}

	@Override
	public List<Applicant> getBySearchCriteria(SearchCriteriaImpl criteria) {
		con=ConnectionFactory.getDBConne();
		String get = "select * from isa.applicant where applicant_id=?";
		try {
			Integer applicantId = criteria.getApplicantId();
			pst= con.prepareStatement(get);
			pst.setInt(1, applicantId);
			ResultSet rs = pst.executeQuery();
			List<Applicant> list = new ArrayList<Applicant>();
			if(rs.next()) {
				list.add(new Applicant(rs.getInt(1), rs.getString(2), rs.getString(3), rs.getString(4), rs.getString(5), rs.getString(6), rs.getInt(7)));
			}
			return list;
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return null;
	}

	@Override
	public void save(Applicant applicant) {
		con = ConnectionFactory.getDBConne();
		String insert = "insert into isa.applicant(applicant_name, email, phone_number, highest_qualification, applicant_remarks, primary_skill) values(?,?,?,?,?,?)";
		
		try {
			pst = con.prepareStatement(insert);
			pst.setString(1, applicant.getApplicantName());
			pst.setString(2, applicant.getEmail());
			pst.setString(3, applicant.getPhoneNumber());
			pst.setString(4, applicant.getHighestQualification());
			pst.setString(5, applicant.getApplicantRemarks());
			pst.setInt(6, applicant.getPrimarySkill());
			int rs = pst.executeUpdate();
			if (rs!=0) {
				System.out.println("data inserted");
			} else {
				System.out.println("data not inserted");
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}

	@Override
	public void update(Applicant applicant, String... params) {
		String aplId = params[0];
		Integer id = Integer.parseInt(aplId);
		con=ConnectionFactory.getDBConne();
		String update = "update isa.applicant set applicant_name=?, email=?, phone_number=?, highest_qualification=? ,applicant_remarks=?, primary_skill=? where applicant_id=?";
		try{
			pst=con.prepareStatement(update);
			pst.setString(1, applicant.getApplicantName());
			pst.setString(2, applicant.getEmail());
			pst.setString(3, applicant.getPhoneNumber());
			pst.setString(4, applicant.getHighestQualification());
			pst.setString(5, applicant.getApplicantRemarks());
			pst.setInt(6, applicant.getPrimarySkill());
			pst.setInt(7, id);
			ResultSet rs = pst.executeQuery();
			if (rs.next()) {
				System.out.println("data inserted");
			} else {
				System.out.println("failed");
			}
		}catch(Exception e){
			e.printStackTrace();
		}
		
	}

	@Override
	public void delete(Applicant applicant) {
		con=ConnectionFactory.getDBConne();
		String delete = "delete from isa.applicant where applicant_id =?";
		try {
			pst= con.prepareStatement(delete);
		
			pst.setInt(1, applicant.getApplicantId());
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

}
