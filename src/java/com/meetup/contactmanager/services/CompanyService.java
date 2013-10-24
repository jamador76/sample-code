package com.meetup.contactmanager.services;

import com.meetup.contactmanager.entities.Company;
import java.util.List;

/**
 * Interface that provides methods for Company objects
 */
public interface CompanyService {
    /**
     * Returns a list of Company objects
     * @return a List of Companies
     */
    public List<Company> list();
    public Company getByName(String name);
    public Company save(Company company);
    public Company deserialize(String[] data);
}