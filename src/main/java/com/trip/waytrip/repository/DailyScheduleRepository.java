package com.trip.waytrip.repository;

import com.trip.waytrip.domain.DailySchedule;
import com.trip.waytrip.domain.Schedule;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface DailyScheduleRepository extends JpaRepository<DailySchedule, Long> {
    List<DailySchedule> findAllBySchedule(final Schedule schedule);
}
