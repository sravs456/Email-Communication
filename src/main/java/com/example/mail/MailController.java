package com.example.mail;

import java.util.*;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
@CrossOrigin
public class MailController {
@Autowired
private MailRepository mrepo;
@Autowired
private UserRepository urepo;

@GetMapping("/mails")
public List<Mail> getAllMail(){
	return mrepo.findAll();
}

@GetMapping("/mails-from/{email}")
public List<Mail> getMailsbyFromEmail(@PathVariable String email){
	//List<Mail> l1=new ArrayList<Mail>();
	
	return  mrepo.findByFromMail(email);
	
	
}

@GetMapping("/mails-to/{email}")
public List<Mail> getMailsbyToEmail(@PathVariable String email){
	
	return mrepo.findByToMail(email);
	
}
@GetMapping("/mails/{id}")
public Mail getMailById(@PathVariable int id) {
	return mrepo.findById(id).get();
}

@PostMapping("/mails")
public Mail addMail(@RequestBody Mail m) {
	return mrepo.save(m);
}
@DeleteMapping("/mails/{id}")
public void deleteMail(@PathVariable int id) {
	 mrepo.deleteById(id);
}

@DeleteMapping("/mails-delete")
public void deleteMultiMails(@RequestBody String id) {
	System.out.println("Value to be deleted"+id);
	String[] id1=id.split(",");
	for(String s:id1) {
		int id_del=Integer.parseInt(s);
		try {mrepo.deleteById(id_del);}
		catch (Exception e) {
			// TODO: handle exception
		}
		
		
	}
}

//User Repo
@PostMapping("/sign-up")
public User addUser(@RequestBody User user) {
	return urepo.save(user);
}

@PostMapping("/login")
public User checkUser(@RequestBody User user) {
	return urepo.findByEmailAndPassword(user.getEmail(), user.getPassword());
	//return null;
}
@GetMapping("/get-user")
public List<User> getAllUser(){
	return urepo.findAll();
}
@GetMapping("/add-user")
public void addAllUser() {
	User u1=new User("Sravani","a@abc.com","1234");
	User u2=new User("Lavanya","r@abc.com","4321");
	urepo.save(u1);
	urepo.save(u2);
}

}
