package hw7.springnotes.dao;

import hw7.springnotes.domain.Memory;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

/**
 * Created by Sergey Tsimbalyuk
 * on 27.02.15
 */
@Repository
@Transactional
public class MemoryDaoImpl implements MemoryDao{

    @Qualifier("mySessionFactory")
    @Autowired
    private SessionFactory sessionFactory;

    @Override
    public Long create(Memory memory) {
        return (Long) sessionFactory.getCurrentSession().save(memory);
    }

    @Transactional(readOnly = true)
    @Override
    public Memory read(Long id) {
        return (Memory) sessionFactory.getCurrentSession().get(Memory.class, id);
    }

    @Override
    public boolean update(Memory memory) {
        sessionFactory.getCurrentSession().update(memory);
        return true;
    }

    @Override
    public boolean delete(Memory memory) {
        sessionFactory.getCurrentSession().delete(memory);
        return true;
    }

    @Override
    public List<Memory> findAll() {
        return (List<Memory>) sessionFactory.getCurrentSession().createCriteria(Memory.class).list();
    }
}