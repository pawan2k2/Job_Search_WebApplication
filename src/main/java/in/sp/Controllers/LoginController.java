package in.sp.Controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

import in.sp.beans.User;
import in.sp.service.UserService;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpSession;

@Controller
public class LoginController {
	
	@Autowired
	UserService serve;

	@GetMapping("/openlogin")
	public String openLoginPage() {
		return "login";
	}
	
	@GetMapping("/newRegistration")
	public String openRegisForm() {
		return "registration";
	}
	
	@PostMapping("/register")
	public String register(@ModelAttribute User user,Model model) {
		boolean check=serve.checkUser(user.getUsername());
		if(check) {
			model.addAttribute("error","This username already taken");
			return "error";
		}
		serve.register(user);
		model.addAttribute("user", user);
		return "registered";
	}
	
	@PostMapping("/profile")
	public String openProfile(HttpServletRequest rq,Model model,HttpSession session) {
		String username=rq.getParameter("username");
		String password=rq.getParameter("password");
		User us=serve.getUser(username, password);
		if(us==null) {
			model.addAttribute("error","user not found Or incorrect password");
			return "error";
		}
		session.setAttribute("user", us);
		model.addAttribute("user", us);
		
		return "profile";
	}
	
	@GetMapping("/profiledetail")
	public String deatil(HttpSession session,Model model) {
		User user=(User)session.getAttribute("user");
		if(user==null) return "profile";
	model.addAttribute("user", user);
	return "userInfo";	
	}
	
}
