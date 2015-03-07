package hw7.springnotes.dao;

import hw7.springnotes.domain.Memory;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * Created by Chuvychin on 27.02.2015.
 */
@Repository
public class MemoryDaoImpl implements MemoryDao {


    @Autowired
    private SessionFactory factory;

    public MemoryDaoImpl() {
    }

    @Override
    public Long create(Memory memory) {
        Session session = factory.getCurrentSession();
        Long id = (long)session.save(memory);
        return id;
    }

    @Override
    public Memory read(Long ig) {
        Session session = factory.getCurrentSession();
        return (Memory)session.get(Memory.class,ig);
    }

    @Override
    public boolean update(Memory memory) {
        Session session = factory.getCurrentSession();
        session.update(memory);
        return true;
    }

    @Override
    public boolean delete(Memory memory) {
        Session session = factory.getCurrentSession();
        session.delete(memory);
        return true;
    }

    @Override
    public List<Memory> findAll() {
        Session session = factory.getCurrentSession();

        return session.createCriteria(Memory.class).list();
    }
}
