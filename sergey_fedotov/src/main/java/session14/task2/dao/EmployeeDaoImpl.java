package session14.task2.dao;


import org.apache.log4j.Logger;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;
import session14.task2.domain.Employee;

import java.util.List;

/**
 *
 */
@Repository
@Transactional
public class EmployeeDaoImpl implements EmployeeDao {
    private static Logger log = Logger.getLogger(EmployeeDaoImpl.class);

    @Autowired
    private SessionFactory factory;

    public EmployeeDaoImpl(SessionFactory factory) {
        this.factory = factory;
    }

    public EmployeeDaoImpl() {
    }

    @Override
    @Transactional(readOnly = true)
    public List<Employee> findAll() {
        return (List)factory.getCurrentSession().createCriteria(Employee.class).list();
    }

    public SessionFactory getFactory() {
        return factory;
    }

    public void setFactory(SessionFactory factory) {
        this.factory = factory;
    }

}
