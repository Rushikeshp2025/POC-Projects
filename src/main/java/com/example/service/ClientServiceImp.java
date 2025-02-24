package com.example.service;

import com.example.client.MainView;
import com.example.service.model.PersonDetails;
import com.google.gwt.core.client.GWT;
import com.google.gwt.user.client.rpc.AsyncCallback;
import com.google.gwt.user.client.rpc.ServiceDefTarget;

public class ClientServiceImp implements ClientInterface  {

	private PersonServiceAsync personDetailsService;

	private MainView mainView;

	public ClientServiceImp(String url){
		this.personDetailsService = GWT.create(PersonService.class);
        ServiceDefTarget endpoint = (ServiceDefTarget)this.personDetailsService;
		endpoint.setServiceEntryPoint(url);

		this.mainView = new MainView(this);
	}

	public MainView getObjectMainView(){
		return  this.mainView;
	}

	@Override
	public void sendDataToServer(PersonDetails personDetails) {
	  // TODO Auto-generated method stub
        personDetailsService.savePersonDetailsToDatabase(personDetails, new AsyncCallback<String>() {
			@Override
			public void onFailure(Throwable caught) {
				String resulString = caught.toString();
				mainView.finalResult(resulString);
			}
			@Override
			public void onSuccess(String result) {
				mainView.finalResult(result);
			}
		});



	}
	

}
