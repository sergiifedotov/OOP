package hw7.springnotes.dao;

import hw7.springnotes.domain.CPU;
import org.hibernate.Criteria;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

/**
 * Created by vladimir on 23.02.2015.
 */
@Repository
@Transactional
public class CPUDaoImpl implements CPUDao {
    @Qualifier("mySessionFactoryHW7")
    @Autowired(required = true)
    private SessionFactory sessionFactory;

    public CPUDaoImpl() {
    }

    @Override
    public Long create(CPU cpu) {
        return (Long) sessionFactory.getCurrentSession().save(cpu);
    }

    @Override
    @Transactional(readOnly = true)
    public CPU read(Long id) {
        return (CPU) sessionFactory.getCurrentSession().get(CPU.class, id);
    }

    @Override
    public void update(CPU cpu) {
        sessionFactory.getCurrentSession().update(cpu);
    }

    @Override
    public void delete(CPU cpu) {
        sessionFactory.getCurrentSession().delete(cpu);
    }

    @Override
    @Transactional(readOnly = true)
    public List<CPU> findAll() {
        Session session = sessionFactory.getCurrentSession();
        Criteria criteria = session.createCriteria(CPU.class);
        return (List<CPU>) criteria.list();
    }
}
