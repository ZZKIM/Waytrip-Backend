package com.trip.waytrip.dto;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

public class UserDto {

    @Data
    @AllArgsConstructor
    @NoArgsConstructor
    public static class Request {
        private String nickname;
        private String email;
        private String profileUrl;
        private Long teamId;
    }

    @Data
    @AllArgsConstructor
    @NoArgsConstructor
    public static class Response {
        private Long id;
        private String nickname;
        private String email;
        private String profileUrl;
        private Long teamId;
    }
}