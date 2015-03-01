package hw7.springnotes.dao;

import hw7.springnotes.domain.Memory;
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
public class MemoryDaoImpl implements MemoryDao {
    @Qualifier("mySessionFactoryHW7")
    @Autowired(required = true)
    private SessionFactory sessionFactory; // фабрика берется из контекста

    public MemoryDaoImpl() {
    }

    @Override
    public Long create(Memory memory) {
        return (Long) sessionFactory.getCurrentSession().save(memory);
    }

    @Override
    @Transactional(readOnly = true)
    public Memory read(Long id) {
        return (Memory) sessionFactory.getCurrentSession().get(Memory.class, id);
    }

    @Override
    public boolean update(Memory memory) {
        sessionFactory.getCurrentSession().update(memory);
        return true;
    }

    @Override
    public void delete(Memory memory) {
        sessionFactory.getCurrentSession().delete(memory);
    }

    @Override
    @Transactional(readOnly = true)
    public List<Memory> findAll() {
        Session session = sessionFactory.getCurrentSession();
        Criteria criteria = session.createCriteria(Memory.class);
        return criteria.list();
    }
}
