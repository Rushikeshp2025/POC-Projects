package com.example.service;

import com.example.service.model.PersonDetails;
import com.google.gwt.user.client.rpc.RemoteService;
import com.google.gwt.user.client.rpc.RemoteServiceRelativePath;

@RemoteServiceRelativePath("person")
public interface PersonService  extends RemoteService{
	
	public String savePersonDetailsToDatabase(PersonDetails person);

}
