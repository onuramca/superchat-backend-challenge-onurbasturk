package de.superchat.superchatbackend.services;

import de.superchat.superchatbackend.dto.MessageDto;
import de.superchat.superchatbackend.model.Contact;
import de.superchat.superchatbackend.model.Conversation;
import de.superchat.superchatbackend.model.Message;
import de.superchat.superchatbackend.repository.MessageRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.sql.Timestamp;
import java.time.Instant;

import static de.superchat.superchatbackend.util.SuperchatUtils.replacePlaceHolders;

@Service
public class MessageService {

    @Autowired
    private MessageRepository messageRepository;

    @Autowired
    private MessageSenderService messageSenderService;

    @Autowired
    private ConversationService conversationService;

    @Autowired
    private ContactService contactService;

    @Transactional
    public void sendMessage(MessageDto messageDto) {
        Message message = messageDto.getMessage();
        message.setTimestamp(Timestamp.from(Instant.now()));
        message.setSender(messageSenderService.findByType(message.getSender().getType()));

        Contact contact = contactService.getContactById(messageDto.getContactId());
        message.setText(replacePlaceHolders(message.getText(), contact.getFirstName(), "1000 $"));
        messageRepository.save(message);

        Conversation conversation = conversationService.getConversationById(messageDto.getConversationId());
        if (conversation == null) {
            conversation = conversationService.createNewConversation(messageDto);
            conversationService.saveConversation(conversation);
        }
        message.setConversation(conversation);
    }


}
