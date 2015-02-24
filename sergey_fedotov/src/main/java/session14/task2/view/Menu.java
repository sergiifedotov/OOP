package session14.task2.view;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.stereotype.Controller;
import session14.task2.domain.Employee;
import session14.task2.service.EmployeeService;

import java.util.Scanner;


/**
 *
 */
@Controller
public class Menu {

    private static final int SHOW_ALL_NOTEBOOKS_ITEM = 1;
    private static final int EXIT_ITEM = 0;

    @Autowired
    private EmployeeService employeeService;
    private Scanner scan;


    public static void main(String[] args) {

        ApplicationContext context = new ClassPathXmlApplicationContext("session14/task2/context.xml");
        Menu menu = context.getBean("menu", Menu.class);

        menu.main();
    }

    public Menu() {
        scan = new Scanner(System.in);
    }


        public Menu(EmployeeService notebookService) {
            this();
            this.employeeService = notebookService;
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
                        showAllEmployee();
                        break;
                }
            } while (choise != EXIT_ITEM);

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


    private void showAllEmployee() {
            for (Employee employee : employeeService.findAll()) {
                System.out.println(employee);
            }
        }

        public void showMenu() {
            System.out.println("-----------------");
            System.out.println("1. Show all notebooks");
            System.out.println("0. Exit");
        }


}
