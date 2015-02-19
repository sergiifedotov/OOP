package session11_12;

import org.apache.log4j.Logger;
import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.criterion.Projections;
import org.hibernate.criterion.Restrictions;

import java.util.List;

/**
 * Created by Chuvychin on 15.02.2015.
 */
public class EmployeeDaoImpl implements EmployeeDao {
    private static Logger log = Logger.getLogger(EmployeeDaoImpl.class);
    private SessionFactory factory;

    public EmployeeDaoImpl (SessionFactory factory){
        this.factory = factory;
    }


    @Override
    public Integer rowsCount() {
        Session session = null;
        try {
            session = factory.openSession();
            session.beginTransaction();
            return (Integer)session.createCriteria(Employee.class).setProjection(Projections.rowCount()).uniqueResult();
        } catch (HibernateException e) {
            log.error("Open session failed", e);
            session.getTransaction().rollback();
        } finally {
            if(session != null) {
                session.close();
            }
        }
        return null;
    }

    @Override
    public List<Employee> viewPortion(int start, int viewMax) {
        Session session = null;
        try {
            session = factory.openSession();
            session.beginTransaction();
            return (List<Employee>)session.createCriteria(Employee.class).setFirstResult(start).setMaxResults(viewMax).list();
        } catch (HibernateException e) {
            log.error("Open session failed", e);
            session.getTransaction().rollback();
        } finally {
            if(session != null) {
                session.close();
            }
        }
        return null;
    }

    @Override
    public List<Employee> findByMoreCharterCapital(double charterCapital) {
        Session session = null;
        try {
            session = factory.openSession();
            session.beginTransaction();
            return (List<Employee>)session.createCriteria(Employee.class).createCriteria("work").add(Restrictions.gt("charterCapital",charterCapital)).list();
        } catch (HibernateException e) {
            log.error("Open session failed", e);
            session.getTransaction().rollback();
        } finally {
            if(session != null) {
                session.close();
            }
        }
        return null;
    }

    @Override
    public List<Employee> findEmployeesByAgeInCompany(String companyName, Integer age) {
        Session session = null;
        try {
            session = factory.openSession();
            session.beginTransaction();
            return (List<Employee>)session.createCriteria(Employee.class).add(Restrictions.eq("age",age)).createCriteria("work").add(Restrictions.eq("name", companyName)).list();
        } catch (HibernateException e) {
            log.error("Open session failed", e);
            session.getTransaction().rollback();
        } finally {
            if(session != null) {
                session.close();
            }
        }
        return null;
    }


}
