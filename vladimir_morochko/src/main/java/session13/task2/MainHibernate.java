package session13.task2;

import org.hibernate.Criteria;
import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.SessionFactory;


/**
 * Created by vladimir on 14.02.2015.
 */
public class MainHibernate {
    private SessionFactory sessionFactory = HibernateUtil.getSessionFactory();

    public static void main(String[] args) {
        MainHibernate mainHibernate = new MainHibernate();

        Session session = null;
        try {
            session = mainHibernate.sessionFactory.openSession();
            session.beginTransaction();
            Criteria criteria = session.createCriteria(Company.class);
            System.err.println(criteria.list());


        } catch (HibernateException e) {
            session.getTransaction().rollback();
        } finally {
            if(session != null) {
                session.close();
                mainHibernate.sessionFactory.close();
            }
        }

    }
}
