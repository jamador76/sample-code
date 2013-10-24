package com.meetup.contactmanager.services;

import com.meetup.contactmanager.dao.CompanyDao;
import com.meetup.contactmanager.entities.Company;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

/**
 * Class that implements CompanyService and is used as a service for
 * Company data access objects
 */
@Service("companyService")
@Transactional(propagation=Propagation.REQUIRED, readOnly=true)
public class CompanyServiceImpl implements CompanyService {
    @Autowired
    private CompanyDao companyDao;

    /**
     * Returns a list of Company objects
     * @return A list of Companies
     */
    @Override
    public List<Company> list() {
        return companyDao.getCompanies();
    }
    
    @Override
    public Company getByName(String name) {
        return companyDao.getByName(name);
    }
    
    @Override
    @Transactional(propagation=Propagation.REQUIRED, readOnly=false)
    public Company save(Company company) {
        return companyDao.save(company);
    }
    
    @Override
    public Company deserialize(String[] data) {
        Company company = new Company();
        company.setName(data[4]);
        
        return company;
    }
}