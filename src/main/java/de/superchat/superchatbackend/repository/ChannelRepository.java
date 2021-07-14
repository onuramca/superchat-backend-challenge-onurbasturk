package de.superchat.superchatbackend.repository;

import de.superchat.superchatbackend.model.Channel;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ChannelRepository extends JpaRepository<Channel, Long> {

    Channel findByName(String name);

}
