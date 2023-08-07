package com.trip.waytrip.dto;

import com.trip.waytrip.domain.Memo;
import lombok.*;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class MemoDto {
    @Getter
    @Setter
    @Builder
    @NoArgsConstructor
    @AllArgsConstructor
    public static class CreateRequest {
        private Long dailyPlaceId;
        private String title;
        private String content;
    }

    @Getter
    @Setter
    @Builder
    @NoArgsConstructor
    @AllArgsConstructor
    public static class Response {
        private Long id;
        private String title;
        private String content;
    }
    @Getter
    @Setter
    @NoArgsConstructor
    @AllArgsConstructor
    @Builder
    public static class BasicMemoDto {
        private Long id;
        private String title;
        private String content;
        private Long userId;
        private Long dailyPlaceId;

        public BasicMemoDto(Memo memo) {
            this.id = memo.getId();
            this.title = memo.getTitle();
            this.content = memo.getContent();
            this.userId = memo.getUser().getId();
            this.dailyPlaceId = memo.getDailyPlace().getId();
        }
    }
}
