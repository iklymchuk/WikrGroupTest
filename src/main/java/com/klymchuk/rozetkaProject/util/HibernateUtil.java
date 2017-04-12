package com.klymchuk.rozetkaProject.util;

import com.klymchuk.rozetkaProject.entities.TestRunInfo;
import org.hibernate.SessionFactory;
import org.hibernate.boot.registry.StandardServiceRegistryBuilder;
import org.hibernate.cfg.Configuration;

/**
 * Created by iklymchuk on 4/11/17.
 */
public class HibernateUtil {

    private static final SessionFactory sessionFactory = buildSessionFactory();

    private static SessionFactory buildSessionFactory() {
        try {
            Configuration configuration = new Configuration();
            configuration.configure("hibernate.cfg.xml");
            configuration.addAnnotatedClass(TestRunInfo.class);
            return configuration
                    .buildSessionFactory(new StandardServiceRegistryBuilder()
                            .applySettings(configuration.getProperties())
                            .build());
        } catch (Exception e) {
            e.printStackTrace();
            throw new RuntimeException("There was an error building the factory");
        }
    }

    public static SessionFactory getSessionFactory(){
        return sessionFactory;
    }
}
