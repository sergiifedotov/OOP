package session14.dao;

import org.apache.log4j.Logger;
import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import session14.domain.Employee;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by ZaR on 22.02.15.
 */

public class EmployeeDaoImpl implements EmployeeDao {
    private static Logger log = Logger.getLogger(EmployeeDaoImpl.class);
    private SessionFactory factory;


    public EmployeeDaoImpl() {
    }
    public EmployeeDaoImpl(SessionFactory factory) {
        this.factory = factory;
    }



    @Override
    public void create(Employee empl) {
        Session session = null;
        try {
            session = factory.openSession();
            session.beginTransaction();
            Long id = (Long) session.save(empl);
            session.getTransaction().commit();
        } catch (HibernateException e) {
            log.error("Open session failed", e);
            session.getTransaction().rollback();
        } finally {
            if (session != null) {
                session.close();
            }
        }
//        factory.getCurrentSession().save(empl);
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
//        return (Employee)factory.getCurrentSession().get(Employee.class, id);
    }


    @Override
    public List<Employee> findAll(){
        List<Employee> list = new ArrayList<>();

        Session session = null;
        try {
            session = factory.openSession();
           // session.beginTransaction();
            list = session.createCriteria(Employee.class).list();

           // session.getTransaction().commit();
        } catch (HibernateException e) {
            log.error("Open session failed", e);
            //session.getTransaction().rollback();
        } finally {
            if (session != null) {
                session.close();
            }
        }
//        List<Employee> list = new ArrayList<>();
//        Session session = factory.getCurrentSession();
//        list = session.createCriteria(Employee.class).list();
        return list;
    }
}
