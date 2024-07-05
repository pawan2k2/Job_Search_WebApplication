package in.sp.repo;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Repository;

import in.sp.beans.Job;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.*;
@Repository
public class JobRepo {

	@Autowired
	JdbcTemplate jdbc;
	
	public int save(Job job) {
		String sql="insert into jobs values(?,?,?,?,?,?)";
		return jdbc.update(sql,job.getJob_title(),job.getJob_id(),job.getJob_desc(),job.getCompany(),job.getStipend(),job.getRecruitermail());
	}
	
	public List<Job> findAllJob() {
		String sql="select * from jobs";
		List<Job> joblist=jdbc.query(sql, new RowMapper<Job>() {

			@Override
			public Job mapRow(ResultSet rs, int rowNum) throws SQLException {
				// TODO Auto-generated method stub
				Job job= new Job();
				job.setJob_title(rs.getString("job_title"));
				job.setJob_id(rs.getString("job_id"));
				job.setJob_desc(rs.getString("job_desc"));
				job.setCompany(rs.getString("company"));
				job.setStipend(rs.getString("stipend"));
				job.setRecruitermail(rs.getString("recruitermail"));
				return job;
				
			}
			
		});
		System.out.println("no of jobs :"+joblist.size());
		return joblist;
	}
	
	public Job job(String id) {
		String sql="select * from jobs where job_id=?";
		List<Job> list=jdbc.query(sql,new RowMapper<Job>() {

			@Override
			public Job mapRow(ResultSet rs, int rowNum) throws SQLException {
				// TODO Auto-generated method stub
				Job j = new Job();
				j.setJob_title(rs.getString("job_title"));
				j.setJob_id(rs.getString("job_id"));
				j.setJob_desc(rs.getString("job_desc"));
				j.setCompany(rs.getString("company"));
				j.setStipend(rs.getString("stipend"));
				j.setRecruitermail(rs.getString("recruitermail"));
				return j;
			}
			
		},id);
		return list.get(0);
	}
	public List<Job> findParticularRecJob(String mail){
		String sql="select * from jobs where recruitermail=?";
		List<Job> joblist=jdbc.query(sql, new RowMapper<Job>() {

			@Override
			public Job mapRow(ResultSet rs, int rowNum) throws SQLException {
				// TODO Auto-generated method stub
				Job job= new Job();
				job.setJob_title(rs.getString("job_title"));
				job.setJob_id(rs.getString("job_id"));
				job.setJob_desc(rs.getString("job_desc"));
				job.setCompany(rs.getString("company"));
				job.setStipend(rs.getString("stipend"));
				job.setRecruitermail(rs.getString("recruitermail"));
				return job;
				
			}
			
		},mail);
		return joblist;
		
	}
	public int removeJob(String id) {
		String sql="delete from jobs where job_id=?";
		return jdbc.update(sql,id);
	}
}
