package hw7.springnotes.dao;

import hw7.notes.domain.CPU;
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
public class CPUDaoImpl implements CPUDao {
    @Qualifier("mySessionFactory")
    @Autowired
    private SessionFactory sessionFactory;

    @Override
    public Long create(CPU cpu) {
        return (Long) sessionFactory.getCurrentSession().save(cpu);
    }

    @Transactional(readOnly = true)
    @Override
    public CPU read(Long id) {
        return (CPU) sessionFactory.getCurrentSession().get(CPU.class, id);
    }

    @Override
    public boolean update(CPU cpu) {
        sessionFactory.getCurrentSession().update(cpu);
        return true;
    }

    @Override
    public boolean delete(CPU cpu) {
        sessionFactory.getCurrentSession().delete(cpu);
        return true;
    }

    @Override
    public List<CPU> findAll() {
        return (List<CPU>) sessionFactory.getCurrentSession().createCriteria(CPU.class).list();
    }
}