package in.sp.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import in.sp.beans.Recruiter;
import in.sp.repo.RecruiterRepo;

@Service
public class RecruiterService {
	@Autowired
	RecruiterRepo repo;
	
	public int register(Recruiter rc) {
		return repo.save(rc);
	}
	public boolean findByMail(String mail) {
		Recruiter rc = repo.findByMail(mail);
		if(rc==null) {
			return false;
		}
		return true;
	}
	public Recruiter getRecr(String mail,String pass) {
		Recruiter rc= repo.findByMail(mail);
		if(rc!=null && rc.getPassword().equals(pass)) {
			return rc;
		}
		return null;
		
	}

}
