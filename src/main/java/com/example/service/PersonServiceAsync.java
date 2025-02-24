package com.example.service;

import com.example.service.model.PersonDetails;
import com.google.gwt.user.client.rpc.AsyncCallback;

public interface PersonServiceAsync {
	
	public void savePersonDetailsToDatabase(PersonDetails person , AsyncCallback<String> callback);

}
