package de.superchat.superchatbackend.services;

import com.google.i18n.phonenumbers.NumberParseException;
import de.superchat.superchatbackend.model.Channel;
import de.superchat.superchatbackend.model.Contact;
import de.superchat.superchatbackend.repository.ChannelRepository;
import de.superchat.superchatbackend.repository.ContactRepository;
import de.superchat.superchatbackend.util.SuperchatUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.List;
import java.util.Optional;

@Service
public class ContactService {

    @Autowired
    private ContactRepository contactRepository;

    @Autowired
    private ChannelRepository channelRepository;

    public List<Contact> getAllContacts() {
        return contactRepository.findAll();
    }

    @Transactional
    public Contact createContact(Contact contact) throws NumberParseException, IllegalArgumentException {

        SuperchatUtils.validateEmail(contact.getEmail());
        SuperchatUtils.validatePhoneNumber(contact.getPhoneNumber());

        Channel channel = channelRepository.findByName(contact.getChannel().getName());
        contact.setChannel(channel);
        return contactRepository.save(contact);
    }

    public Contact getContactById(Long id) {
        Optional<Contact> contact = contactRepository.findById(id);
        return contact.orElse(null);
    }
}

