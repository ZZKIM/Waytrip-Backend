package com.trip.waytrip.dto;

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
}
