package session14;


import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import java.util.List;

/**
 * Created by stan on 21.02.2015.
 */
public class Main {
    public static void main(String[] args) {
        ApplicationContext context = new ClassPathXmlApplicationContext("session14/companyContext.xml");

        EmployeeDaoImpl employeeDao = context.getBean("employeeDaoImpl", EmployeeDaoImpl.class);

        List<Employee> list = employeeDao.findAll();

        for (Employee e:list){
            System.out.println(e);
        }
    }
}
