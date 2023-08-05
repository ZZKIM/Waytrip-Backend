package com.trip.waytrip.dto.response.post;

import java.util.List;

public record PostFindAllResponse(
        List<PostFindResponse> posts
) {
    public static PostFindAllResponse of(final List<PostFindResponse> postFindResponses) {
        return new PostFindAllResponse(postFindResponses);
    }
}
