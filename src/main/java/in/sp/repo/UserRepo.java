package in.sp.repo;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Repository;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.*;
import in.sp.beans.User;

@Repository
public class UserRepo {

	@Autowired
	JdbcTemplate jdbc;
	
	public int save(User user) {
		String sql ="insert into userTable values(?,?,?,?,?,?)";
		int res=jdbc.update(sql,user.getUsername(),user.getCity(),user.getBirthyear(),user.getHighEdu(),user.getGender(),user.getPassword());
		return res;
	}
	
	public User findByName(String name) {
		String sql="select * from userTable where username=?";
		List<User>list=jdbc.query(sql,new RowMapper<User>() {

			@Override
			public User mapRow(ResultSet rs, int rowNum) throws SQLException {
				// TODO Auto-generated method stub
				User us = new User();
				us.setUsername(rs.getString("username"));
				us.setCity(rs.getString("city"));
				us.setBirthyear(rs.getInt("birthyear"));
				us.setHighEdu(rs.getString("highedu"));
				us.setGender(rs.getString("gender"));
				us.setPassword(rs.getString("password"));
				return us;
			}
			
		},name);
		if(list.size()==0) return null;
		return list.get(0);
	}
}
