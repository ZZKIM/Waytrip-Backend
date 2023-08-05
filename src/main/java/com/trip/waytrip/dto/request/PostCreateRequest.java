package com.trip.waytrip.dto.request;

public record PostCreateRequest(
        Long scheduleId,
        String title,
        String content
) {
}
