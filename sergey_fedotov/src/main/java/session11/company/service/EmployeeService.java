package session11.company.service;

import session11.company.domain.Employee;

import java.util.List;

/**
 *
 */
public interface EmployeeService {
    Long add(Employee employee);
    List<Employee> findAll();
}
