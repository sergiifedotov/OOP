package session14.hi.dao;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;
import session14.hi.domain.Employee;

import java.util.List;

@Repository
public class EmployeeDaoImpl implements EmployeeDao {

    @Autowired(required = true)
    private SessionFactory mySessionFactory;

    public EmployeeDaoImpl() {

    }

    @Override
    @Transactional
    public Long create(Employee employee) {
        Session session = mySessionFactory.getCurrentSession();
        return (Long) session.save(employee);
    }

    @Override
    @Transactional
    public Employee read(Long id) {
        Session session = mySessionFactory.getCurrentSession();
        return (Employee) session.get(Employee.class, id);
    }

    @Override
    @Transactional
    public boolean update(Employee employee) {
        return false;
    }

    @Override
    @Transactional
    public boolean delete(Employee employee) {
        return false;
    }

    @Override
    @Transactional
    public List<Employee> findAll() {
        Session session = mySessionFactory.getCurrentSession();
        return session.createCriteria(Employee.class).list();
    }

}
