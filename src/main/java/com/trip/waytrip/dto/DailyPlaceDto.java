package com.trip.waytrip.dto;

import com.trip.waytrip.domain.DailyPlace;
import com.trip.waytrip.domain.Memo;
import lombok.*;

import java.util.List;
import java.util.stream.Collectors;


public class DailyPlaceDto {
    @Getter
    @Setter
    @Builder
    @NoArgsConstructor
    @AllArgsConstructor
    public static class CreateRequest {
        private Long dailyScheduleId;
        private Long placeId;
    }

    @Getter
    @Setter
    @Builder
    @NoArgsConstructor
    @AllArgsConstructor
    public static class Response {
        private Long id;
        private PlaceDto.Response place;

        public Response(DailyPlace dailyPlace) {
        }
    }
    @Getter
    @Setter
    @NoArgsConstructor
    @AllArgsConstructor
    @Builder
    public static class BasicDailyPlaceDto {
        private Long id;
        private Long dailyScheduleId;
        private Long placeId;
        private List<MemoDto.BasicMemoDto> memos;

        public BasicDailyPlaceDto(DailyPlace dailyPlace) {
            this.id = dailyPlace.getId();
            this.dailyScheduleId = dailyPlace.getDailySchedule().getId();
            this.placeId = dailyPlace.getPlace().getId();
            this.memos = dailyPlace.getMemos().stream()
                    .map(MemoDto.BasicMemoDto::new)
                    .collect(Collectors.toList());
        }
    }
}
