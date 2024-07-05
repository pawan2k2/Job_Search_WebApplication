package in.sp.repo;

import java.sql.ResultSet;
import java.sql.SQLException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Repository;

import in.sp.beans.Recruiter;
import java.util.*;

@Repository
public class RecruiterRepo {

	@Autowired
	JdbcTemplate jdbc;
	
	public int save(Recruiter rec) {
		String sql="insert into recuriter values(?,?)";
		return jdbc.update(sql,rec.getRecuritermail(),rec.getPassword());
	}
	
	public Recruiter findByMail(String mail) {
		String sql="select * from recuriter where recuritermail=?";
		List<Recruiter>list=jdbc.query(sql, new RowMapper<Recruiter>() {

			@Override
			public Recruiter mapRow(ResultSet rs, int rowNum) throws SQLException {
				// TODO Auto-generated method stub
				Recruiter rc = new Recruiter();
				rc.setRecuritermail(rs.getString("recuritermail"));
				rc.setPassword(rs.getString("password"));
				
				return rc;
			}
			
		},mail);
		if(list.size()==0) return null;
		return list.get(0);
		
	}
}
