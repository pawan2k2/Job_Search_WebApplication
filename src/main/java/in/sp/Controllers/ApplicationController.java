package in.sp.Controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

import in.sp.beans.Application;
import in.sp.beans.User;
import in.sp.service.ApplicationService;
import jakarta.servlet.http.HttpSession;
import java.util.*;
@Controller
public class ApplicationController {
	
	@Autowired
	ApplicationService ser;

	@GetMapping("/jobs/apply/{id}/{recmail}/{job_title}")
	public String apply(HttpSession session, Model model,@PathVariable("id") String job_id,@PathVariable("recmail") String mail,@PathVariable("job_title") String job_title) {
		User us=(User)session.getAttribute("user");
		
		int res=ser.checkApp(job_id, us.getUsername());
		if(res!=0) {
			model.addAttribute("error","Already applied");
		}
		else {
			Application app=new Application();
			app.setApplicant_name(us.getUsername());
			app.setJob_id(job_id);
			app.setGender(us.getGender());
			app.setHigh_edu(us.getHighEdu());
			app.setJob_title(job_title);
			app.setRecruiter_mail(mail);
			
			ser.apply(app);
			model.addAttribute("error","Applied Successuly .");
		}
		return"error";
	}
	
	@GetMapping("/appliedJob/{user}")
	public String applied(@PathVariable("user") String user,Model model) {
		List<Application> list =ser.appliedJob(user);
		if(list.isEmpty()) {
			model.addAttribute("error","Yet No job applied");
			return "error";
		}
		model.addAttribute("apps", list);
		return "appliedJob";
	}
	
	@GetMapping("/applications/{recmail}")
	public String applications(@PathVariable("recmail")String mail,Model model) {
		List<Application> app=ser.applications(mail);
		if(app.isEmpty()) {
			model.addAttribute("error","No Application received yet");
			return "error";
		}
		model.addAttribute("apps", app);
		return "applications";
	}
}
