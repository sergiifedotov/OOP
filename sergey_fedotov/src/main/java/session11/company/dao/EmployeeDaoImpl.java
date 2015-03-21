package session11.company.dao;

import org.apache.log4j.Logger;
import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.criterion.Projections;

import session11.company.domain.Employee;
import session11.company.util.HibernateUtil;

import java.util.List;

/**
 */
public class EmployeeDaoImpl implements EmployeeDao {
    private static Logger log = Logger.getLogger(EmployeeDaoImpl.class);


    public static void main(String[] args) {


        EmployeeDaoImpl employeeDao = new EmployeeDaoImpl();

        Employee employee = new Employee("Jon1", 100.00);

        employeeDao.create(employee);

        //System.out.println(employeeDao.findAll().toString());

    }

    public EmployeeDaoImpl() {

    }

    @Override
    public Long create(Employee employee) {
        Session session = HibernateUtil.getSession();
        try {
            session.beginTransaction();
            Long id = (Long)session.save(employee);
            session.getTransaction().commit();
            return id;
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
    public Employee read(Long id) {

        Session session = HibernateUtil.getSession();
        try {
            return (Employee) session.get(Employee.class,id);
        } catch (HibernateException e) {
            log.error("Open session failed", e);
        } finally {
            if(session != null) {
                session.close();
            }
        }
        return null;
    }

    @Override
    public boolean update(Employee employee) {
        Session session = HibernateUtil.getSession();
        try {
            session.beginTransaction();
            session.update(employee);
            session.getTransaction().commit();
            return true;
        } catch (HibernateException e) {
            log.error("Open session failed", e);
            session.getTransaction().rollback();
            return false;
        } finally {
            if(session != null) {
                session.close();
            }

        }
    }

    @Override
    public boolean delete(Employee employee) {
        Session session = HibernateUtil.getSession();
        try {
            session.beginTransaction();
            session.delete(employee);
            session.getTransaction().commit();
            return true;
        } catch (HibernateException e) {
            log.error("Open session failed", e);
            session.getTransaction().rollback();
            return false;
        } finally {
            if(session != null) {
                session.close();
            }

        }
    }

    @Override
    public List<Employee> findAll() {
        Session session = HibernateUtil.getSession();
        try {
            return (List) session.createCriteria(Employee.class).list();
        } catch (HibernateException e) {
            log.error("Open session failed", e);
        } finally {
            if (session != null) {
                session.close();
            }

        }
        return null;

    }

    public Long rowsCount() {
        Session session = HibernateUtil.getSession();
        try {
            return (Long)session.createCriteria(Employee.class)
                    .setProjection(Projections.rowCount())
                    .uniqueResult();
        } finally {
            if(session != null) {
                session.close();
            }

        }
    }

    public List<Employee> getPortion(int firstResult, int maxResults) {
        Session session = HibernateUtil.getSession();
        try {
            return (List) session.createCriteria(Employee.class)
                    .setMaxResults(maxResults)
                    .setFirstResult(firstResult)
                    .list();
        } catch (HibernateException e) {
            log.error("Open session failed", e);
        } finally {
            if (session != null) {
                session.close();
            }

        }
        return null;

    }

}