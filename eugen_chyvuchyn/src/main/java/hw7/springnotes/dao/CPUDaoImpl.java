package hw7.springnotes.dao;

import hw7.springnotes.domain.CPU;
import org.apache.log4j.Logger;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * Created by Chuvychin on 27.02.2015.
 */

@Repository
public class CPUDaoImpl implements CPUDao {
    private static Logger log = Logger.getLogger(CPUDaoImpl.class);


    @Autowired
    private SessionFactory factory;


    public CPUDaoImpl() {
    }

    @Override
    public Long create(CPU cpu) {
       Session session = factory.getCurrentSession();
        Long id = (long)session.save(cpu);
        return id;
    }


    @Override
    public CPU read(Long ig) {
       Session session = factory.getCurrentSession();
        return (CPU)session.get(CPU.class,ig);
    }

    @Override
    public boolean update(CPU cpu) {
        Session session = factory.getCurrentSession();
        session.update(cpu);
        return true;

    }

    @Override
    public boolean delete(CPU cpu) {
        Session session = factory.getCurrentSession();
        session.delete(cpu);
        return true;
    }

    @Override
    public List<CPU> findAll() {
        Session session = factory.getCurrentSession();

        return session.createCriteria(CPU.class).list();
    }


}
