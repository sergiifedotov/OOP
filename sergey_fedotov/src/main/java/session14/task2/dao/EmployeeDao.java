package session14.task2.dao;

import session14.task2.domain.Employee;

import java.util.List;

/**
 * Created with IntelliJ IDEA.
 * User: al1
 * Date: 20.09.14
 */
public interface EmployeeDao {

    List<Employee> findAll();

}
