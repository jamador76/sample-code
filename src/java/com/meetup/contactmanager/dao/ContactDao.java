package com.meetup.contactmanager.dao;

import com.meetup.contactmanager.entities.Contact;
import java.util.List;
import org.hibernate.Criteria;
import org.springframework.stereotype.Repository;

@Repository("contactDao")
public class ContactDao extends Dao<Contact> {
    public ContactDao() {
        super(Contact.class);
    }
    
    public List<Contact> getContacts() {
        Criteria criteria = getCurrentSession().createCriteria(Contact.class);
        return findAll(criteria);
    }
}