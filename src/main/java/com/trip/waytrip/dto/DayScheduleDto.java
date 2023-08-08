package com.trip.waytrip.dto;

import com.trip.waytrip.domain.DaySchedule;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDate;
import java.util.List;

public class DayScheduleDto {
    @Data
    @AllArgsConstructor
    @NoArgsConstructor
    public static class Request{
        private LocalDate date;
        private List<PlaceDto.Request> requestDtoList;
    }
    @Data
    @AllArgsConstructor
    @NoArgsConstructor
    public static class Response{
        private Long id;
        private LocalDate date;
        private List<PlaceDto.Response> placeDtoList;
        public Response(DaySchedule daySchedule, List<PlaceDto.Response> placeDtoList){
            this.id = daySchedule.getId();
            this.date = daySchedule.getDate();
            this.placeDtoList = placeDtoList;
        }
    }
}
