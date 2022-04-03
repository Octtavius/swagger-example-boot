package com.tut.rest;

import com.tut.beans.Contact;
import com.tut.repositories.ContactRepository;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiParam;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.Collection;
import java.util.Collections;
import java.util.List;
import java.util.concurrent.ConcurrentHashMap;

@RestController
@RequestMapping("/api")
public class AddressBookResource {

    @Autowired
    private ContactRepository contactRepository;



    @GetMapping("/{id}")
    @ApiOperation(
            value = "Find specific contact by id",
            notes = "Provide an id of a person to look up specific contact from the address book",
            response = Contact.class)
    public Contact getContact(@ApiParam(value = "ID value for the contact you need to retrieve", required = true)
    @PathVariable String id) {

        return contactRepository.getContactById(id);
    }

    @GetMapping("/")
    public Collection<Contact> getAllContacts() {
        return contactRepository.getAllContacts();
    }

    @PostMapping("/")
    @ApiOperation(
            value = "Add a new Contact to contacts book",
            notes = "Provide first + last name for the name variable"
    )
    public Contact addContact(@RequestBody Contact contact) {
        return contactRepository.addNewContact(contact);
    }

}
