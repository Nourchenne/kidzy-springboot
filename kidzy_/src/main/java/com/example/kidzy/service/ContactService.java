package com.example.kidzy.service;

import com.example.kidzy.entity.Contact;
import com.example.kidzy.repository.ContactRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class ContactService {

    @Autowired
    private ContactRepository contactRepository;

    public List<Contact> getAllContacts() {
        return contactRepository.findAll();
    }

    public Optional<Contact> getContactById(Integer id) {
        return contactRepository.findById(id);
    }

    public Contact saveContact(Contact contact) {
        return contactRepository.save(contact);
    }

    public void deleteContact(Integer id) {
        contactRepository.deleteById(id);
    }
}
