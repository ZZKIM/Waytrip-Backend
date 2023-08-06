package com.trip.waytrip.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.List;
import java.util.Map;

@Getter
@Setter
public class ChatGPTDto {
    @NoArgsConstructor
    @Getter
    @Setter
    public static class Message{
        private String message;

        public Message(String message) {
            this.message = message;
        }
    }
    // ChatGPT API Response 객체 매핑용 클래스
    @Getter
    @Setter
    public static class TextResponse {
        private static List<Text> texts;

        public static List<Text> getTexts() {
            return texts;
        }

        @Getter
        @Setter
        public static class Text {
            private String text;

            public String getText() {
                return text;
            }
        }
    }
}
