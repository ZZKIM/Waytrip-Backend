package com.trip.waytrip.repository;

import com.trip.waytrip.domain.Post;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface PostRepository extends JpaRepository<Post, Long> {
    List<Post> findAllByCreatedBy(final String userNickname);
}
