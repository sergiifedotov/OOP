package session14.task2;

import org.hibernate.Criteria;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

/**
 * Created by vladimir on 22.02.2015.
 */

@Repository("employeeDao")
@Transactional
public class EmployeeDaoImpl implements EmployeeDao {
    @Autowired(required = true)
    SessionFactory sessionFactory; // фабрика берется из контекста

    public EmployeeDaoImpl(){
    }

    @Override
    public Long create(Employee employee) {
        return (Long) sessionFactory.getCurrentSession().save(employee);
    }

    @Override
    @Transactional(readOnly = true)
    public Employee read(Long id) {
        return (Employee) sessionFactory.getCurrentSession().get(Employee.class, id);
    }

    @Override
    public void update(Employee employee) {
        sessionFactory.getCurrentSession().update(employee);
    }

    @Override
    public void delete(Employee employee) {
        sessionFactory.getCurrentSession().delete(employee);
    }

    @Override
    @Transactional(readOnly = true)
    public List<Employee> findAll() {
        Session session = sessionFactory.getCurrentSession();
        Criteria criteria = session.createCriteria(Employee.class);
        return (List<Employee>) criteria.list();
    }
}
