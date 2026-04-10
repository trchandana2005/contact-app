public package com.contact;

import com.contact.dao.ContactDAO;
import com.contact.model.Contact;
import org.junit.Test;
import static org.junit.Assert.*;

public class ContactDAOTest {

    @Test
    public void testAddContact() {
        ContactDAO dao = new ContactDAO();

        Contact c = new Contact();
        c.setName("Chandu");

        dao.addContact(c);

        assertTrue(dao.getAllContacts().size() > 0);
    }
} contactDAOtest {
    
}
