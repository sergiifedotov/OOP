package web.dao;

import web.domain.Employee;

import java.util.List;

/**
 * Created with IntelliJ IDEA.
 * UserDao: al1
 * Date: 3/16/13
 */
public interface EmployeeDao {
    List<Employee> findAll();
}
