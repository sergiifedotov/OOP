package session13;

import org.apache.log4j.Logger;
import org.apache.xbean.spring.context.ClassPathXmlApplicationContext;
import org.hibernate.SessionFactory;
import org.hibernate.boot.registry.StandardServiceRegistry;
import org.hibernate.boot.registry.StandardServiceRegistryBuilder;
import org.hibernate.cfg.Configuration;
import org.springframework.context.ApplicationContext;
import session13.Menu.View;

import java.util.List;
import java.util.Locale;

/**
 * Created by illia_naumov on 21.02.2015.
 */
public class Main {
    private static Logger log = Logger.getLogger(Main.class);
    public static void main(String[] args) {
        ApplicationContext context = new ClassPathXmlApplicationContext("session14/transactionalContext.xml");

        Locale.setDefault(Locale.ENGLISH);
        Configuration cfg = new Configuration().configure("hibernate.cfg.xml");
        StandardServiceRegistryBuilder sb = new StandardServiceRegistryBuilder();
        sb.applySettings(cfg.getProperties());
        StandardServiceRegistry standardServiceRegistry = sb.build();
        SessionFactory factory = cfg.buildSessionFactory(standardServiceRegistry);
        log.info("Reference to SessionFactory " + factory);
        //EmployeeDao daoimpl =  context.getBean("dao", EmployeeDao.class);
        View view = (View) context.getBean("view", View.class);


        /**List<Employee> employees = daoimpl.findAll();
        for(Employee i:employees){
            System.out.println(i);
        }*/





        /**Man director = context.getBean("man1", Man.class);
        Car car = context.getBean("car", Car.class);
        Company company = context.getBean("company", Company.class);


        System.out.println(company);
        //System.out.println(man2);
         */
        factory.close();
    }

}
