package com.example.server;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.orm.hibernate5.HibernateTemplate;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Repository;

import javax.transaction.Transactional;

@Component
public class PersonDaoImpl implements PersonDao {

    private  SessionFactory sessionFactory;

    void setSessionFactory(SessionFactory sessionFactory){
        this.sessionFactory = sessionFactory;
    }


    public PersonDaoImpl(){
        setup();
    }

    public void setup(){
        Configuration config = new Configuration();
        config.setProperty("hibernate.connection.driver_class", "com.mysql.jdbc.Driver");
        config.setProperty("hibernate.connection.url", "jdbc:mysql://localhost:3306/testdb");
        config.setProperty("hibernate.connection.username", "root");
        config.setProperty("hibernate.connection.password", "root");
        config.setProperty("hibernate.dialect", "org.hibernate.dialect.MySQL5InnoDBDialect");
        config.setProperty("hibernate.hbm2ddl.auto","create");
        config.addAnnotatedClass(PersonData.class);
        this.sessionFactory = config.buildSessionFactory();
    }

    @Override
    public Integer savePersonData(PersonData personData) {
        Session session = sessionFactory.openSession();
        session.beginTransaction();
        session.save(personData);
        session.getTransaction().commit();
        session.close();
         return 1;
    }
}
