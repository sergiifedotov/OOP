package hw7.springnotes.dao;

import hw7.springnotes.domain.CPU;
import org.apache.log4j.Logger;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

/**
 * Created by Chuvychin on 27.02.2015.
 */

@Repository
@Transactional
public class CPUDaoImpl implements CPUDao {
    private static Logger log = Logger.getLogger(CPUDao.class);

    private SessionFactory factory;

    @Autowired
    public CPUDaoImpl(SessionFactory factory) {
        this.factory = factory;
    }

    public CPUDaoImpl() {
    }

    @Override
    public Long create(CPU cpu) {
        return null;
    }

    @Transactional (readOnly = true)
    @Override
    public CPU read(Long ig) {
        return null;
    }

    @Override
    public boolean update(CPU cpu) {
        return false;
    }

    @Override
    public boolean delete(CPU cpu) {
        return false;
    }

    @Transactional (readOnly = true)
    @Override
    public List<CPU> findAll() {
        return null;
    }
}
