package web.dao;

import org.springframework.transaction.annotation.Transactional;
import web.domain.Employee;

import java.util.List;

/**
 * Created with IntelliJ IDEA.
 * User: al1
 * Date: 3/16/13
 */
public interface EmployeeDao {
    @Transactional(readOnly = true)
    Employee read(Long id);

    boolean update(Employee employee);

    boolean delete(Employee employee);

    List<Employee> findAll();
}
