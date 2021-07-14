package de.superchat.superchatbackend.controller;

import com.google.i18n.phonenumbers.NumberParseException;
import de.superchat.superchatbackend.model.Contact;
import de.superchat.superchatbackend.services.ContactService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.server.ResponseStatusException;

import java.util.List;

@RestController
@RequestMapping("/v1/contacts")
@Api(tags = "Contacts API")
public class ContactController {

    @Autowired
    private ContactService contactService;

    @GetMapping
    @ApiOperation(value = "List all contacts")
    public ResponseEntity<List<Contact>> getAllContacts() {
        List<Contact> contacts = contactService.getAllContacts();
        return ResponseEntity.ok(contacts);
    }

    @PostMapping
    @ApiOperation(value = "Create a new contact")
    public ResponseEntity<Contact> createContact(@RequestBody Contact contact) {
        Contact newContact = null;
        try {
            newContact = contactService.createContact(contact);
        } catch (IllegalArgumentException | NumberParseException ex) {
            throw new ResponseStatusException(HttpStatus.BAD_REQUEST, ex.getMessage());
        }
        return ResponseEntity.ok(newContact);
    }

    @GetMapping("/{id}")
    @ApiOperation(value = "Get contact by id")
    public ResponseEntity<Contact> getContactById(@PathVariable Long id) {
        Contact contact = contactService.getContactById(id);
        if (contact != null) {
            return ResponseEntity.ok(contact);
        } else {
            return ResponseEntity.notFound().build();
        }
    }

}
