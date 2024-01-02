package com.zettamine.isa.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import javax.sql.DataSource;

import com.zettamine.isa.config.ConnectionFactory;
import com.zettamine.isa.dto.SearchCriteriaImpl;
import com.zettamine.isa.dto.Skill;

import jakarta.annotation.Resource;

public class SkillDaoImpl implements IsaDao<Skill, SearchCriteriaImpl> {
//	@Resource(name = "jdbc/PostgreSQL")
//    static DataSource ds;
	private static Connection con;
	private static PreparedStatement pst = null;
	
	@Override
	public Optional<Skill> get(Integer id) {
		// TODO Auto-generated method stub
		return Optional.empty();
	}

	@Override
	public List<Skill> getAll() {
		con = ConnectionFactory.getDBConne();
		String select = "select * from isa.skill";
		List<Skill> list = new ArrayList<Skill>();
		try {
			pst = con.prepareStatement(select);
			ResultSet executeQuery = pst.executeQuery();
			while (executeQuery.next()) {
				list.add(new Skill(executeQuery.getInt(1), executeQuery.getString(2)));
			}	
			System.out.println("list");
			return list;
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return null;
	}

	@Override
	public List<Skill> getBySearchCriteria(SearchCriteriaImpl criteria) {
		// TODO Auto-generated method stub
		return null;
	}



	@Override
	public void save(Skill skill) {
		try {
			con = ConnectionFactory.getDBConne();
			pst = con.prepareStatement("insert into isa.skill (skill_desc) values(?)");
			pst.setString(1, skill.getSkillDesc());
			int executeUpdate = pst.executeUpdate();
			System.out.println("Dao "+skill.toString());
			//return executeUpdate;
		}catch(Exception ex) {
			System.out.println(ex.toString());
		}
		//return null;
	}

	@Override
	public void update(Skill skill, String... params) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void delete(Skill skill) {
		//return null;
	}

}
