package de.superchat.superchatbackend.repository;

import de.superchat.superchatbackend.model.User;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserRepository extends JpaRepository<User, Long> {
}
