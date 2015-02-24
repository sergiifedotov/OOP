package session14.task2.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import session14.task2.dao.EmployeeDao;
import session14.task2.domain.Employee;

import java.util.List;

/**
 *
 */
@Service
@Transactional
public class EmployeeServiceImpl implements EmployeeService {

    @Autowired
    private EmployeeDao employeeDao;

    public EmployeeServiceImpl() {
    }

    public EmployeeServiceImpl(EmployeeDao dao) {
        employeeDao = dao;
    }


    @Override
    public List<Employee> findAll() {
        return employeeDao.findAll();
    }

}
