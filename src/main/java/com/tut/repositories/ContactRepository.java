package com.tut.repositories;

import com.tut.beans.Contact;
import org.springframework.stereotype.Repository;

import java.util.Arrays;
import java.util.Collection;
import java.util.List;
import java.util.concurrent.ConcurrentHashMap;

@Repository
public class ContactRepository {

    private ConcurrentHashMap<String, Contact> contacts =
            new ConcurrentHashMap<>();

    public ContactRepository() {
        Contact c1 = new Contact("11", "Jack", "035486");
        Contact c2 = new Contact("12", "Chris", "035765");
        Contact c3 = new Contact("13", "Will", "035862");

        contacts.put(c1.getId(), c1);
        contacts.put(c2.getId(), c2);
        contacts.put(c3.getId(), c3);
    }

    public Collection<Contact> getAllContacts() {
        return contacts.values();
    }

    public Contact getContactById(String id) {
        return contacts.get(id);
    }

    public Contact addNewContact(Contact contact) {
        return contacts.put(contact.getId(), contact);
    }
}
