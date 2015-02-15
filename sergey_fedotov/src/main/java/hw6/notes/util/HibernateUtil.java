package hw6.notes.util;

import hw6.notes.dao.NotebookDaoImpl;
import org.apache.log4j.Logger;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.boot.registry.StandardServiceRegistry;
import org.hibernate.boot.registry.StandardServiceRegistryBuilder;
import org.hibernate.cfg.AnnotationConfiguration;
import org.hibernate.cfg.Configuration;

import java.util.Locale;

/**
 * Написать приложение для управления ноутбуками.
 Реализовать функции:
 - Добавить новый ноутбук
 - Показать список ноутбуков (включая порядковый номер id)

 domain
 hw6.notes.domain.Notebook
 dao
 hw6.notes.dao.NotebookDao
 Long create(Notebook notebook)
 Notebook read(Long ig)
 boolean update(Notebook notebook)
 boolean delete(Notebook notebook)
 List<Notebook> findAll()
 hw6.notes.dao.NotebookDaoImpl
 util
 hw6.notes.util.HibernateUtil
 service
 hw6.notes.service.NotebookService
 Long add(Notebook notebook)
 List<Notebook> findAll()
 hw6.notes.service.NotebookServiceImpl
 view
 hw6.notes.service.Menu
 main()
 */
public class HibernateUtil {
    private static final SessionFactory sessionFactory = buildSessionFactory();
    private static Logger log = Logger.getLogger(NotebookDaoImpl.class);

    private static SessionFactory buildSessionFactory() {

        /*Locale.setDefault(Locale.ENGLISH);
        Configuration cfg = new Configuration().configure("hibernateNotebooks.cfg.xml");
        StandardServiceRegistryBuilder sb = new StandardServiceRegistryBuilder();
        sb.applySettings(cfg.getProperties());
        StandardServiceRegistry standardServiceRegistry = sb.build();
        SessionFactory factory = cfg.buildSessionFactory(standardServiceRegistry);
        log.info("Reference to SessionFactory " + factory);
        return  factory;*/

        try {
            Locale.setDefault(Locale.ENGLISH);
            //return new AnnotationConfiguration().configure().buildSessionFactory();
            return new Configuration().configure("hibernateNotebooks.cfg.xml").buildSessionFactory();
        }
        catch (Throwable ex) {
            System.err.println("Initial SessionFactory creation failed." + ex);
            throw new ExceptionInInitializerError(ex);
        }

    }
    public static SessionFactory getSessionFactory() {
        return sessionFactory;
    }

    public static Session getSession() {
        return sessionFactory.openSession();
    }
}
