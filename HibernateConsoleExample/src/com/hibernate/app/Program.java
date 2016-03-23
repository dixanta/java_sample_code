/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.hibernate.app;

import com.hibernate.app.entity.Discount;
import java.math.BigDecimal;
import java.util.List;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.boot.registry.StandardServiceRegistry;
import org.hibernate.boot.registry.StandardServiceRegistryBuilder;
import org.hibernate.cfg.Configuration;
import org.hibernate.service.ServiceRegistry;


/**
 *
 * @author forsell
 */
public class Program {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
Configuration configuration = new Configuration().configure("resources/hibernate.cfg.xml");
        StandardServiceRegistryBuilder registry=new StandardServiceRegistryBuilder();
        registry.applySettings(configuration.getProperties());
        ServiceRegistry serviceRegistry = registry.build();
        SessionFactory sessionFactory = configuration.buildSessionFactory(serviceRegistry);

        Session session = sessionFactory.openSession();
        //Transaction trans=session.beginTransaction();
        //session.save(new Discount(0,"50% OFF",50,null,true));
        //trans.commit();
        List<Discount> discounts=session.getNamedQuery("Discount.findAll").list();
        discounts.forEach(d->{
            System.out.println(d.getDiscountTitle());
        });
        session.close();
        sessionFactory.close();
        
        System.out.println("Finish");
        System.exit(0);
    }
    
}
