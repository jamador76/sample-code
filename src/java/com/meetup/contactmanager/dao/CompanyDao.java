package com.meetup.contactmanager.dao;

import com.meetup.contactmanager.entities.Company;
import java.util.List;
import org.hibernate.Criteria;
import org.hibernate.criterion.Restrictions;
import org.springframework.stereotype.Repository;

@Repository("companyDao")
public class CompanyDao extends Dao<Company> {
    public CompanyDao() {
        super(Company.class);
    }
    
    public Company getByName(String name) {
        Criteria criteria = getCurrentSession().createCriteria(Company.class);
        criteria.add(Restrictions.eq("name", name));
        Company company = get(criteria);
        return company;
    }
    
    public List<Company> getCompanies() {
        Criteria criteria = getCurrentSession().createCriteria(Company.class);
        return findAll(criteria);
    }
}