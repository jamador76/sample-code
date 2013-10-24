package com.meetup.contactmanager.services;

import com.meetup.contactmanager.dao.ContactDao;
import com.meetup.contactmanager.entities.Contact;
import com.meetup.contactmanager.utils.DateUtil;
import java.text.ParseException;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

@Service("contactService")
@Transactional(propagation=Propagation.REQUIRED, readOnly=true)
public class ContactServiceImpl implements ContactService {
    @Autowired
    private ContactDao contactDao;

    @Override
    public List<Contact> list() {
        return contactDao.getContacts();
    }
    
    @Override
    @Transactional(propagation=Propagation.REQUIRED, readOnly=false)
    public Contact save(Contact contact) {
        return contactDao.save(contact);
    }
    
    @Override
    public Contact deserialize(String[] data, String dateFormat) throws ParseException {
        Contact contact = new Contact();
        
        try {
            contact.setName(data[0]);
            contact.setUserId(data[1]);
            contact.setTitle(data[2]);
            contact.setMemberId(Integer.parseInt(data[3]));
            contact.setJoinedGroupOn(DateUtil.formatDate(data[5], dateFormat));
            contact.setLastVisitedGroupOn(DateUtil.formatDate(data[6], dateFormat));
            contact.setLastAttended(DateUtil.formatDate(data[7], dateFormat));
            contact.setTotalRsvps(Short.parseShort(data[8]));
            contact.setRsvpedYes(Short.parseShort(data[9]));
            contact.setRsvpedMaybe(Short.parseShort(data[10]));
            contact.setRsvpedNo(Short.parseShort(data[11]));
            contact.setMeetupsAttended(Short.parseShort(data[12]));
            contact.setNoShows(Short.parseShort(data[13]));
            contact.setIntro(data[14].charAt(0));
            contact.setPhoto(data[15].charAt(0));
            contact.setAssistantOrganizer(data[16].charAt(0));
            contact.setMailingList(data[17]);
            contact.setMemberProfileUrl(data[18]);
            if (data.length == 20) {
                contact.setPhone(data[19]);
            }
        } catch (ParseException pe) {
            //TODO: handle exception
        }
        
        return contact;
    }
}