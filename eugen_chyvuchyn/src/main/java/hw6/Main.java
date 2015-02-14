package hw6;

import hw6.notes.dao.NotebookDaoImpl;
import hw6.notes.service.NotebookServiceImpl;
import hw6.notes.view.Menu;
import org.apache.log4j.Logger;
import org.hibernate.SessionFactory;
import org.hibernate.boot.registry.StandardServiceRegistry;
import org.hibernate.boot.registry.StandardServiceRegistryBuilder;
import org.hibernate.cfg.Configuration;
import session9.HiberConnect;

import java.util.Locale;

/**
 * Created by Chuvychin on 09.02.2015.
 */
public class Main {
    private static Logger log = Logger.getLogger(HiberConnect.class);
    public static void main(String[] args) {
        Locale.setDefault(Locale.ENGLISH);
        Configuration cfg = new Configuration().configure("hibernate.cfg.xml");
        StandardServiceRegistryBuilder sb = new StandardServiceRegistryBuilder();
        sb.applySettings(cfg.getProperties());
        StandardServiceRegistry standardServiceRegistry = sb.build();
        SessionFactory factory = cfg.buildSessionFactory(standardServiceRegistry);
        //log.info("Reference to SessionFactory " + factory);

        NotebookDaoImpl notebookDao = new NotebookDaoImpl(factory);
        NotebookServiceImpl notebookService = new NotebookServiceImpl(notebookDao);
        Menu menu = new Menu(notebookService);

        menu.main();


    }
}
