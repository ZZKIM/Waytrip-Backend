package com.trip.waytrip.controller;

import com.trip.waytrip.dto.ChatGPTDto;
import com.trip.waytrip.service.ChatGPTService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequiredArgsConstructor
@RequestMapping("/api/openai")
public class ChatGPTController {
    private final ChatGPTService chatGPTService;
    @PostMapping("/chat")
    public ResponseEntity<ChatGPTDto.Message> chatWithGPT(@RequestBody ChatGPTDto.Message messageRequest) {
        return ResponseEntity.ok(
                chatGPTService.chatWithGPT(messageRequest)
        );
    }
}
