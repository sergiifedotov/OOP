package session12;

import org.hibernate.Criteria;
import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.criterion.Projections;
import org.hibernate.criterion.Restrictions;

import java.util.List;

/**
 * Created by vladimir on 11.02.2015.
 *
 */
public class EmployeeDaoImpl implements EmployeeDao {
    private SessionFactory sessionFactory = HibernateUtil.getSessionFactory();

    public EmployeeDaoImpl() {
    }

    public EmployeeDaoImpl(SessionFactory sessionFactory) {
        this();
        this.sessionFactory = sessionFactory;
    }

    @Override
    public Long create(Employee employee) {
        Session session = null;
        try {
            session = sessionFactory.openSession();
            session.beginTransaction();
            Long id = (Long)session.save(employee);
            session.getTransaction().commit();
            return id;
        } catch (HibernateException e) {
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
        Session session = null;
        try {
            session = sessionFactory.openSession();
            session.beginTransaction();
            return (Employee) session.get(Employee.class, id);
        } catch (HibernateException e) {
            session.getTransaction().rollback();
        } finally {
            if(session != null) {
                session.close();
            }
        }
        return null;
    }

    @Override
    public boolean update(Employee employee) {
        Session session = null;
        try {
            session = sessionFactory.openSession();
            session.beginTransaction();
            session.update(employee);
            session.getTransaction().commit();
            return true;
        } catch (HibernateException e) {
            session.getTransaction().rollback();
        } finally {
            if(session != null) {
                session.close();
            }
        }
        return false;
    }

    @Override
    public boolean delete(Employee employee) {
        Session session = null;
        try {
            session = sessionFactory.openSession();
            session.beginTransaction();
            session.delete(employee);
            session.getTransaction().commit();
            return true;
        } catch (HibernateException e) {
            session.getTransaction().rollback();
        } finally {
            if(session != null) {
                session.close();
            }
        }
        return false;
    }

    @Override
    public List<Employee> findAll() {
        Session session = null;
        try {
            session = sessionFactory.openSession();
            Criteria criteria = session.createCriteria(Employee.class);
            return criteria.list();
        } catch (HibernateException e) {
            session.getTransaction().rollback();
        } finally {
            if(session != null) {
                session.close();
            }
        }
        return null;
    }

    @Override
    public List<Employee> findEmployeesByCapital(Long capital) {
        Session session = null;
        try {
            session = sessionFactory.openSession();
            Criteria criteria = session.createCriteria(Employee.class)
                    .createCriteria("company")
                    .add(Restrictions.ge("authorizedCapital", capital));
            return criteria.list();
        } catch (HibernateException e) {
            session.getTransaction().rollback();
        } finally {
            if(session != null) {
                session.close();
            }
        }
        return null;
    }

    @Override
    public List<Employee> findEmployeesByCompanyAndAge(String companyName, Integer age) {
        Session session = null;
        try {
            session = sessionFactory.openSession();
            Criteria criteria = session.createCriteria(Employee.class)
                    .add(Restrictions.eq("age", age))
                    .createCriteria("company")
                    .add(Restrictions.ge("name", companyName));
            return criteria.list();
        } catch (HibernateException e) {
            session.getTransaction().rollback();
        } finally {
            if(session != null) {
                session.close();
            }
        }
        return null;
    }

    @Override
    public Long rowCount() {
        Session session = null;
        try {
            session = sessionFactory.openSession();
            Criteria criteria = session.createCriteria(Employee.class)
                    .setProjection(Projections.rowCount());
            return (Long) criteria.uniqueResult();
        } catch (HibernateException e) {
            session.getTransaction().rollback();
        } finally {
            if(session != null) {
                session.close();
            }
        }
        return null;
    }

    @Override
    public List<Employee> getPortion(int firstResult, int maxResults) {
        Session session = null;
        try {
            session = sessionFactory.openSession();
            Criteria criteria = session.createCriteria(Employee.class)
                    .setFirstResult(firstResult)
                    .setMaxResults(maxResults);
            return criteria.list();
        } catch (HibernateException e) {
            session.getTransaction().rollback();
        } finally {
            if(session != null) {
                session.close();
            }
        }
        return null;
    }

    @Override
    public void close() {
        sessionFactory.close();
    }
}
