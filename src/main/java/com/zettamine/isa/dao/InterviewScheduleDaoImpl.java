package com.zettamine.isa.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.zettamine.isa.config.ConnectionFactory;
import com.zettamine.isa.dto.InterviewSchedule;

public class InterviewScheduleDaoImpl {

public List<InterviewSchedule> getAll() {
		Connection con =  ConnectionFactory.getDBConne();
		String select = "select * from isa.schedule_view";
		try {
			PreparedStatement pst = con.prepareStatement(select);
			ResultSet rs = pst.executeQuery();
			List<InterviewSchedule> list = new ArrayList<InterviewSchedule>();
			while(rs.next()) {
				list.add(new InterviewSchedule(rs.getInt(1), rs.getString(2), rs.getString(3), rs.getString(4), rs.getString(5), rs.getString(6), rs.getString(7)));
			}
			return list;
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
		return null;
	}
}
