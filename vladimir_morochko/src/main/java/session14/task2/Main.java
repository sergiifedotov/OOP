package session14.task2;

import org.apache.xbean.spring.context.ClassPathXmlApplicationContext;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Controller;

import java.util.Locale;

/**
 * Created by vladimir on 22.02.2015.
 */

public class Main {
    ApplicationContext applicationContext = new ClassPathXmlApplicationContext("session14/task2/transactionalContext.xml");

    EmployeeDao employeeDao = applicationContext.getBean("employeeDaoImpl", EmployeeDao.class);

    public static void main(String[] args) {
        Locale.setDefault(Locale.ENGLISH); // не забывать про локаль!
        Main main = new Main();

        System.out.println(main.employeeDao.findAll());
    }
}
