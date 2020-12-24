package io.github.muratcanabay.util;

import io.github.muratcanabay.domain.*;
import mabay.domain.*;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

public class HibernateUtil {
    private static final SessionFactory sessionFactory = buildSessionFactory();

    private static SessionFactory buildSessionFactory() {
        try {
            Configuration configuration = new Configuration();

            configuration.addAnnotatedClass(Araba.class);
            configuration.addAnnotatedClass(Plaka.class);
            configuration.addAnnotatedClass(Pojo.class);
            configuration.addAnnotatedClass(Urun.class);
            configuration.addAnnotatedClass(UrunTuru.class);

            SessionFactory sessionFactory = configuration.configure("hibernate.cfg.xml").buildSessionFactory();
            return sessionFactory;
        } catch (Exception e) {
            e.printStackTrace();
            throw new ExceptionInInitializerError();
        }
    }

    public static SessionFactory getSessionFactory() {
        return sessionFactory;
    }
}
