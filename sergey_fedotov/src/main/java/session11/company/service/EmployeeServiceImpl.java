package session11.company.service;


import session11.company.dao.EmployeeDao;
import session11.company.domain.Employee;

import java.util.List;

/**
 *
 */
public class EmployeeServiceImpl implements EmployeeService {
    private EmployeeDao employeeDao;

    public EmployeeServiceImpl(EmployeeDao dao) {
        employeeDao = dao;
    }

    @Override
    public List<Employee> findAll() {
        return employeeDao.findAll();
    }

    @Override
    public Long add(Employee employee) {
        return employeeDao.create(employee);
    }
}
