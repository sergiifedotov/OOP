package session13.task2;

import org.apache.log4j.Logger;
import org.hibernate.SessionFactory;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import java.util.Locale;

/**
 *
 */
public class HiberConnect {
    private static Logger log = Logger.getLogger(HiberConnect.class);

    public static void main(String[] args) {
        Locale.setDefault(Locale.ENGLISH);

        ApplicationContext context = new ClassPathXmlApplicationContext("session13/task2/context.xml");
        SessionFactory factory = context.getBean("sessionFactory", SessionFactory.class);

        log.info("Reference to SessionFactory " + factory);

        EmployeeDaoImpl employeeDaoImpl = new EmployeeDaoImpl(factory);
        System.out.println(employeeDaoImpl.findAll().toString());

        if (factory != null) {
            factory.close();
        }
    }
}

