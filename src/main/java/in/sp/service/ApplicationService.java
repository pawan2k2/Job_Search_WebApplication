package in.sp.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import in.sp.beans.Application;
import in.sp.repo.ApplicationRepo;
import java.util.*;
@Service
public class ApplicationService {

	@Autowired
	ApplicationRepo repo;
	
	public int checkApp(String id,String name) {
		return repo.check(id, name);
	}
	public int apply(Application app) {
		return repo.save(app);
	}
	public List<Application> appliedJob(String user){
		return repo.appliedJob(user);
	}
	public List<Application> applications(String recmail){
		return repo.applications(recmail);
	}
}
