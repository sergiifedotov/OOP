package main.java.hw6.notes;

import hw6.notes.dao.NotebookDaoImpl;
import hw6.notes.domain.Notebook;
import hw6.notes.service.NotebookServiceImpl;
import org.apache.log4j.Logger;
import org.hibernate.SessionFactory;
import org.hibernate.boot.registry.StandardServiceRegistry;
import org.hibernate.boot.registry.StandardServiceRegistryBuilder;
import org.hibernate.cfg.Configuration;
import session10.dentist.utils.HibernateUtil;

import java.util.Date;
import java.util.GregorianCalendar;
import java.util.List;
import java.util.Locale;

/**
 * Created by user on 10.02.2015.
 */
public class Main {

    private static Logger log = Logger.getLogger(Main.class);
    public static void main(String[] args) {Locale.setDefault(Locale.ENGLISH);
        Configuration cfg = new Configuration().configure("hibernate.cfg.xml");
        StandardServiceRegistryBuilder sb = new StandardServiceRegistryBuilder();
        sb.applySettings(cfg.getProperties());
        StandardServiceRegistry standardServiceRegistry = sb.build();
        SessionFactory factory = cfg.buildSessionFactory(standardServiceRegistry);

        NotebookDaoImpl notebookDao = new NotebookDaoImpl(factory);
        NotebookServiceImpl notebookService = new NotebookServiceImpl(notebookDao);


    }
}