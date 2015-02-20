package session12.company.view;

import session12.company.dao.CompanyDao;
import session12.company.dao.CompanyDaoImpl;
import session12.company.domain.Company;
import session12.company.service.CompanyService;
import session12.company.service.CompanyServiceImpl;
import java.util.Scanner;


/**
 *
 */
public class Menu {

    private static final int SHOW_ALL_COMPANY_ITEM = 1;
    private static final int EXIT_ITEM = 0;
    private static final int ADD_NEW_COMPANY_ITEM = 2;


    private CompanyService companyService;
    private Scanner scan;


    public static void main(String[] args) {

        CompanyDao companyDao = new CompanyDaoImpl();
        CompanyService companyService = new CompanyServiceImpl(companyDao);

        Menu menu = new Menu(companyService);
        menu.main();
    }

    public Menu() {
        scan = new Scanner(System.in);
        //userService = new ClientServiceImpl(new ClientHibernateDaoImpl());
    }


        public Menu(CompanyService companyService) {
            this();
            this.companyService = companyService;
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
                    case SHOW_ALL_COMPANY_ITEM:
                        showAllCompany();
                        break;
                    case ADD_NEW_COMPANY_ITEM:
                        addNewCompany();

                }
            } while (choise != EXIT_ITEM);

        }

        private void showAllCompany() {
            for (Company company : companyService.findAll()) {
                System.out.println(company);
            }
        }

        private void addNewCompany() {

            System.out.println("Input name");
            String name = scan.nextLine();

            Double charterCapital = scanDoubleWithRetry("Input charter capital");

            Company company = new Company(name, charterCapital);

            System.out.println("Added company " + company);
            companyService.add(company);
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
            System.out.println("1. Show all company");
            System.out.println("2. Add new company");
            System.out.println("0. Exit");
        }


}
