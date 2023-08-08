package com.trip.waytrip.repository;

import com.trip.waytrip.domain.DaySchedule;
import com.trip.waytrip.domain.Schedule;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface DayScheduleRepository extends JpaRepository<DaySchedule, Long> {
    DaySchedule findBySchedule(Schedule schedule);
}
