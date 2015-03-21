package session11.company.dao;

import session11.company.domain.Employee;

import java.util.List;

/**
 * Created by warit on 15.02.2015.
 */
public interface EmployeeDao {
    Long create(Employee employee);
    Employee read(Long id);
    boolean update(Employee employee);
    boolean delete(Employee employee);
    List<Employee> findAll();
}
