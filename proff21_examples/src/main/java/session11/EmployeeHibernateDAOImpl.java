package session11;

/**
 * Created by stan on 15.02.15.
 */
import org.apache.log4j.Logger;
import org.hibernate.Criteria;
import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.criterion.Projections;
import org.hibernate.criterion.Restrictions;

import java.util.List;


public class EmployeeHibernateDAOImpl implements EmployeeDao {
    private static final Logger LOGGER = Logger.getLogger(EmployeeHibernateDAOImpl.class);

    private SessionFactory factory;

    public EmployeeHibernateDAOImpl(SessionFactory factory) {
        this.factory = factory;
    }

    public Long create(final Employee employee) {
        Long id = null;
        Session session = null;
        try {
            session = factory.openSession();
            session.beginTransaction();
            id = (Long) session.save(employee);
            session.getTransaction().commit();
            session.flush();
        } catch (HibernateException e) {
            LOGGER.error("Error creating Employee record", e);
            session.getTransaction().rollback();
        } finally {
            if (null != session) {
                session.close();
            }
        }
        return id;
    }

    public Employee read(final Long id) {
        Session session = null;
        Employee employee = null;
        try {
            session = factory.openSession();
            employee = (Employee) session.get(Employee.class, id);
        } catch (HibernateException e) {
            LOGGER.error("Error reading Employee record", e);
        } finally {
            if (null != session) {
                session.close();
            }
        }
        return employee;
    }

    public void update(final Employee employee) {
        Long id = null;
        Session session = null;
        try {
            session = factory.openSession();
            session.beginTransaction();
            session.update(employee);
            session.getTransaction().commit();
            session.flush();
        } catch (HibernateException e) {
            LOGGER.error("Error updating Employee record", e);
            session.getTransaction().rollback();
        } finally {
            if (null != session) {
                session.close();
            }
        }
    }

    public void delete(final Employee employee) {
        Long id = null;
        Session session = null;
        try {
            session = factory.openSession();
            session.beginTransaction();
            session.delete(employee);
            session.getTransaction().commit();
            session.flush();
        } catch (HibernateException e) {
            LOGGER.error("Error deleting Employee record", e);
            session.getTransaction().rollback();
        } finally {
            if (null != session) {
                session.close();
            }
        }
    }

    public List<Employee> findAll() {
        List<Employee> employees = null;
        Session session = null;
        try {
            session = factory.openSession();
            final Criteria criteria = session.createCriteria(Employee.class);
            employees = criteria.list();
        } catch (HibernateException e) {
            LOGGER.error("Error getting Employees", e);
        } finally {
            if (null != session) {
                session.close();
            }
        }
        return employees;
    }

    public List<Employee> findAllPartially(final int startRange, final int range) {
        List<Employee> employees = null;
        Session session = null;
        try {
            session = factory.openSession();
            final Criteria criteria = session.createCriteria(Employee.class).setFirstResult(startRange).setMaxResults(range);
            employees = criteria.list();
        } catch (HibernateException e) {
            LOGGER.error("Error getting Employees", e);
        } finally {
            if (null != session) {
                session.close();
            }
        }
        return employees;
    }

    @Override
    public Long rowsCount() {
        return null;
    }

    @Override
    public Long rowCount() {
        Session session = factory.openSession();
        try {
            return (Long) session.createCriteria(Company.class).setProjection(Projections.rowCount()).uniqueResult();
        } finally {
            if (session != null) {
                session.close();
            }
        }
    }

    public Employee findByName(final String firstName, final String lastName) {
        Employee employee = null;
        Session session = null;
        try {
            session = factory.openSession();
            final Criteria criteria = session.createCriteria(Employee.class).add(Restrictions.eq("firstName", firstName))
                    .add(Restrictions.eq("lastName", lastName));
            employee = (Employee) criteria.uniqueResult();
        } catch (HibernateException e) {
            LOGGER.error("Error getting Employee", e);
        } finally {
            if (null != session) {
                session.close();
            }
        }
        return employee;
    }
}