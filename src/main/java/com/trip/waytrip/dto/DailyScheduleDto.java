package com.trip.waytrip.dto;

import com.trip.waytrip.domain.DailySchedule;
import lombok.*;

import java.time.LocalDate;
import java.util.List;
import java.util.stream.Collectors;

public class DailyScheduleDto {
    @Getter
    @Setter
    @Builder
    @NoArgsConstructor
    @AllArgsConstructor
    public static class CreateRequest {
        private LocalDate date;
        private Long scheduleId;
    }

    @Getter
    @Setter
    @Builder
    @NoArgsConstructor
    @AllArgsConstructor
    public static class DailyScheduleResponse {
        private Long id;
        private LocalDate date;
        private List<DailyPlaceDto.Response> dailyPlaces;

        public DailyScheduleResponse(DailySchedule dailySchedule) {
            this.id = dailySchedule.getId();
            this.date = dailySchedule.getDate();
            this.dailyPlaces = dailySchedule.getDailyPlaces().stream().map(DailyPlaceDto.Response::new).collect(Collectors.toList());
        }
    }

    @Getter
    @Setter
    @Builder
    @NoArgsConstructor
    @AllArgsConstructor
    public static class UpdateRequest {
        private Long id;
        private LocalDate date;
    }
}
