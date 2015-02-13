package session10.dentist;

import org.hibernate.SessionFactory;
import org.hibernate.boot.registry.StandardServiceRegistry;
import org.hibernate.boot.registry.StandardServiceRegistryBuilder;
import org.hibernate.cfg.Configuration;
import session10.dentist.dao.ClientDao;
import session10.dentist.dao.ClientHibernateDaoImpl;
import session10.dentist.service.ClientService;
import session10.dentist.service.ClientServiceImpl;
import session10.dentist.utils.HibernateUtil;
import session10.dentist.view.Menu;

import java.util.Locale;


/**
 * Created with IntelliJ IDEA.
 * User: al1
 * Date: 4/7/13
 */
public class Main {
    public static void main(String[] args) {
        // !! IMPORTANT !! this is only example of structure
        Locale.setDefault(Locale.ENGLISH);
        Configuration cfg = new Configuration().configure("hibernate.cfg.xml");
        StandardServiceRegistryBuilder sb = new StandardServiceRegistryBuilder();
        sb.applySettings(cfg.getProperties());
        StandardServiceRegistry standardServiceRegistry = sb.build();
        SessionFactory factory = cfg.buildSessionFactory(standardServiceRegistry);

        ClientDao clientDao = new ClientHibernateDaoImpl(factory);
        ClientService clientService = new ClientServiceImpl(clientDao);

        Menu menu = new Menu(clientService);
        menu.main();
    }
}
