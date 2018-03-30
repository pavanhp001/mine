package com.pavan.test;

import java.util.List;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.pavan.manager.UserManager;
import com.pavan.model.User;

public class Test {

	public static void main(String[] args) {
		
			ApplicationContext ctx = new ClassPathXmlApplicationContext("spring.xml");

		    UserManager userManager = (UserManager) ctx.getBean("userManagerImpl");

		    List<User> list = userManager.findAllUsers();
		    System.out.println("User count: " + list.size());

		    User user = new User();
		    user.setUsername("johndoe2");
		    user.setName("John Doe");
		    userManager.insertUser(user);
		    System.out.println("User inserted!");

		    /*list = userManager.findAllUsers();
		    System.out.println("User count: " + list.size());*/

	}

}

/*
 * http://www.byteslounge.com/tutorials/spring-jpa-hibernate-example
 * 
 * 
log4j:WARN No appenders could be found for logger (org.springframework.core.env.StandardEnvironment).
log4j:WARN Please initialize the log4j system properly.
log4j:WARN See http://logging.apache.org/log4j/1.2/faq.html#noconfig for more info.
Hibernate: 
    insert 
    into
        USER
        (NAME, USERNAME) 
    values
        (?, ?)
User inserted!
*/
