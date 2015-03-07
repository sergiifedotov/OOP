package web.dao;

import web.domain.Employee;
import org.hibernate.SessionFactory;
import org.hibernate.Session;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

/**
 * Created with IntelliJ IDEA.
 * UserDao: al1
 * Date: 3/16/13
 */
@Repository
public class EmployeeDaoImpl implements EmployeeDao {

    @Autowired
    private SessionFactory factory;

    @Transactional(readOnly = true)
    @Override
    public List<Employee> findAll() {
        Session session = factory.getCurrentSession();
        return session.createCriteria(Employee.class).list();
    }
}
