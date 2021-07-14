package de.superchat.superchatbackend.controller;

import de.superchat.superchatbackend.dto.MessageDto;
import de.superchat.superchatbackend.services.MessageService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/v1/messages")
@Api(tags = "Messages API")
public class MessageController {

    @Autowired
    private MessageService messageService;

    @PostMapping
    @ApiOperation(value = "Send message to a contact")
    public ResponseEntity<Void> sendMessage(@RequestBody MessageDto messageDto) {
        messageService.sendMessage(messageDto);
        return ResponseEntity.ok().build();
    }
}
