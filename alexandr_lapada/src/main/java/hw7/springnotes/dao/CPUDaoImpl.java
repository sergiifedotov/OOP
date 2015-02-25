package hw7.springnotes.dao;


import hw7.springnotes.domain.CPU;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

/**
 * Created by sanya on 24.02.2015.
 */

@Repository
@Transactional
public class CPUDaoImpl implements CPUDao {

    @Autowired
    private SessionFactory sf;

    public CPUDaoImpl(){

    }

    public CPUDaoImpl(SessionFactory factory){
        this.sf = factory;
    }


    @Override
    public Long create(CPU cpu) {
        Session session = sf.getCurrentSession();
        Long id = (long)session.save(cpu);
        return id;
    }

    @Override
    @Transactional(readOnly = true)
    public CPU read(Long id) {
        Session session = sf.getCurrentSession();
        return (CPU)session.get(CPU.class,id);
    }

    @Override
    public boolean update(CPU cpu) {
        Session session = sf.getCurrentSession();
        session.update(cpu);
        return false;
    }

    @Override
    public boolean delete(CPU cpu) {
        Session session = sf.getCurrentSession();
        session.delete(cpu);
        return false;
    }

    @Override
    @Transactional(readOnly = true)
    public List<CPU> findAll() {
        Session session = sf.getCurrentSession();
        List<CPU> list = session.createCriteria(CPU.class).list();
        return list;
    }
}
