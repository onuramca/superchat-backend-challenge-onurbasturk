package de.superchat.superchatbackend.services;

import de.superchat.superchatbackend.dto.MessageDto;
import de.superchat.superchatbackend.model.Contact;
import de.superchat.superchatbackend.model.Conversation;
import de.superchat.superchatbackend.model.User;
import de.superchat.superchatbackend.repository.ConversationRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.sql.Timestamp;
import java.time.Instant;
import java.util.List;
import java.util.Optional;

@Service
public class ConversationService {

    @Autowired
    private ConversationRepository conversationRepository;

    @Autowired
    private ContactService contactService;

    @Autowired
    private UserService userService;

    public List<Conversation> getAllConversations() {
        return conversationRepository.findAll();
    }

    public Conversation createNewConversation(MessageDto messageDto) {
        Conversation conversation = new Conversation();
        Contact contact = contactService.getContactById(messageDto.getContactId());
        conversation.setContact(contact);
        conversation.setStartDate(Timestamp.from(Instant.now()));
        User user = userService.findByUserId(messageDto.getUserId());
        conversation.setUser(user);
        return conversation;
    }

    public Conversation getConversationById(long id) {
        return conversationRepository.getById(id);
    }

    public void saveConversation(Conversation conversation) {
        conversationRepository.save(conversation);
    }

    @Transactional
    public void endConversation(Long conversationId) {
        Optional<Conversation> conversation = conversationRepository.findById(conversationId);
        conversation.ifPresent(value -> value.setEndDate(Timestamp.from(Instant.now())));
    }
}
