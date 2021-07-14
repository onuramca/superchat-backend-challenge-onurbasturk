package de.superchat.superchatbackend.services;

import de.superchat.superchatbackend.model.MessageSender;
import de.superchat.superchatbackend.repository.MessageSenderRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class MessageSenderService {

    @Autowired
    private MessageSenderRepository messageSenderRepository;

    public MessageSender findByType(String type) {
        return messageSenderRepository.findByType(type);
    }
}
