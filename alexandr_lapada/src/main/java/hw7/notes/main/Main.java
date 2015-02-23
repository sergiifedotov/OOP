package hw7.notes.main;

import hw7.notes.dao.*;
import hw7.notes.service.NotebookServiceImpl;
import hw7.notes.service.Menu;
import org.apache.log4j.Logger;
import org.hibernate.SessionFactory;
import org.hibernate.boot.registry.StandardServiceRegistry;
import org.hibernate.boot.registry.StandardServiceRegistryBuilder;
import org.hibernate.cfg.Configuration;

import java.util.Locale;


/**
 * Created by sanya on 17.02.2015.
 */
public class Main {
    private static Logger log = Logger.getLogger(Main.class);

    public static void main(String[] args) {
        Locale.setDefault(Locale.ENGLISH);
        Configuration cfg = new Configuration().configure("hibernateHW7.cfg.xml");
        StandardServiceRegistryBuilder sb = new StandardServiceRegistryBuilder();
        sb.applySettings(cfg.getProperties());
        StandardServiceRegistry standardServiceRegistry = sb.build();
        SessionFactory factory = cfg.buildSessionFactory(standardServiceRegistry);
        log.info("Reference to SessionFactory " + factory);

        CPUDaoImpl cpuDao = new CPUDaoImpl(factory);
        MemoryDaoImpl memoryDao = new MemoryDaoImpl(factory);
        VendorDaoImpl vendorDao = new VendorDaoImpl(factory);
        NotebookDaoImpl notebookDao = new NotebookDaoImpl(factory);
        StoreDaoImpl storeDao = new StoreDaoImpl(factory);
        SalesDaoImpl salesDao = new SalesDaoImpl(factory);

        NotebookServiceImpl notebookService = new NotebookServiceImpl(cpuDao, memoryDao, vendorDao,
                notebookDao, storeDao, salesDao);

        Menu menu = new Menu(notebookService);
        menu.main();



        factory.close();
    }
}
