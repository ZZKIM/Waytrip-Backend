package com.trip.waytrip.dto;

import com.trip.waytrip.domain.Comment;
import com.trip.waytrip.domain.DayPlace;
import com.trip.waytrip.domain.Place;
import com.trip.waytrip.domain.enumCategory.DistrictEnum;
import com.trip.waytrip.domain.enumCategory.ThemeEnum;
import lombok.*;

import java.util.List;
import java.util.stream.Collectors;

public class DayPlaceDto {
    public static class RequestDto{
        Long id;
    }
    public static class Response{
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
        List<CommentResponseDto> commentResponseDtos;
        public Response(DayPlace dayPlace, List<CommentResponseDto> commentResponseDtos){
            this.id = dayPlace.getId();
            this.name = dayPlace.getPlace().getName();
            this.specificAddress = dayPlace.getPlace().getAddress().getSpecificAddress();
            this.latitude = dayPlace.getPlace().getAddress().getLatitude();
            this.longitude = dayPlace.getPlace().getAddress().getLongitude();
            this.openTime = dayPlace.getPlace().getOpenTime();
            this.closeTime = dayPlace.getPlace().getCloseTime();
            this.detail = dayPlace.getPlace().getDetail();
            this.imageUrl = dayPlace.getPlace().getImageUrl();
            this.keywords = dayPlace.getPlace().getKeywords();
            this.commentResponseDtos = commentResponseDtos;
        }
    }
    @Getter
    @Setter
    @Builder
    @NoArgsConstructor
    @AllArgsConstructor
    public static class CommentRequestDto{
        Long userId;
        String content;
    }
    @Getter
    @Setter
    @Builder
    @NoArgsConstructor
    @AllArgsConstructor
    public static class CommentResponseDto{
        Long id;
        String userName;
        String content;
        public void CommentResponseDto(Comment comment){
            this.id = comment.getId();
            this.userName = comment.getUser().getNickname();
            this.content = comment.getContent();
        }
    }
}
