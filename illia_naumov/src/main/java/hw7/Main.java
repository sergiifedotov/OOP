package hw7;

import hw7.notes.dao.CPUDaoImpl;
import hw7.notes.dao.MemoryDaoImpl;
import hw7.notes.dao.NotebookDaoImpl;
import hw7.notes.dao.VendorDaoImpl;
import hw7.notes.domain.CPU;
import hw7.notes.domain.Memory;
import hw7.notes.domain.Notebook;
import hw7.notes.domain.Vendor;
import org.apache.log4j.Logger;
import org.hibernate.SessionFactory;
import org.hibernate.boot.registry.StandardServiceRegistry;
import org.hibernate.boot.registry.StandardServiceRegistryBuilder;
import org.hibernate.cfg.Configuration;

import java.util.Date;
import java.util.Locale;

/**
 * Created by user on 20.02.2015.
 */
public class Main {
    private static Logger log = Logger.getLogger(Main.class);
    public static void main(String[] args) {
        Locale.setDefault(Locale.ENGLISH);
        Configuration cfg = new Configuration().configure("hibernate.cfg.xml");
        StandardServiceRegistryBuilder sb = new StandardServiceRegistryBuilder();
        sb.applySettings(cfg.getProperties());
        StandardServiceRegistry standardServiceRegistry = sb.build();
        SessionFactory factory = cfg.buildSessionFactory(standardServiceRegistry);

        NotebookDaoImpl note = new NotebookDaoImpl();
        CPUDaoImpl cpu = new CPUDaoImpl(factory);
        CPU cp = cpu.read((new Long(1)));
        MemoryDaoImpl memory = new MemoryDaoImpl();
        VendorDaoImpl vendor = new VendorDaoImpl();
        Vendor vend = new Vendor("Japan");
        vendor.create(vend);
        Memory mem = new Memory(8, "India");
        memory.create(mem);


        note.create(new Notebook(vend, "black", new Date(), cpu.read((new Long(1))), mem ));

        //NotebookDaoImpl notebookDao = new NotebookDaoImpl(factory);
        //NotebookServiceImpl notebookService = new NotebookServiceImpl(notebookDao);



    }
}
