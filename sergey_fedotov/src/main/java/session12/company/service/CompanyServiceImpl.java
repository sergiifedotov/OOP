package session12.company.service;


import session12.company.dao.CompanyDao;
import session12.company.domain.Company;

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
