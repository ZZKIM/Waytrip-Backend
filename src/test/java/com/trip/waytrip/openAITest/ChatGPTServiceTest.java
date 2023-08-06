package com.trip.waytrip.openAITest;

import com.trip.waytrip.config.OpenAIConfig;
import com.trip.waytrip.dto.ChatGPTDto;
import com.trip.waytrip.service.ChatGPTService;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.transaction.annotation.Transactional;
@SpringBootTest
@Transactional
public class ChatGPTServiceTest {
    @Autowired
    private OpenAIConfig openAIConfig;
    public String fakeRequest;
    @BeforeEach
    void setUp() {
        fakeRequest =
                "{\n" +
                        "\t\"나\" : \"첫째날에는 바다를 가고 싶은데\",\n" +
                        "\t\"나\" : \"여기 어때\",\n" +
                        "\t\"친구\" : \"어디?\",\n" +
                        "\t\"나\" : { Tour api 로 받아온 객체 }\n" +
                        "\t\"친구\" : \"여기 괜찮네\",\n" +
                        "\t\"친구\" : \"여기로 가자\",\n" +
                        "\t\"나\" : \"그래\",\n" +
                        "}";
    }

    @Test
    void testChatWithGPT() {

        //given, when
        ChatGPTDto.Message messageRequest = new ChatGPTDto.Message(fakeRequest);

        //then
        String result = openAIConfig.generateChatResponse(
                messageRequest.getMessage());

        System.out.println(result);

    }
}
