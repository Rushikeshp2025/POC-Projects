package com.example.client;

import com.example.service.ClientServiceImp;
import com.example.service.model.PersonDetails;
import com.google.gwt.event.dom.client.ClickEvent;
import com.google.gwt.event.dom.client.ClickHandler;
import com.google.gwt.user.client.ui.Button;
import com.google.gwt.user.client.ui.Composite;
import com.google.gwt.user.client.ui.RootPanel;
import com.google.gwt.user.client.ui.TextBox;

public class MainView extends Composite {

    private TextBox textFirstName;

    private TextBox textLastName;

    private TextBox textAge;

    private ClientServiceImp clientServiceImp;

    public MainView(ClientServiceImp clientServiceImpObject){

        this.clientServiceImp = clientServiceImpObject;

         this.textFirstName = new TextBox();
        RootPanel.get("sendFirstName").add(textFirstName);

         this.textLastName = new TextBox();
        RootPanel.get("sendLastName").add(textLastName);

         this.textAge = new TextBox();
        RootPanel.get("sendAge").add(textAge);

        Button sendButton = new Button();
        sendButton.setText("Save");
        sendButton.addClickHandler(new clickHandler());
        RootPanel.get("sendButton").add(sendButton);

    }

    public void finalResult(String result){
         Button button = new Button();
         button.setText(result);
         RootPanel.get("button").add(button);
    }


     class clickHandler implements ClickHandler{

        @Override
        public void onClick(ClickEvent event) {
            PersonDetails personDetails = new PersonDetails();
            personDetails.setLastName(textLastName.getText());
            personDetails.setFirstName(textFirstName.getText());
            personDetails.setPersonAge(Integer.parseInt(textAge.getText()));
            clientServiceImp.sendDataToServer(personDetails);
        }
    }

}
