package com.example.server;

import com.example.service.PersonService;
import com.example.service.model.PersonDetails;
import com.google.gwt.user.server.rpc.RemoteServiceServlet;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.stereotype.Service;

import javax.servlet.ServletContext;
import javax.servlet.ServletException;

@Service
public class PersonServiceImpl extends RemoteServiceServlet implements PersonService {

	@Override
	public String savePersonDetailsToDatabase(PersonDetails person) {
		// saving to database
		 PersonDaoImpl personDaoImpl = new PersonDaoImpl();
	     PersonData personDetailsDatabase = new PersonData();
		 personDetailsDatabase.setPersonName(person.getFirstName());
		 personDetailsDatabase.setPersonFamilyName(person.getLastName());
		 personDetailsDatabase.setPersonAge(person.getPersonAge());
		 try {
		   Integer rowsAffected = personDaoImpl.savePersonData(personDetailsDatabase);
			 person.setPersonAge(rowsAffected);
		 }catch (Exception e){
			 return "Failure";
		 }
		return "Success";
	}
}
