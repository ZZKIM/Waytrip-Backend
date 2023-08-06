package com.trip.waytrip.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.List;
@Getter
@Setter
public class ChatGPTDto {
    @NoArgsConstructor
    @AllArgsConstructor
    public static class messageRequest{
        private String message;
    }
    // ChatGPT API Response 객체 매핑용 클래스
    public static class TextResponse {
        private static List<Text> texts;

        public static List<Text> getTexts() {
            return texts;
        }
        public static class Text {
            private String text;

            public String getText() {
                return text;
            }
        }
    }
}
