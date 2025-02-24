package com.example.server;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class PersonData {


    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    int personId;
    String personName;
    String personFamilyName;
    int personAge;

    public PersonData() {
        super();
    }


    public PersonData(int personId, String personName, String personFamilyName, int personAge) {
        this.personId = personId;
        this.personName = personName;
        this.personFamilyName = personFamilyName;
        this.personAge = personAge;
    }

    public int getPersonId() {
        return personId;
    }

    public void setPersonId(int personId) {
        this.personId = personId;
    }

    public String getPersonName() {
        return personName;
    }

    public void setPersonName(String personName) {
        this.personName = personName;
    }

    public String getPersonFamilyName() {
        return personFamilyName;
    }

    public void setPersonFamilyName(String personFamilyName) {
        this.personFamilyName = personFamilyName;
    }

    public int getPersonAge() {
        return personAge;
    }

    public void setPersonAge(int personAge) {
        this.personAge = personAge;
    }
}
