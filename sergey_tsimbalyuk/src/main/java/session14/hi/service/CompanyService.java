package session14.hi.service;

import session14.hi.domain.Company;
import session14.hi.domain.Employee;

import java.util.List;


public interface CompanyService {

    Long createCompany(String nameCompany);

    Long createEmployee(String nameEmployee);

    boolean toEmploy(Company company, Employee employee);

    List<Employee> findAllEmployforCompany(Company company);

}
