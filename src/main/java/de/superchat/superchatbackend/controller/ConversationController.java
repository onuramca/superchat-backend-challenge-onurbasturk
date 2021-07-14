package de.superchat.superchatbackend.controller;

import de.superchat.superchatbackend.model.Conversation;
import de.superchat.superchatbackend.services.ConversationService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/v1/conversations")
@Api(tags = "Conversations API")
public class ConversationController {

    @Autowired
    private ConversationService conversationService;

    @GetMapping
    @ApiOperation(value = "List all conversations")
    public ResponseEntity<List<Conversation>> getAllConversations() {
        return ResponseEntity.ok(conversationService.getAllConversations());
    }

    @PostMapping
    @ApiOperation(value = "End conversation")
    public ResponseEntity<Void> endConversation(Long conversationId) {
        conversationService.endConversation(conversationId);
        return ResponseEntity.ok().build();
    }

}
