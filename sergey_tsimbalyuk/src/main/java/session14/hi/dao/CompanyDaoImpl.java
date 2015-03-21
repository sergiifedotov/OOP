package session14.hi.dao;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;
import session14.hi.domain.Company;

import java.util.List;

@Repository
public class CompanyDaoImpl implements CompanyDao {

    @Qualifier("mySessionFactory")
    @Autowired(required = true)
    private SessionFactory sessionFactory;

    @Transactional
    public Long create(Company company) {
        Session session = sessionFactory.getCurrentSession();
        return (Long) session.save(company);
    }

    @Transactional
    public Company read(Long id) {
        Session session = sessionFactory.getCurrentSession();
        return (Company) session.get(Company.class, id);
    }

    @Transactional
    public void update(Company company) {
        Session session = sessionFactory.getCurrentSession();
        session.update(company);
    }

    @Transactional
    public void delete(Company company) {
        Session session = sessionFactory.getCurrentSession();
        session.delete(company);
    }

    @Transactional
    public List<Company> findAll() {
        Session session = sessionFactory.getCurrentSession();
        return session.createCriteria(Company.class).list();
    }

}
