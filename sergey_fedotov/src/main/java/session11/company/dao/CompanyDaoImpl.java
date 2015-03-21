package session11.company.dao;

import org.apache.log4j.Logger;
import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.criterion.Projections;
import session11.company.domain.Company;
import session11.company.domain.Employee;
import session11.company.util.HibernateUtil;

import java.util.List;

/**
 */
public class CompanyDaoImpl implements CompanyDao {
    private static Logger log = Logger.getLogger(CompanyDaoImpl.class);


    public static void main(String[] args) {


        CompanyDaoImpl companyDaoImpl = new CompanyDaoImpl();

        Company company = new Company("Company1", 4000.00);

        companyDaoImpl.create(company);

        //System.out.println(companyDaoImpl.findAll().toString());

    }

    public CompanyDaoImpl() {

    }

    @Override
    public Long create(Company company) {
        Session session = HibernateUtil.getSession();
        try {
            session.beginTransaction();
            Long id = (Long)session.save(company);
            session.getTransaction().commit();
            return id;
        } catch (HibernateException e) {
            log.error("Open session failed", e);
            session.getTransaction().rollback();
        } finally {
            if(session != null) {
                session.close();
            }
            /*SessionFactory sessionFactory = HibernateUtil.getSessionFactory();
            if (sessionFactory != null) {
                sessionFactory.close();
            }*/
        }
        return null;
    }

    @Override
    public Company read(Long id) {

        Session session = HibernateUtil.getSession();
        try {
            return (Company) session.get(Company.class,id);
        } catch (HibernateException e) {
            log.error("Open session failed", e);
        } finally {
            if(session != null) {
                session.close();
            }
            SessionFactory sessionFactory = HibernateUtil.getSessionFactory();
            if (sessionFactory != null) {
                sessionFactory.close();
            }
        }
        return null;
    }

    @Override
    public boolean update(Company company) {
        Session session = HibernateUtil.getSession();
        try {
            session.beginTransaction();
            session.update(company);
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
            SessionFactory sessionFactory = HibernateUtil.getSessionFactory();
            if (sessionFactory != null) {
                sessionFactory.close();
            }
        }
    }

    @Override
    public boolean delete(Company company) {
        Session session = HibernateUtil.getSession();
        try {
            session.beginTransaction();
            session.delete(company);
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
            SessionFactory sessionFactory = HibernateUtil.getSessionFactory();
            if (sessionFactory != null) {
                sessionFactory.close();
            }
        }
    }

    @Override
    public List<Company> findAll() {
        Session session = HibernateUtil.getSession();
        try {
            return (List) session.createCriteria(Company.class).list();
        } catch (HibernateException e) {
            log.error("Open session failed", e);
        } finally {
            if (session != null) {
                session.close();
            }
            SessionFactory sessionFactory = HibernateUtil.getSessionFactory();
            if (sessionFactory != null) {
                sessionFactory.close();
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
            SessionFactory sessionFactory = HibernateUtil.getSessionFactory();
            if (sessionFactory != null) {
                sessionFactory.close();
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
            SessionFactory sessionFactory = HibernateUtil.getSessionFactory();
            if (sessionFactory != null) {
                sessionFactory.close();
            }
        }
        return null;

    }

}