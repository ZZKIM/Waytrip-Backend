package com.trip.waytrip.repository;

import com.trip.waytrip.domain.Album;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface PostRepository extends JpaRepository<Album, Long> {
    List<Album> findAllByCreatedBy(final String userNickname);
}
