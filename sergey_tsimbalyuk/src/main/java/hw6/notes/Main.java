package hw6.notes;

/**
 * Created by Sergey Tsimbalyuk
 * on 26.02.15 // 2:40
 */
public class Main {
    /*private static Logger log = Logger.getLogger(Main.class);

    public static void main(String[] args) {
        Locale.setDefault(Locale.ENGLISH);
        Configuration cfg = new Configuration().configure("hibernate.cfg.xml");
        StandardServiceRegistryBuilder sb = new StandardServiceRegistryBuilder();
        sb.applySettings(cfg.getProperties());
        StandardServiceRegistry standardServiceRegistry = sb.build();
        SessionFactory factory = cfg.buildSessionFactory(standardServiceRegistry);
        log.info("Reference to SessionFactory " + factory);

        NotebookDaoImpl ntbDaoImpl = new NotebookDaoImpl(factory);
        NotebookServiceImpl notebookService = new NotebookServiceImpl(ntbDaoImpl);



        Menu menu = new Menu(notebookService);
        menu.main();

        factory.close();

    }*/

}