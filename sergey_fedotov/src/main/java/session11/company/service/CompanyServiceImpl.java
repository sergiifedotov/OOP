package session11.company.service;


import session11.company.dao.CompanyDao;
import session11.company.domain.Company;

import java.util.List;

/**
 *
 */
public class CompanyServiceImpl implements CompanyService {
    private CompanyDao companyDao;

    public CompanyServiceImpl(CompanyDao dao) {
        companyDao = dao;
    }

    @Override
    public List<Company> findAll() {
        return companyDao.findAll();
    }

    @Override
    public Long add(Company company) {
        return companyDao.create(company);
    }
}
