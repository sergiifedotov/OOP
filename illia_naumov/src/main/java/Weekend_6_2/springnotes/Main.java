package Weekend_6_2.springnotes;

import Weekend_6_2.springnotes.notes.dao.NotebookDao;
import Weekend_6_2.springnotes.notes.domain.Notebook;
import Weekend_6_2.springnotes.notes.domain.Vendor;
import Weekend_6_2.springnotes.notes.service.NotebookService;
import Weekend_6_2.springnotes.notes.service.NotebookServiceImpl;
import org.apache.xbean.spring.context.ClassPathXmlApplicationContext;
import org.springframework.context.ApplicationContext;

import java.util.List;

/**
 * Created by illia_naumov on 20.02.2015.
 */
public class Main {
    //private static Logger log = Logger.getLogger(Main.class);
    public static void main(String[] args) {
        ApplicationContext context = new ClassPathXmlApplicationContext("hw7/springnotes/context-db.xml");

        NotebookDao ntbDao = context.getBean("notebookDao", NotebookDao.class);
        List<Notebook> ntbs = ntbDao.findAll();
        for(Notebook i:ntbs) {
            System.out.println(i);
        }










        /**NotebookService notebookService = new NotebookServiceImpl();
        DateFormat dateFormat = new SimpleDateFormat("dd.MM.yyyy");
        Date date1 = null;
        Date date2 = null;
        Date date3 = null;
        try {
            date1 = dateFormat.parse("01.08.2010");
            date2 = dateFormat.parse("01.09.2010");
            date3 = dateFormat.parse("01.01.2011");
        } catch (ParseException e) {
            e.printStackTrace();
        }


        Vendor vendor1 = new Vendor("Apple");
        Vendor vendor2 = new Vendor("HP");
        Vendor vendor3 = new Vendor("Intel");
        Vendor vendor4 = new Vendor("AMD");
        Vendor vendor5 = new Vendor("OCZ");
        Vendor vendor6 = new Vendor(("Samsung"));
        notebookService.updateVendor(vendor1);
        /**notebookService.add(vendor2);
        notebookService.add(vendor3);
        notebookService.add(vendor4);
        notebookService.add(vendor5);
        notebookService.add(vendor6);

        CPU cpu1 = new CPU("z", (long) 2400, "Core i5");
        CPU cpu2 = new CPU("x", (long) 2400, "Core i7");
        CPU cpu3 = new CPU("c", (long) 3200, "Opteron");
        notebookService.add(cpu1);
        notebookService.add(cpu2);
        notebookService.add(cpu3);

        Memory memory1 = new Memory("1", 1024);
        Memory memory2 = new Memory("2", 2048);
        Memory memory3 = new Memory("3", 4096);
        Memory memory4 = new Memory("4", 8192);
        notebookService.add(memory1);
        notebookService.add(memory2);
        notebookService.add(memory3);
        notebookService.add(memory4);

        Notebook notebook1 = new Notebook(vendor1, "MacBookPro", date1, cpu1, memory4);
        Notebook notebook2 = new Notebook(vendor2, "Pavilion", date2, cpu2, memory3);
        Notebook notebook3 = new Notebook(vendor6, "Kaminsung", date3, cpu3, memory2);
        Long notebookId1 = notebookService.add(notebook1);
        Long notebookId2 = notebookService.add(notebook2);
        Long notebookId3 = notebookService.add(notebook3);

        Long storeId1 = notebookService.receive(notebookId1, 10, (double) 2500);
        Long storeId2 = notebookService.receive(notebookId2, 15, (double) 1500);
        Long storeId3 = notebookService.receive(notebookId3, 20, (double) 1000);

        Long saleId1 = notebookService.sale(storeId1, 5);
        Long saleId2 = notebookService.sale(storeId2, 10);
        Long saleId3 = notebookService.sale(storeId3, 12);*/






        /**List <Notebook> list1 = service.getNotebooksByPortion(2);
        for(int i = 0; i < list1.size(); i++){
            System.out.println(list1.get(i));
        }*/






    }
}
/**Locale.setDefault(Locale.ENGLISH);
 Configuration cfg = new Configuration().configure("hw7/hibernate.cfg.xml");
 StandardServiceRegistryBuilder sb = new StandardServiceRegistryBuilder();
 sb.applySettings(cfg.getProperties());
 StandardServiceRegistry standardServiceRegistry = sb.build();
 SessionFactory factory = cfg.buildSessionFactory(standardServiceRegistry);*/