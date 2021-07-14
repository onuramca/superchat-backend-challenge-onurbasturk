package de.superchat.superchatbackend.controller;

import io.swagger.annotations.Api;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/v1/webhook")
@Api(tags = "Webhook API")
public class WebhookController {

    @GetMapping
    public ResponseEntity<String> respondToWebhook() {
        System.out.println("This is so cool");
        return ResponseEntity.ok("Hello from Twilio!");
    }


}
