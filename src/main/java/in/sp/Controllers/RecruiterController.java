package in.sp.Controllers;

import java.net.http.HttpRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

import in.sp.beans.Job;
import in.sp.beans.Recruiter;
import in.sp.service.RecruiterService;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpSession;

@Controller
public class RecruiterController {
	@Autowired
	RecruiterService ser;

	@GetMapping("/openRecruiterLogin")
	public String openLogin() {
		return "recruiterLogin";
	}
	
	@PostMapping("/recuriterProfile")
	public String openProfile(HttpServletRequest rq,Model model,HttpSession session) {
		String mail=rq.getParameter("recuritermail");
		String pass=rq.getParameter("password");
		Recruiter rc = ser.getRecr(mail, pass);
		if(rc==null) {
			model.addAttribute("error","Recruiter not found or Incorrect password");
			return "error";
		}
		session.setAttribute("rec", rc);
		model.addAttribute("rec", rc);
		return "recruiterProfile";
		
	}
	
	@GetMapping("/newRecuriter")
	public String openReg() {
		return "newRecruiter";
	}
	
	@PostMapping("/regisRec")
	public String registered(@ModelAttribute Recruiter rc,Model model) {
		boolean ans =ser.findByMail(rc.getRecuritermail());
		if(ans) {
			model.addAttribute("error","This mail already registered");
			return "error";
		}
		ser.register(rc);
		model.addAttribute("error", "Registeration Successfully");
		return "error";
		
	}
	
	
	
	
}
