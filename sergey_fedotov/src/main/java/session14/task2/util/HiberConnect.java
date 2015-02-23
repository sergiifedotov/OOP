package session14.task2.util;

import org.apache.log4j.Logger;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import session14.task2.dao.EmployeeDao;
import session14.task2.domain.Employee;

import java.util.List;
import java.util.Locale;

/**
 *
 */
public class HiberConnect {
    private static Logger log = Logger.getLogger(HiberConnect.class);

    public static void main(String[] args) {
        Locale.setDefault(Locale.ENGLISH);

        ApplicationContext context = new ClassPathXmlApplicationContext("session14/task2/context.xml");

        EmployeeDao employeeDaoImpl = context.getBean("employeeDaoImpl", EmployeeDao.class);

        List<Employee> rezult = employeeDaoImpl.findAll();
        for(Employee e:rezult){
            System.out.println(e.toString());
        }

    }
}

