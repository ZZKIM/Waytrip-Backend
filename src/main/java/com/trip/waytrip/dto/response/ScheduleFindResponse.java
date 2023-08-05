package com.trip.waytrip.dto.response;

import com.trip.waytrip.domain.Schedule;

public record ScheduleFindResponse(
        String scheduleName,
        String startDate,
        String endDate,
        String district,
        String theme,
        boolean isDone
) {
    public static ScheduleFindResponse of(final Schedule schedule) {
        return new ScheduleFindResponse(
                schedule.getName(),
                schedule.getStartDate().toString(),
                schedule.getEndDate().toString(),
                schedule.getDistrict().toString(),
                schedule.getTheme().toString(),
                schedule.isDone()
        );
    }
}
