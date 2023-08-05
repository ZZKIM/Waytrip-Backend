package com.trip.waytrip.api.dto;

import lombok.*;

import java.util.List;

public class CategoryDTO {

    @Getter
    @Setter
    @Builder
    @NoArgsConstructor
    @AllArgsConstructor
    public static class UserDayRequestDTO{
        private String startDate;
        private String endDate;
    }

    @Getter
    @Setter
    @Builder
    @NoArgsConstructor
    @AllArgsConstructor
    public static class UserDistrictRequestDTO{
        private List<String> city;

        private Integer withPeople;

        private Integer budget;
    }

    @Getter
    @Setter
    @Builder
    @NoArgsConstructor
    @AllArgsConstructor
    public static class UserThemeRequestDTO {
        private List<String> Theme;
    }
}
