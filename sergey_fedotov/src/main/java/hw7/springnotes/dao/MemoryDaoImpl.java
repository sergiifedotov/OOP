package hw7.springnotes.dao;

import hw7.springnotes.domain.Memory;
import hw7.springnotes.util.HibernateUtil;
import org.apache.log4j.Logger;
import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

/**
 *
 */
@Repository
@Transactional
public class MemoryDaoImpl implements MemoryDao {
    private static Logger log = Logger.getLogger(MemoryDaoImpl.class);

    @Autowired
    private SessionFactory factory;

    public static void main(String[] args) {

        MemoryDaoImpl memoryDaoImpl = new MemoryDaoImpl();

        System.out.println(memoryDaoImpl.findAll().toString());

    }

    public MemoryDaoImpl() {

    }

    @Override
    public Long create(Memory memory) {
        return (Long) factory.getCurrentSession().save(memory);
    }

    @Override
    @Transactional(readOnly = true)
    public Memory read(Long id) {
        return (Memory) factory.getCurrentSession().get(Memory.class,id);
    }

    @Override
    public boolean update(Memory memory) {
        factory.getCurrentSession().update(memory);
        return true;
    }

    @Override
    public boolean delete(Memory memory) {
        factory.getCurrentSession().delete(memory);
        return true;
    }

    @Override
    @Transactional(readOnly = true)
    public List<Memory> findAll() {
        return (List)factory.getCurrentSession().createCriteria(Memory.class).list();
    }

}