package com.example.mail;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class ProjectController {
	@Autowired
	private UserRepository urepo;
	@Autowired
	private MailRepository mrepo;
	
@GetMapping("/")
public String getIndex(){
	return "index";
}
HttpSession ses;
User u;
@PostMapping("/validate")
public String getValidate(@RequestParam String email,String password,HttpServletRequest req) {
//	System.out.println(email+"   ====   "+password);
	 u=urepo.findByEmailAndPassword(email, password);
	if(u != null) {
		 ses=req.getSession(true);
    	ses.setMaxInactiveInterval(10*60);
    ses.setAttribute("uname", u.getName());
    ses.setAttribute("uemail", u.getEmail());
    ses.setAttribute("from_mail", mrepo.findByToMail(u.getEmail()));
    ses.setAttribute("to_mail", mrepo.findByFromMail(u.getEmail()));
	 return "redirect:email";
	}
	else
		 return "redirect:";
}
@GetMapping("/email")
public String getEmail(){
	if(ses != null) {
		ses.setAttribute("from_mail", mrepo.findByToMail(u.getEmail()));
	   
		return "email";
	}
	return "redirect:";
}

@GetMapping("/sent-email")
public String getSentEmail(){
	if(ses != null) {
		 ses.setAttribute("to_mail", mrepo.findByFromMail(u.getEmail()));
		return "sent_email";
	}
	return "redirect:";
	
}
}
