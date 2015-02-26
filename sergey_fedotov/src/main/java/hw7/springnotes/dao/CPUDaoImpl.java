package hw7.springnotes.dao;

import hw7.springnotes.domain.CPU;
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
public class CPUDaoImpl implements CPUDao {
    private static Logger log = Logger.getLogger(CPUDaoImpl.class);

    @Autowired
    private SessionFactory factory;

    public static void main(String[] args) {

        CPUDaoImpl cpuDaoImpl = new CPUDaoImpl();

        System.out.println(cpuDaoImpl.findAll().toString());

    }

    public CPUDaoImpl() {

    }

    @Override
    public Long create(CPU cpu) {
        return (Long) factory.getCurrentSession().save(cpu);
    }

    @Override
    @Transactional(readOnly = true)
    public CPU read(Long id) {
        return (CPU) factory.getCurrentSession().get(CPU.class,id);
    }

    @Override
    public boolean update(CPU cpu) {
        factory.getCurrentSession().update(cpu);
        return true;
    }

    @Override
    public boolean delete(CPU cpu) {
        factory.getCurrentSession().delete(cpu);
        return true;
    }

    @Override
    @Transactional(readOnly = true)
    public List<CPU> findAll() {
        return (List)factory.getCurrentSession().createCriteria(CPU.class).list();
    }

}