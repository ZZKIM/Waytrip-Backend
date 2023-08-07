package com.trip.waytrip.dto;

import com.trip.waytrip.domain.Address;
import com.trip.waytrip.domain.Place;
import com.trip.waytrip.domain.enumCategory.DistrictEnum;
import com.trip.waytrip.domain.enumCategory.ThemeEnum;
import jakarta.persistence.Column;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import java.util.List;

public class PlaceDto {
    @Data
    @NoArgsConstructor
    @AllArgsConstructor
    public static class Request {
        private String name;
        private ThemeEnum theme;
        private DistrictEnum district;

        private String specificAddress;
        private Double latitude;
        private Double longitude;

        private String openTime;
        private String closeTime;
        private String detail;
        private String imageUrl;
        private List<String> keywords;

    }

    @Data
    @NoArgsConstructor
    @AllArgsConstructor
    public static class Response {
        private Long id;
        String name;
        ThemeEnum theme;
        DistrictEnum district;
        String specificAddress;
        Double latitude;
        Double longitude;
        String openTime;
        String closeTime;
        String detail;
        String imageUrl;
        List<String> keywords;
        public Response(Place place){
            this.id = place.getId();
            this.name = place.getName();
            this.specificAddress = place.getAddress().getSpecificAddress();
            this.latitude = place.getAddress().getLatitude();
            this.longitude = place.getAddress().getLongitude();
            this.openTime = place.getOpenTime();
            this.closeTime = place.getCloseTime();
            this.detail = place.getDetail();
            this.imageUrl = place.getImageUrl();
            this.keywords = place.getKeywords();
        }
    }
}
