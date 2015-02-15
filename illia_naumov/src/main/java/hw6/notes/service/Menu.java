package hw6.notes.service;

import org.hibernate.SessionFactory;
import org.hibernate.boot.registry.StandardServiceRegistry;
import org.hibernate.boot.registry.StandardServiceRegistryBuilder;
import org.hibernate.cfg.Configuration;
import session10.dentist.dao.ClientDao;
import session10.dentist.dao.ClientHibernateDaoImpl;
import session10.dentist.service.ClientService;
import session10.dentist.service.ClientServiceImpl;

import java.util.Locale;

/**
 * Created by user on 10.02.2015.
 */
public class Menu {
    public static void main(String[] args) {
        Locale.setDefault(Locale.ENGLISH);
        Configuration cfg = new Configuration().configure("session10/hibernate.cfg.xml");
        StandardServiceRegistryBuilder sb = new StandardServiceRegistryBuilder();
        sb.applySettings(cfg.getProperties());
        StandardServiceRegistry standardServiceRegistry = sb.build();
        SessionFactory factory = cfg.buildSessionFactory(standardServiceRegistry);

        ClientDao clientDao = new ClientHibernateDaoImpl(factory);
        ClientService clientService = new ClientServiceImpl(clientDao);

        session10.dentist.view.Menu menu = new session10.dentist.view.Menu(clientService);
        menu.main();
    }
}
