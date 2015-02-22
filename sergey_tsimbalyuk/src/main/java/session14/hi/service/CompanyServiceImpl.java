package session14.hi.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import session14.hi.dao.CompanyDao;
import session14.hi.dao.EmployeeDao;
import session14.hi.domain.Company;
import session14.hi.domain.Employee;

import java.util.ArrayList;
import java.util.List;


@Service
@Transactional
public class CompanyServiceImpl implements CompanyService {

    @Autowired(required = true)
    EmployeeDao employeeDao;

    @Autowired(required = true)
    CompanyDao companyDao;

    public CompanyServiceImpl() {
    }

    @Override
    public Long createCompany(String nameCompany) {
        Company company = new Company();
        company.setNameCompany(nameCompany);
        return companyDao.create(company);
    }

    public Long createEmployee(String nameEmployee) {
        Employee employee = new Employee();
        employee.setName(nameEmployee);
        return employeeDao.create(employee);
    }

    public boolean toEmploy(Company company, Employee employee) {
        ArrayList<Employee> list = (ArrayList) companyDao.findAll();
        list.add(employee);
        employee.setCompany(company);
        company.setEmployees(list);
        companyDao.update(company);
        return false;
    }

    @Transactional(readOnly = true)
    public List<Employee> findAllEmployforCompany(Company company) {
        return null;
    }

}
