package com.example.kidzy.controller;

import com.example.kidzy.entity.Contact;
import com.example.kidzy.service.ContactService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api/contacts")
@CrossOrigin(origins = "*")
public class ContactController {

    @Autowired
    private ContactService contactService;

    @GetMapping
    public List<Contact> getAllContacts() {
        return contactService.getAllContacts();
    }

    @GetMapping("/{id}")
    public Optional<Contact> getContactById(@PathVariable Integer id) {
        return contactService.getContactById(id);
    }

    @PostMapping
    public Contact createContact(@RequestBody Contact contact) {
        return contactService.saveContact(contact);
    }

    @PutMapping("/{id}")
    public Contact updateContact(@PathVariable Integer id, @RequestBody Contact contactDetails) {
        return contactService.getContactById(id)
                .map(contact -> {
                    contact.setNom(contactDetails.getNom());
                    contact.setEmail(contactDetails.getEmail());
                    contact.setMessage(contactDetails.getMessage());
                    contact.setDateContact(contactDetails.getDateContact());
                    return contactService.saveContact(contact);
                })
                .orElseThrow(() -> new RuntimeException("Contact non trouvé avec id " + id));
    }

    @DeleteMapping("/{id}")
    public void deleteContact(@PathVariable Integer id) {
        contactService.deleteContact(id);
    }
}
