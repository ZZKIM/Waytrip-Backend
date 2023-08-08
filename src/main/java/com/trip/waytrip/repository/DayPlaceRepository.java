package com.trip.waytrip.repository;

import com.trip.waytrip.domain.DayPlace;
import com.trip.waytrip.service.DayPlaceService;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface DayPlaceRepository extends JpaRepository<DayPlace, Long> {
}
