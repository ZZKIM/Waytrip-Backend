package com.trip.waytrip.repository;

import com.trip.waytrip.domain.Team;
import org.springframework.data.jpa.repository.JpaRepository;

public interface TeamRepository extends JpaRepository<Team, Long> {
}
