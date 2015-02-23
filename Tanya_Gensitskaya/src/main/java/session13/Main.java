package session13;

import org.apache.xbean.spring.context.ClassPathXmlApplicationContext;
import org.springframework.context.ApplicationContext;
import session13.dao.EmployeeDaoImpl;
import session13.domain.Employee;

import java.util.ArrayList;

/**
 * Created by ZaR on 21.02.15.
 */
public class Main {
    public static void main(String[] args) {
//        ApplicationContext context = new ClassPathXmlApplicationContext("session13/context.xml");
//        Company comp = context.getBean("company", Company.class);
//        System.out.println(comp);

        ApplicationContext context = new ClassPathXmlApplicationContext("session13/context-db.xml");
        EmployeeDaoImpl employeeDao = (EmployeeDaoImpl)context.getBean("EmployeeDao");
        ArrayList<Employee> list = (ArrayList<Employee>)employeeDao.findAll();
        for(int i = 0; i < list.size(); i++) {
            System.out.println(list.get(i));
        }

//        ApplicationContext context = new ClassPathXmlApplicationContext("session13/context.xml");
//                Company comp = context.getBean("company", Company.class);
//        System.out.println(comp);




     //   Man man2 = context.getBean("man2", Man.class);


//        System.out.println(man2);
    }
}
