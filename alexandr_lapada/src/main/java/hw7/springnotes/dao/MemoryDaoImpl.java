package hw7.springnotes.dao;

import hw7.springnotes.domain.Memory;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

/**
 * Created by sanya on 24.02.2015.
 */
@Repository
@Transactional
public class MemoryDaoImpl implements MemoryDao {

    @Autowired
    private SessionFactory factory;

    public MemoryDaoImpl(){

    }

    @Override
    public Long create(Memory memory) {
        Session session = factory.openSession();
        Long id = (long)session.save(memory);
        return id;
    }

    @Override
    @Transactional(readOnly = true)
    public Memory read(Long id) {
        Session session = factory.getCurrentSession();
        return (Memory)session.get(Memory.class,id);
    }

    @Override
    public boolean update(Memory memory) {
        Session session = factory.getCurrentSession();
        session.update(memory);
        return false;
    }

    @Override
    public boolean delete(Memory memory) {
        Session session = factory.getCurrentSession();
        session.delete(memory);
        return false;
    }

    @Override
    @Transactional(readOnly = true)
    public List<Memory> findAll() {
        Session session = factory.getCurrentSession();
        List<Memory> list = session.createCriteria(Memory.class).list();
        return list;
    }
}
