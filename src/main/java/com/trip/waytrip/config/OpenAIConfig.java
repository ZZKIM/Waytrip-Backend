package com.trip.waytrip.config;

import com.google.gson.Gson;
import com.trip.waytrip.dto.ChatGPTDto;
import org.apache.http.HttpEntity;
import org.apache.http.HttpResponse;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.entity.StringEntity;
import org.apache.http.impl.client.CloseableHttpClient;
import org.apache.http.impl.client.HttpClients;
import org.apache.http.util.EntityUtils;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Configuration;
import org.springframework.stereotype.Component;

import java.io.IOException;
@Component
public class OpenAIConfig {
    @Value("${openai.api-key}")
    private String openaiApiKey;
    public String generateChatResponse(String userInput) {
        String apiUrl = "https://api.openai.com/v1/engines/text-davinci-002/completions";
        String requestData = "{\"prompt\": \"" +"너는 여행계획가야 다음의 json 소스를 사용해서 여행 계획을 json 형식으로 짜줄래?" +  userInput + "\", \"max_tokens\": 150, \"stop\": [\"\\n\"]}";

        CloseableHttpClient httpClient = HttpClients.createDefault();
        HttpPost httpPost = new HttpPost(apiUrl);
        httpPost.setHeader("Content-Type", "application/json");
        httpPost.setHeader("Authorization", "Bearer " + openaiApiKey);
        httpPost.setEntity(new StringEntity(requestData, "UTF-8"));

        try {
            HttpResponse response = httpClient.execute(httpPost);
            HttpEntity entity = response.getEntity();
            String responseData = EntityUtils.toString(entity, "UTF-8");

            Gson gson = new Gson();
            ChatGPTDto.TextResponse chatGPTResponse = gson.fromJson(responseData, ChatGPTDto.TextResponse.class);
            return ChatGPTDto.TextResponse.getTexts().get(0).getText().trim();
        } catch (IOException e) {
            e.printStackTrace();
            return "Error: Unable to generate response";
        }
    }
}
