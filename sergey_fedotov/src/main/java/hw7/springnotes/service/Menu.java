package hw7.springnotes.service;

import hw7.springnotes.dao.NotebookDao;
import hw7.springnotes.dao.NotebookDaoImpl;
import hw7.springnotes.domain.Notebook;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Scanner;


/**
 *
 */
public class Menu {

    private static final int SHOW_ALL_NOTEBOOKS_ITEM = 1;
    private static final int EXIT_ITEM = 0;
    private static final int ADD_NEW_NOTEBOOK_ITEM = 2;

    private NotebookService notebookService;
    private Scanner scan;


    public static void main(String[] args) {
        // !! IMPORTANT !! this is only example of structure
        /*Locale.setDefault(Locale.ENGLISH);
        Configuration cfg = new Configuration().configure("hibernate.cfg.xml");
        StandardServiceRegistryBuilder sb = new StandardServiceRegistryBuilder();
        sb.applySettings(cfg.getProperties());
        StandardServiceRegistry standardServiceRegistry = sb.build();
        SessionFactory factory = cfg.buildSessionFactory(standardServiceRegistry);*/

        NotebookDao notebookDao = new NotebookDaoImpl();
        NotebookService notebookService = new NotebookServiceImpl(notebookDao);

        Menu menu = new Menu(notebookService);
        menu.main();
    }

    public Menu() {
        scan = new Scanner(System.in);
        //userService = new ClientServiceImpl(new ClientHibernateDaoImpl());
    }


        public Menu(NotebookService notebookService) {
            this();
            this.notebookService = notebookService;
        }

        public void main() {
            int choise = EXIT_ITEM;

            do {
                showMenu();
                choise = getInput();

                switch (choise) {
                    case EXIT_ITEM:
                        System.exit(0);
                        break;
                    case SHOW_ALL_NOTEBOOKS_ITEM:
                        showAllNotebooks();
                        break;
                    case ADD_NEW_NOTEBOOK_ITEM:
                        addNewNotebook();

                }
            } while (choise != EXIT_ITEM);

        }

        private void showAllNotebooks() {
            for (Notebook notebook : notebookService.findAll()) {
                System.out.println(notebook);
            }
        }

        private void addNewNotebook() {

            //System.out.println("Input serial");
            //String serial = scan.nextLine();
            //System.out.println("Input vendor");
            //String vendor = scan.nextLine();
            System.out.println("Input model");
            String model = scan.nextLine();
            Date manufacture_date = scanDateWithRetry("Input manufacture date");
            double price = scanDoubleWithRetry("Input price");

            //Notebook notebook = new Notebook(model, manufacture_date, price);
            Notebook notebook = new Notebook();
            System.out.println("Added notebook " + notebook);
            notebookService.add(notebook);
        }

        private double scanDoubleWithRetry(String message) {
            Double rezult;
            do {
                System.out.println(message);
                rezult = scan.nextDouble();
                if(rezult>0){
                    return rezult;
                }else{
                    System.out.println("Illegal price format, price < 0 , try again");
                }

            } while (!(rezult > 0));
            return rezult;
        }

        private Date scanDateWithRetry(String message) {
            final String DATE_FORMAT = "mm.dd.yyyy";
            Date date = null;
            String dateStr;
            do {
                System.out.println(message);
                dateStr = scan.nextLine();
                SimpleDateFormat sdf = new SimpleDateFormat(DATE_FORMAT);
                try {
                    date = sdf.parse(dateStr);
                } catch (ParseException pe) {
                    System.out.println("Illegal date format, correct format is \'" + DATE_FORMAT + "\', try again");
                }
            } while (date == null);
            return date;
        }

        private int scanIntWithRetry(String ageMsg) {
            Integer age = null;
            String ageStr;
            do {
                System.out.println(ageMsg);
                ageStr = scan.nextLine();
                try {
                    age = Integer.valueOf(ageStr);
                } catch (NumberFormatException nfe) {
                    System.out.println("Not an int value, input again");
                }
            } while (age == null);

            return age;
        }

        private int getInput() {
            int res = -1;
            String inputStr = scan.nextLine();
            try {
                res = Integer.parseInt(inputStr);
            } catch (NumberFormatException nfe) {
                System.out.println("String " + inputStr + " is not a number");
            }

            return res;
        }

        public void showMenu() {
            System.out.println("-----------------");
            System.out.println("1. Show all notebooks");
            System.out.println("2. Add new notebook");
            System.out.println("0. Exit");
        }


}
