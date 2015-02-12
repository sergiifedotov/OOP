package hw6.notes.service;

import hw6.notes.dao.NotebookDaoImpl;
import hw6.notes.domain.Notebook;
import org.apache.log4j.Logger;
import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.boot.registry.StandardServiceRegistry;
import org.hibernate.boot.registry.StandardServiceRegistryBuilder;
import org.hibernate.cfg.Configuration;
import session9.HiberConnect;

import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Locale;

/**
 * Created by ZaR on 08.02.15.
 */
public class MainDao {
    private static Logger log = Logger.getLogger(HiberConnect.class);

    public static void main(String[] args) {

        Locale.setDefault(Locale.ENGLISH);
        Configuration cfg = new Configuration().configure("hibernate.cfg.xml");
        StandardServiceRegistryBuilder sb = new StandardServiceRegistryBuilder();
        sb.applySettings(cfg.getProperties());
        StandardServiceRegistry standardServiceRegistry = sb.build();
        SessionFactory factory = cfg.buildSessionFactory(standardServiceRegistry);
        log.info("Reference to SessionFactory " + factory);

        Session session = null;

        DateFormat dateFormat = new SimpleDateFormat("dd.mm.yyyy");
        Date date = null;
        try {
            date = dateFormat.parse("13.10.2015");
        } catch (ParseException e) {
            e.printStackTrace();
        }


        try {
            session = factory.openSession();
            NotebookDaoImpl n = new NotebookDaoImpl(factory);
// read
//            Notebook notebook = n.read(2L);
//            System.out.println(notebook);
// create
            Notebook notebook = new Notebook(500L, "Dell11", "Lg", "GH455", date);
            Long id = n.create(notebook);
            System.out.println(id);
// update
//            Notebook notebook = n.read(5L);
//            notebook.setModel("Hello");
//            n.update(notebook);
// delete
//            Notebook notebook = n.read(4L);
//            n.delete(notebook);
// findAll
//            List<Notebook> list = n.findAll();
//            for(Notebook i: list){
//                System.out.println(i+" ");
//            }
        } catch (HibernateException e) {
            log.error("Open session failed", e);
            session.getTransaction().rollback();
        } finally {
            if (session != null) {
                session.close();
            }
            if (factory != null) {
                factory.close();
            }
        }


        log.info(session);
    }
}
