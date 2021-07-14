package de.superchat.superchatbackend.repository;

import de.superchat.superchatbackend.model.MessageSender;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface MessageSenderRepository extends JpaRepository<MessageSender, Long> {

    MessageSender findByType(String type);

}
