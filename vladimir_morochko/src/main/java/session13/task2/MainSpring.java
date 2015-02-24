package session13.task2;

import org.apache.xbean.spring.context.ClassPathXmlApplicationContext;
import org.hibernate.Criteria;
import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.context.ApplicationContext;
import java.util.Locale;

/**
 * Created by vladimir on 22.02.2015.
 */
public class MainSpring {
    ApplicationContext applicationContext = new ClassPathXmlApplicationContext("session13/task2/context-db.xml");
    SessionFactory sessionFactory = applicationContext.getBean("sessionFactory13", SessionFactory.class);

    public static void main(String[] args) {
        Locale.setDefault(Locale.ENGLISH); // не забывать про локаль!
        MainSpring main = new MainSpring();

        Session session = null;
        try {
            session = main.sessionFactory.openSession();
            session.beginTransaction();
            Criteria criteria = session.createCriteria(Company.class);
            System.out.println(criteria.list());

        } catch (HibernateException e) {
            session.getTransaction().rollback();
        } finally {
            if(session != null) {
                session.close();
                main.sessionFactory.close();
            }
        }

    }
}
