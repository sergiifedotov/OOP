package session14.task2;

import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import javax.transaction.Transactional;
import java.util.List;

/**
 * Created by vladimir on 22.02.2015.
 */

@Repository("employeeDao")
@Transactional
public class EmployeeDao {
    @Autowired(required = true)
    SessionFactory sessionFactory;

    public EmployeeDao(){
    }

    public Long create(Employee employee) {
        return (Long) sessionFactory.getCurrentSession().save(employee);
    }

    public Employee read(Long id) {
        return (Employee) sessionFactory.getCurrentSession().get(Employee.class, id);
    }

    public void update(Employee employee) {
        sessionFactory.getCurrentSession().update(employee);
    }

    public void delete(Employee employee) {
        sessionFactory.getCurrentSession().delete(employee);
    }

    public List<Employee> findAll() {
        return (List<Employee>) sessionFactory.getCurrentSession().createCriteria(Employee.class).list();
    }
}
