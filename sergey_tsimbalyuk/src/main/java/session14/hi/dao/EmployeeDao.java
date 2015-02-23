package session14.hi.dao;

import session14.hi.domain.Employee;

import java.util.List;

/**
 * Created by Sergey Tsimbalyuk
 * on 21.12.2014.
 */
public interface EmployeeDao {

    Long create(Employee employee);

    Employee read(Long id);

    boolean update(Employee employee);

    boolean delete(Employee employee);

    List<Employee> findAll();

}
