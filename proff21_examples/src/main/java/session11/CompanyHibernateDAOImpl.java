package session11;

import org.apache.log4j.Logger;
import org.hibernate.Criteria;
import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.criterion.Projections;
import org.hibernate.criterion.Restrictions;

import java.util.List;

/**
 * Created by stan on 15.02.15.
 */
public class CompanyHibernateDAOImpl implements CompanyDao {
    private static final Logger LOGGER = Logger.getLogger(CompanyHibernateDAOImpl.class);

    private SessionFactory factory;

    public CompanyHibernateDAOImpl(SessionFactory factory) {
        this.factory = factory;
    }

    public Long create(Company company) {
        Long id = null;
        Session session = null;
        try {
            session = factory.openSession();
            session.beginTransaction();
            //    for (Employee employee : company.getEmployees()) {
            //        session.save(employee);
            //    }
            id = (Long) session.save(company);
            session.getTransaction().commit();
//            session.flush();
        } catch (HibernateException e) {
            LOGGER.error("Error creating Company record", e);
            session.getTransaction().rollback();
        } finally {
            if (null != session) {
                session.close();
            }
        }
        return id;
    }

    public Company read(final Long id) {
        Session session = null;
        Company company = null;
        try {
            session = factory.openSession();
            company = (Company) session.get(Company.class, id);
        } catch (HibernateException e) {
            LOGGER.error("Error reading Company record", e);
        } finally {
            if (null != session) {
                session.close();
            }
        }
        return company;
    }

    public void update(final Company company) {
        Long id = null;
        Session session = null;
        try {
            session = factory.openSession();
            session.beginTransaction();
            session.update(company);
            session.getTransaction().commit();
            session.flush();
        } catch (HibernateException e) {
            LOGGER.error("Error updating Company record", e);
            session.getTransaction().rollback();
        } finally {
            if (null != session) {
                session.close();
            }
        }
    }

    public void delete(final Company company) {
        Long id = null;
        Session session = null;
        try {
            session = factory.openSession();
            session.beginTransaction();
            session.delete(company);
            session.getTransaction().commit();
            session.flush();
        } catch (HibernateException e) {
            LOGGER.error("Error deleting Company record", e);
            session.getTransaction().rollback();
        } finally {
            if (null != session) {
                session.close();
            }
        }
    }

    public List<Company> findAll() {
        List<Company> companies = null;
        Session session = null;
        try {
            session = factory.openSession();
            final Criteria criteria = session.createCriteria(Company.class);
            companies = criteria.list();
        } catch (HibernateException e) {
            LOGGER.error("Error getting Companies", e);
        } finally {
            if (null != session) {
                session.close();
            }
        }
        return companies;
    }

    public List<Company> findAllPartially(final int startRange, final int range) {
        List<Company> companies = null;
        Session session = null;
        try {
            session = factory.openSession();
            final Criteria criteria = session.createCriteria(Company.class).setFirstResult(startRange).setMaxResults(range);
            companies = criteria.list();
        } catch (HibernateException e) {
            LOGGER.error("Error getting Companies", e);
        } finally {
            if (null != session) {
                session.close();
            }
        }
        return companies;
    }

    public Long rowsCount() {
        Long result = 0L;
        Session session = null;
        try {
            session = factory.openSession();
            final Criteria criteria = session.createCriteria(Company.class).setProjection(Projections.rowCount());
            result = (Long)criteria.uniqueResult();
        } catch (HibernateException e) {
            LOGGER.error("Error getting count", e);
        } finally {
            if (null != session) {
                session.close();
            }
        }
        return result;
    }

    public Company findByName(final String name) {
        Company company = null;
        Session session = null;
        try {
            session = factory.openSession();
            final Criteria criteria = session.createCriteria(Company.class).add(Restrictions.eq("name", name));
            company = (Company) criteria.uniqueResult();
        } catch (HibernateException e) {
            LOGGER.error("Error getting Company", e);
        } finally {
            if (null != session) {
                session.close();
            }
        }
        return company;
    }

}