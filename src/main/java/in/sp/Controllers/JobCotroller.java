package in.sp.Controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

import in.sp.beans.Job;
import in.sp.beans.Recruiter;
import in.sp.service.Jobser;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpSession;

import java.util.*;
@Controller
public class JobCotroller {

	@Autowired
	Jobser ser;
	
	@GetMapping("/jobs")
	public String jobs(Model model) {
		List<Job> jb= ser.findJobs();
		if(jb.isEmpty()) {
			model.addAttribute("error","No job Found");
			return "error";
		}
		model.addAttribute("jobs", jb);
		return "jobs";
	}
	
	@GetMapping("/jobs/{id}")
	public String openJob(Model model,@PathVariable("id") String id) {
		Job job =ser.job(id);
		model.addAttribute("job",job);
		return "jobDetail";
	}
	@GetMapping("/newJobPost")
	public String openJobForm() {
		return "newJob";
	}
	
	@PostMapping("/addJob")
	public String addJob(HttpSession session,HttpServletRequest rq,Model model) {
		Recruiter rec=(Recruiter)session.getAttribute("rec");
		
		String job_title=rq.getParameter("job_title");
		String job_id=rq.getParameter("job_id");
		String job_desc=rq.getParameter("job_desc");
		String company=rq.getParameter("company");
		String stipend=rq.getParameter("stipend");
		String recruitermail=rec.getRecuritermail();
		
		Job job =new Job();
		job.setJob_title(job_title);
		job.setJob_id(job_id);
		job.setJob_desc(job_desc);
		job.setStipend(stipend);
		job.setCompany(company);
		job.setRecruitermail(recruitermail);
		ser.add(job);
		model.addAttribute("error","Job Posted Successfully");
		
		return "error";
	}
	
	@GetMapping("/jobsOfParticularRecruiter")
	public String jobsRec(HttpSession session,Model model) {
		Recruiter rc =(Recruiter) session.getAttribute("rec");
		List<Job>list=ser.findRecJobs(rc.getRecuritermail());
		if(list.isEmpty()) {
			model.addAttribute("error","No job Found");
			return "error";
		}
		model.addAttribute("jobs", list);
		return "recJobs";
	}
	
	@GetMapping("/removeJobs")
	public String remove(HttpSession session,Model model) {
		Recruiter rc =(Recruiter) session.getAttribute("rec");
		List<Job>list=ser.findRecJobs(rc.getRecuritermail());
		if(list.isEmpty()) {
			model.addAttribute("error","No job Found");
			return "error";
		}
		model.addAttribute("jobs", list);
		return"removeJob";
	}
	
	@GetMapping("/removejob/{id}")
	public String removeJob(@PathVariable("id") String id,Model model) {
		ser.removeJob(id);
		model.addAttribute("error", "Job Delete Successfully");
		return "error";
	}
}
