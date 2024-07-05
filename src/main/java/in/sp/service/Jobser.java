package in.sp.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import in.sp.beans.Job;
import in.sp.repo.JobRepo;
import java.util.*;
@Service
public class Jobser {
	
	@Autowired
	JobRepo repo;
	public int add(Job job) {
		return repo.save(job);
	}
	public List<Job> findJobs(){
		return repo.findAllJob();
	}
	
	public Job job(String id) {
		return repo.job(id);
	}
	public List<Job> findRecJobs(String mail){
		return repo.findParticularRecJob(mail);
	}
	
	public int removeJob(String id) {
		return repo.removeJob(id);
	}

}
