package in.sp.repo;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Repository;

import in.sp.beans.Application;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.*;
@Repository
public class ApplicationRepo {

	@Autowired
	JdbcTemplate jdbc;
	
	public int save(Application app) {
		String sql="insert into application values(?,?,?,?,?,?)";
		int res=jdbc.update(sql,app.getJob_id(),app.getApplicant_name(),app.getRecruiter_mail(),app.getJob_title(),app.getGender(),app.getHigh_edu());
		return  res;
	}
	
	public int check(String job_id,String applicant_name) {
		String sql="select * from application where job_id=? and applicant_name=?";
		List<Application> list=jdbc.query(sql, new RowMapper<Application>() {

			@Override
			public Application mapRow(ResultSet rs, int rowNum) throws SQLException {
				// TODO Auto-generated method stub
				Application app=new Application();
				app.setJob_id(rs.getString("job_id"));
				app.setApplicant_name(rs.getString("applicant_name"));
				app.setGender(rs.getString("gender"));
				app.setHigh_edu(rs.getString("high_edu"));
				app.setJob_title(rs.getString("job_title"));
				app.setRecruiter_mail(rs.getString("recruiter_mail"));
				return app;
			}
			
		},job_id,applicant_name);
		return list.size();
	}
	public List<Application> appliedJob(String user){
		String sql="select * from application where applicant_name=?";
		List<Application> list=jdbc.query(sql, new RowMapper<Application>() {

			@Override
			public Application mapRow(ResultSet rs, int rowNum) throws SQLException {
				// TODO Auto-generated method stub
				Application app=new Application();
				app.setJob_id(rs.getString("job_id"));
				app.setApplicant_name(rs.getString("applicant_name"));
				app.setGender(rs.getString("gender"));
				app.setHigh_edu(rs.getString("high_edu"));
				app.setJob_title(rs.getString("job_title"));
				app.setRecruiter_mail(rs.getString("recruiter_mail"));
				return app;
			}
			
		},user);
		return list;
	}
	
	public List<Application> applications(String recmail){
		String sql="select * from application where recruiter_mail=?";
		List<Application> list=jdbc.query(sql, new RowMapper<Application>() {

			@Override
			public Application mapRow(ResultSet rs, int rowNum) throws SQLException {
				// TODO Auto-generated method stub
				Application app=new Application();
				app.setJob_id(rs.getString("job_id"));
				app.setApplicant_name(rs.getString("applicant_name"));
				app.setGender(rs.getString("gender"));
				app.setHigh_edu(rs.getString("high_edu"));
				app.setJob_title(rs.getString("job_title"));
				app.setRecruiter_mail(rs.getString("recruiter_mail"));
				return app;
			}
			
		},recmail);
		return list;
	}
}
