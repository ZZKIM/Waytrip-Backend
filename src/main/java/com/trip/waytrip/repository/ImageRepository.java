package com.trip.waytrip.repository;

import com.trip.waytrip.domain.Image;
import com.trip.waytrip.domain.Album;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ImageRepository extends JpaRepository<Image, Long> {
    List<Image> findAllByPost(final Album post);
}
