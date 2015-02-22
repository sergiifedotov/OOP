package session13_14;


import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import java.util.List;

/**
 * Created by Chuvychin on 21.02.2015.
 */
public class Main {
    public static void main(String[] args) {
        ApplicationContext context = new ClassPathXmlApplicationContext("session13_14/context.xml");
//        Man man1 = context.getBean("man1", Man.class);
//        Man man2 = context.getBean("man2", Man.class);



        EmployeeDaoImpl employeeDao = context.getBean("employeeDaoImpl", EmployeeDaoImpl.class);

        List<Employee> list = employeeDao.findAll();

        for (Employee e:list){
            System.out.println(e);
        }
    }
}
