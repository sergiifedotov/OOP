package session11.company.service;

import session11.company.domain.Company;

import java.util.List;

/**
 *
 */
public interface CompanyService {
    Long add(Company company);
    List<Company> findAll();
}
