package com.trip.waytrip.dto.response;

import com.trip.waytrip.domain.User;

public record UserFindResponse(
        String nickname,
        String profileUrl
) {
    public static UserFindResponse of(final User user) {
        return new UserFindResponse(
            user.getNickname(),
            user.getProfileUrl()
        );
    }
}
