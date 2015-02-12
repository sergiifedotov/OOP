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
import java.util.*;

/**
 * Created by Tanya on 11.02.2015.
 */
public class NotebookServiceImpl implements NotebookService {

    private static Logger log = Logger.getLogger(HiberConnect.class);

    @Override
    public Long add(Notebook notebook){
        Locale.setDefault(Locale.ENGLISH);
        SessionFactory factory = connectionHibernet();
        log.info("Reference to SessionFactory " + factory);
        Session session = null;
        Long id = null;
        try {
            session = factory.openSession();
            NotebookDaoImpl n = new NotebookDaoImpl(factory);
            id = n.create(notebook);
            System.out.println(id);
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
        System.out.println("New Notebook add to database successfully !!!");
        return id;
    }

    @Override
    public List<Notebook> findAll(){
        List<Notebook> list = new ArrayList<>();
        Locale.setDefault(Locale.ENGLISH);
        SessionFactory factory = connectionHibernet ();
        log.info("Reference to SessionFactory " + factory);
        Session session = null;
        Long id = null;
        try {
            session = factory.openSession();
            NotebookDaoImpl n = new NotebookDaoImpl(factory);
            list = n.findAll();
            for(Notebook i: list){
                System.out.println(i+"\t " + "        ");
            }
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
        return list;
    }
    @Override
    public Notebook read(Long id){
        Locale.setDefault(Locale.ENGLISH);
        SessionFactory factory = connectionHibernet();
        log.info("Reference to SessionFactory " + factory);
        Session session = null;
        Notebook notebook = null;
        try {
            session = factory.openSession();
            NotebookDaoImpl n = new NotebookDaoImpl(factory);
            notebook = n.read(id);

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
        return notebook;
    }

    @Override
    public void deleteNtb(Notebook notebook){
        Locale.setDefault(Locale.ENGLISH);
        SessionFactory factory = connectionHibernet();
        log.info("Reference to SessionFactory " + factory);
        Session session = null;
        Long id = null;
        try {
            session = factory.openSession();
            NotebookDaoImpl n = new NotebookDaoImpl(factory);
            n.delete(notebook);

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

    @Override
    public  void changePrice(Long id, double price){
        Locale.setDefault(Locale.ENGLISH);
        SessionFactory factory = connectionHibernet();
        log.info("Reference to SessionFactory " + factory);
        Session session = null;

        try {
            session = factory.openSession();
            NotebookDaoImpl n = new NotebookDaoImpl(factory);
            Notebook notebook = n.read(id);
            notebook.setPrice(price);
            n.update(notebook);

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

    @Override
    public void changeSerialVendor(Long id, String serial, String vendor){
        Locale.setDefault(Locale.ENGLISH);
        SessionFactory factory = connectionHibernet();
        log.info("Reference to SessionFactory " + factory);
        Session session = null;

        try {
            session = factory.openSession();
            NotebookDaoImpl n = new NotebookDaoImpl(factory);
            Notebook notebook = n.read(id);
            notebook.setSerial(serial);
            notebook.setVendor(vendor);
            n.update(notebook);

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


    public SessionFactory connectionHibernet (){
        Configuration cfg = new Configuration().configure("hibernate.cfg.xml");
        StandardServiceRegistryBuilder sb = new StandardServiceRegistryBuilder();
        sb.applySettings(cfg.getProperties());
        StandardServiceRegistry standardServiceRegistry = sb.build();
        SessionFactory factory = cfg.buildSessionFactory(standardServiceRegistry);
        return factory;
    }

    public Notebook createNewNotebook() {
        Scanner scan2 = new Scanner(System.in);
        System.out.println("введите параметры ноутбука \n" + "PRICE:");
        Double price = scan2.nextDouble();

        System.out.println("SERIAL:");
        String serial = scan2.next();

        System.out.println("VENDOR:");
        String vendor = scan2.next();

        System.out.println("MODEL:");
        String model = scan2.next();
        System.out.println("MANUFACTURE_DATE   (dd.mm.yyyy)  :");
        String manufDate = scan2.next();
        DateFormat dateFormat = new SimpleDateFormat("dd.mm.yyyy");
        Date manufactureDate = null;
        try {
            manufactureDate = dateFormat.parse(manufDate);
        } catch (ParseException e) {
            e.printStackTrace();
        }

        Notebook notebook = new Notebook(price, serial, vendor, model, manufactureDate);
        return notebook;

    }
}
