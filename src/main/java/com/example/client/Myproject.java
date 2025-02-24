package com.example.client;

import com.example.service.ClientServiceImp;
import com.example.service.model.PersonDetails;
import com.google.gwt.core.client.EntryPoint;
import com.google.gwt.core.client.GWT;
import com.google.gwt.user.client.ui.*;

/**
 * Entry point classes define <code>onModuleLoad()</code>.
 */
public class Myproject implements EntryPoint {


	public void onModuleLoad() {

		ClientServiceImp clientServiceImp = new ClientServiceImp(GWT.getModuleBaseURL() + "person");
		RootPanel.get().add(clientServiceImp.getObjectMainView());
	}
}
