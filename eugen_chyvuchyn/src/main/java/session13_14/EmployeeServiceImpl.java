package session13_14;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * Created by Chuvychin on 22.02.2015.
 */

@Service
public class EmployeeServiceImpl implements EmployeeService {


    private EmployeeDao employeeDao;

    public  EmployeeServiceImpl(){

    }

    @Autowired
    public EmployeeServiceImpl(EmployeeDao employeeDao) {
        this.employeeDao = employeeDao;
    }

    @Override
    public List<Employee> findAll() {
        return employeeDao.findAll();
    }
}
