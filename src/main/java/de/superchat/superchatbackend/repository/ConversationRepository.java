package de.superchat.superchatbackend.repository;

import de.superchat.superchatbackend.model.Conversation;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ConversationRepository extends JpaRepository<Conversation, Long> {
}
