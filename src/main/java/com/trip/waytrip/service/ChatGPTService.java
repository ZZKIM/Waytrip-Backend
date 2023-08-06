package com.trip.waytrip.service;

import com.trip.waytrip.config.OpenAIConfig;
import com.trip.waytrip.dto.ChatGPTDto;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class ChatGPTService {
    private final OpenAIConfig openAIConfig;

    public ChatGPTDto.Message chatWithGPT(ChatGPTDto.Message messageRequest) {
        return new ChatGPTDto.Message(
                openAIConfig.generateChatResponse(
                        messageRequest.getMessage()
                )
        );
    }
}
