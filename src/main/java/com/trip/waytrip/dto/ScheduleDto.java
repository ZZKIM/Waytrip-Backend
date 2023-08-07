package com.trip.waytrip.dto;

import com.trip.waytrip.domain.DailySchedule;
import com.trip.waytrip.domain.Schedule;
import com.trip.waytrip.domain.category.District;
import com.trip.waytrip.domain.category.Theme;
import lombok.*;

import java.time.LocalDate;
import java.util.List;

@Getter
public class ScheduleDto {

    @Data
    @NoArgsConstructor
    @AllArgsConstructor
    public static class FirstRequestDto {
        private String name;
        private LocalDate startDate;
        private LocalDate endDate;
    }

    @Data
    @NoArgsConstructor
    @AllArgsConstructor
    public static class RequestDto extends FirstRequestDto{
        List<DailySchedule> dailySchedules;
        List<Theme> theme;
        List<District> district;
        String imageUrl;
    }

    @Data
    @NoArgsConstructor
    @AllArgsConstructor
    public static class Response {
        private Long id;
        private String name;
        private LocalDate startDate;
        private LocalDate endDate;
        private Long teamId;
        private String imageUrl;
        public Response(Schedule schedule){
            this.id = schedule.getId();
            this.name = schedule.getName();
            this.startDate = schedule.getStartDate();
            this.endDate = schedule.getEndDate();
            this.teamId = schedule.getTeam().getId();
            this.imageUrl = schedule.getImageUrl();
        }
    }

}
