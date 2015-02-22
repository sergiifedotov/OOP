package session14.task2;

import org.apache.log4j.Logger;
import org.hibernate.SessionFactory;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

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
        SessionFactory factory = context.getBean("sessionFactory", SessionFactory.class);

        log.info("Reference to SessionFactory " + factory);
        EmployeeDaoImpl employeeDaoImpl = context.getBean("employeeDaoImpl", EmployeeDaoImpl.class);

        employeeDaoImpl.setFactory(factory);
        List<Employee> rezult = employeeDaoImpl.findAll();
        for(Employee e:rezult){
            System.out.println(e.toString());
        }

        if (factory != null) {
            factory.close();
        }
    }
}

