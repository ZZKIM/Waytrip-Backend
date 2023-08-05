package com.trip.waytrip.repository;


import com.trip.waytrip.domain.DailyPlace;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface DailyPlaceRepository extends JpaRepository<DailyPlace, Long> {
}
