package com.trip.waytrip.dto.response.post;

import com.trip.waytrip.domain.Post;

public record PostCreateResponse(
        Long id
) {
    public static PostCreateResponse from(final Post post) {
        return new PostCreateResponse(post.getId());
    }
}
