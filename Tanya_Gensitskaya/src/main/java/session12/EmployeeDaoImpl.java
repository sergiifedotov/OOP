package session12;

import org.apache.log4j.Logger;
import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.criterion.Restrictions;
import session9.Region;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by ZaR on 15.02.15.
 */
public class EmployeeDaoImpl implements EmployeeDao{
    private static Logger log = Logger.getLogger(EmployeeDaoImpl.class);
    private SessionFactory factory;

    public EmployeeDaoImpl(SessionFactory factory) {
        this.factory = factory;
    }

    @Override
    public Employee read(String capital) {
        List<Employee> list1 = new ArrayList<>();
        Session session = null;
        try {
            session = factory.openSession();
            session.beginTransaction();
            list1 = session.createCriteria(Employee.class).createCriteria("company").add(Restrictions.gt("capital", capital)).list();
            session.getTransaction().commit();
//            return id;
        } catch (HibernateException e) {
            log.error("Open session failed", e);
            session.getTransaction().rollback();
        } finally {
            if (session != null) {
                session.close();
            }
        }
        return null;
    }


    @Override
    public Long create(Employee empl) {
        Session session = null;
        try {
            session = factory.openSession();
            session.beginTransaction();
            Long id = (Long) session.save(empl);
            session.getTransaction().commit();
            return id;
        } catch (HibernateException e) {
            log.error("Open session failed", e);
            session.getTransaction().rollback();
        } finally {
            if (session != null) {
                session.close();
            }
        }
        return null;
    }

    @Override
    public Employee read(Long id) {
        Session session = null;
        Employee empl = new Employee();
        try {
            session = factory.openSession();
            session.beginTransaction();
            empl = (Employee) session.get(Employee.class, id);
            session.getTransaction().commit();
        } catch (HibernateException e) {
            log.error("Open session failed", e);
            session.getTransaction().rollback();
        } finally {
            if (session != null) {
                session.close();
            }
        }
        return empl;
    }
}
