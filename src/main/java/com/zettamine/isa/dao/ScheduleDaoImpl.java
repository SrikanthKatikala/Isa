package com.zettamine.isa.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import com.zettamine.isa.config.ConnectionFactory;
import com.zettamine.isa.dto.Interviewer;
import com.zettamine.isa.dto.Schedule;
import com.zettamine.isa.dto.SearchCriteriaImpl;

public class ScheduleDaoImpl implements IsaDao<Schedule, SearchCriteriaImpl> {

	private static Connection con;
	private static PreparedStatement pst;
	@Override
	public Optional<Schedule> get(Integer id) throws SQLException {
		// TODO Auto-generated method stub
		return Optional.empty();
	}

	@Override
	public List<Schedule> getAll() {
		String getAll = "select * from isa.interview_schedule";
		con=ConnectionFactory.getDBConne();
		try {
			pst= con.prepareStatement(getAll);
			ResultSet rs = pst.executeQuery();
			Schedule schedule = new Schedule();
			List<Schedule> list = new ArrayList<Schedule>();
			while(rs.next()) {
				list.add(new Schedule(rs.getInt(1), rs.getInt(2), rs.getInt(3), rs.getInt(4), rs.getString(5), rs.getString(6), rs.getString(7)));
			}
			return list;
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return null;
	}

	@Override
	public List<Schedule> getBySearchCriteria(SearchCriteriaImpl criteria) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void save(Schedule schedule) {
		String insert = "insert into isa.interview_schedule (applicant_id, interviewer_id, recruiter_id, interview_date, interview_time, status) values (?,?,?,'?'::DATE, '?'::TIME, 'scheduled')";
		con=ConnectionFactory.getDBConne();
		try {
			pst= con.prepareStatement(insert);
			schedule = new Schedule();
			pst.setInt(1, schedule.getApplicantId());
			pst.setInt(2,schedule.getInterviewerId());
			pst.setInt(3, schedule.getRecruiterId());
			pst.setString(4, schedule.getInterviewDate());
			pst.setString(5, schedule.getInterviewTime());
			int num = pst.executeUpdate();
			if (num!=0) {
				System.out.println("scheduled");
			} else {
				System.out.println("I Operation failed");
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}

	@Override
	public void update(Schedule t, String... params) {
		
		
	}

	@Override
	public void delete(Schedule schedule) {
		String delete = "delete from isa.interview_schedule where schedule_id=?";
		con=ConnectionFactory.getDBConne();
		try {
			pst= con.prepareStatement(delete);
			schedule = new Schedule();
			pst.setInt(1, schedule.getScheduleId());
			int num = pst.executeUpdate();
			if (num!=0) {
				System.out.println("deleted");
			} else {
				System.out.println(" D Operation failed");
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}

}
