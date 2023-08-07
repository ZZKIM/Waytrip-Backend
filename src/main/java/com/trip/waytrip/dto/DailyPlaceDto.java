package com.trip.waytrip.dto;

import com.trip.waytrip.domain.DailyPlace;
import com.trip.waytrip.domain.Memo;
import lombok.*;

import java.util.List;
import java.util.stream.Collectors;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
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
        private List<MemoDto> memos;

        public BasicDailyPlaceDto(DailyPlace dailyPlace) {
            this.id = dailyPlace.getId();
            this.dailyScheduleId = dailyPlace.getDailySchedule().getId();
            this.placeId = dailyPlace.getPlace().getId();
            this.memos = dailyPlace.getMemos().stream()
                    .map(MemoDto::new)
                    .collect(Collectors.toList());
        }
    }
}
