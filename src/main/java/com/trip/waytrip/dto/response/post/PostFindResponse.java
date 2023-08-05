package com.trip.waytrip.dto.response.post;


import com.trip.waytrip.domain.Post;
import com.trip.waytrip.dto.response.ScheduleFindResponse;
import com.trip.waytrip.dto.response.UserFindResponse;

public record PostFindResponse(
        ScheduleFindResponse schedule,
        boolean liked,
        int likes,
        String title,
        String content,
        String createdAt,
        UserFindResponse user
) {
    public static PostFindResponse of(final Post post, boolean liked) {
        return new PostFindResponse(
                ScheduleFindResponse.of(post.getSchedule()),
                liked,
                post.getLikes(),
                post.getTitle(),
                post.getContent(),
                post.getCreatedAt().toString(),
                UserFindResponse.of(post.getSchedule().getUser())
        );
    }
}
