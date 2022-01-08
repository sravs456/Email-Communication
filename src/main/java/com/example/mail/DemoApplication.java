package com.example.mail;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.stereotype.Component;

@SpringBootApplication
public class DemoApplication {
@Autowired
private UserRepository urepo;
@Autowired
private MailRepository mrepo;
	public static void main(String[] args) {
		SpringApplication.run(DemoApplication.class, args);
	}
	
	@Component
	public class CommandLineRunnerImpl implements CommandLineRunner {

	    @Override
	    public void run(String... args) throws Exception {

	        System.out.println("In CommandLineRunnerImpl ");
	        User u1=new User("Sravani","a@abc.com","1234");
	    	User u2=new User("Lavanya","r@abc.com","4321");
	    	urepo.save(u1);
	    	urepo.save(u2);
	    	
	    	Mail m1=new Mail("a@abc.com","r@abc.com","HI","Lorem ipsum dolor sit amet, consectetur adipiscing elit");
	    	Mail m2=new Mail("a@abc.com","r@abc.com","HI","Sed ut perspiciatis unde omnis iste natus error sit voluptatem accusantium doloremque laudantium");
	    	Mail m3=new Mail("a@abc.com","r@abc.com","HI","At vero eos et accusamus et iusto odio dignissimos ducimus");
	    	Mail m4=new Mail("a@abc.com","r@abc.com","HI","Excepteur sint occaecat cupidatat non proident");
	    	Mail m5=new Mail("r@abc.com","a@abc.com","Hello","Duis aute irure dolor in reprehenderit in voluptate velit esse cillum");
	    	Mail m6=new Mail("r@abc.com","a@abc.com","Hello","Nemo enim ipsam voluptatem quia voluptas sit aspernatur");
	    	Mail m7=new Mail("r@abc.com","a@abc.com","Hello","Ut enim ad minima veniam, quis nostrum exercitationem ullam corporis suscipit");
	    	Mail m8=new Mail("r@abc.com","a@abc.com","Hello","Lorem ipsum dolor sit amet, consectetur adipiscing elit, sed do eiusmod tempor");
	    	mrepo.save(m1);
	    	mrepo.save(m2);
	    	mrepo.save(m3);
	    	mrepo.save(m4);
	    	mrepo.save(m5);
	    	mrepo.save(m6);
	    	mrepo.save(m7);
	    	mrepo.save(m8);
	    	

	        
	    }
	}

}
