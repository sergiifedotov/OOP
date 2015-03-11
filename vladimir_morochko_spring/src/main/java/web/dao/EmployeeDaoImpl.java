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
 * User: al1
 * Date: 3/16/13
 */
@Repository
public class EmployeeDaoImpl implements EmployeeDao {

    @Autowired
    private SessionFactory sessionFactory;

    public EmployeeDaoImpl() {
    }

    public Long create(Employee employee) {
        return (Long) sessionFactory.getCurrentSession().save(employee);
    }

    @Transactional(readOnly = true)
    @Override
    public Employee read(Long id) {
        return (Employee) sessionFactory.getCurrentSession().get(Employee.class, id);
    }

    @Override
    public boolean update(Employee employee) {
        sessionFactory.getCurrentSession().update(employee);
        return true;
    }

    @Override
    public boolean delete(Employee employee) {
        sessionFactory.getCurrentSession().delete(employee);
        return true;
    }

    @Transactional(readOnly = true)
    @Override
    public List<Employee> findAll() {
        Session session = sessionFactory.getCurrentSession();
        return session.createCriteria(Employee.class).list();
    }
}
