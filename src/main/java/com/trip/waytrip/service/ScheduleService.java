package com.trip.waytrip.service;

import com.trip.waytrip.domain.Schedule;
import com.trip.waytrip.domain.Team;
import com.trip.waytrip.domain.User;
import com.trip.waytrip.dto.ScheduleDto;
import com.trip.waytrip.repository.ScheduleRepository;
import com.trip.waytrip.repository.TeamRepository;
import com.trip.waytrip.repository.UserRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class ScheduleService {

    private final ScheduleRepository scheduleRepository;
    private final TeamRepository teamRepository;
    private final UserRepository userRepository;
    public void createTeamAndFirstSchedule(ScheduleDto.FirstRequestDto requestDto, Long userId){
        Team team = new Team();
        User user = userRepository.findById(userId).orElseThrow(() -> new IllegalArgumentException("User not found."));
        team.addUser(user);
        teamRepository.save(team);
        Schedule schedule = new Schedule(requestDto, team);
        scheduleRepository.save(schedule);

    }
    // Retrieve all schedules
    public List<ScheduleDto.Response> getAllSchedules() {
        return scheduleRepository.findAll().stream()
                .map(ScheduleDto.Response::new)
                .collect(Collectors.toList()
                );
    }

    // Retrieve a schedule by id
    public ScheduleDto.Response getScheduleById(Long id) {
        return scheduleRepository.findById(id)
                .map(ScheduleDto.Response::new)
                .orElseThrow(() ->
                        new IllegalArgumentException("Schedule not found.")
                );
    }

    // Update
    public void updateSchedule(Long id, ScheduleDto.RequestDto requestDto) {
        Schedule schedule = scheduleRepository.findById(id)
                .orElseThrow(() -> new IllegalArgumentException("Schedule not found."));

        schedule.update(requestDto);
        scheduleRepository.save(schedule);
    }

    // Delete
    @Transactional
    public void deleteSchedule(Long id) {
        scheduleRepository.deleteById(id);
    }
}
