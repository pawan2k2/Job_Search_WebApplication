package in.sp.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import in.sp.beans.User;
import in.sp.repo.UserRepo;

@Service
public class UserService {
	@Autowired
	UserRepo repo;
	
	public int register(User user) {
		return repo.save(user);
	}
	
	public boolean checkUser(String username) {
		User user =repo.findByName(username);
		if(user==null) return false;
		return true;
	}
	
	public User getUser(String username,String password) {
		User us = repo.findByName(username);
		if(us!=null && us.getPassword().equals(password)) {
			return us;
		}
		return null;
	}

}
