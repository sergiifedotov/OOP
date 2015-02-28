package session13_14;

import org.apache.log4j.Logger;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

/**
 * Created by Chuvychin on 21.02.2015.
 */

@Repository
@Transactional
public class EmployeeDaoImpl implements EmployeeDao {
    private static Logger log = Logger.getLogger(EmployeeDaoImpl.class);

    private SessionFactory factory;

    @Autowired
    public EmployeeDaoImpl(SessionFactory factory) {
        this.factory = factory;
    }

    public EmployeeDaoImpl() {
    }




    @Override
    @Transactional (readOnly = true)
    public List<Employee> findAll() {
        return factory.getCurrentSession().createCriteria(Employee.class).list();
    }
}
