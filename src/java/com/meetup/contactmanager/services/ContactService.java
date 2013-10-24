package com.meetup.contactmanager.services;

import com.meetup.contactmanager.entities.Contact;
import java.text.ParseException;
import java.util.List;

/**
 * 
 * Interface to provide methods for Contacts
 */
public interface ContactService {
    public List<Contact> list();
    public Contact save(Contact contact);
    public Contact deserialize(String[] data, String dateFormat) throws ParseException;
}
