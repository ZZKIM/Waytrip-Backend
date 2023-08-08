package com.trip.waytrip.service;

import com.trip.waytrip.domain.*;
import com.trip.waytrip.dto.PlaceDto;
import com.trip.waytrip.dto.ScheduleDto;
import com.trip.waytrip.repository.*;
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
    private final PlaceRepository placeRepository;
    private final DailyPlaceRepository dailyPlaceRepository;
    private final DailyScheduleRepository dailyScheduleRepository;

    private final UserService userService;
    //OK
    public void createTeamAndFirstSchedule(ScheduleDto.FirstRequestDto requestDto, Long userId){

        User user = userRepository.findById(userId).orElseThrow(() -> new RuntimeException("User not found"));

        Team team = new Team();
        teamRepository.save(team);

        Schedule schedule = new Schedule(requestDto, team);
        scheduleRepository.save(schedule);

        userService.joinTeam(user.getId(), team.getId());

    }
    public void createTotalSchedule(Long scheduleId, ScheduleDto.DailyScheduleRequestDto requestDto){
        createDailySchedule(scheduleId, requestDto);
    }
    public void createDailySchedule(Long scheduleId, ScheduleDto.DailyScheduleRequestDto requestDto){
        Schedule schedule = scheduleRepository.findById(scheduleId).orElseThrow();
        DailySchedule dailySchedule = new DailySchedule(schedule, requestDto);
        dailyScheduleRepository.save(dailySchedule);
    }
    public void addDailyPlaceToDailySchedule(DailySchedule dailySchedule, Long dailyPlaceId){
        DailyPlace dailyPlace = dailyPlaceRepository.findById(dailyPlaceId).orElseThrow();
        dailySchedule.addDailyPlace(dailyPlace);
        dailyScheduleRepository.save(dailySchedule);
    }
    public void createDailyPlace(Long placeId){
        Place place = placeRepository.findById(placeId).orElseThrow();
        DailyPlace dailyPlace = new DailyPlace();
        dailyPlace.setPlace(place);
        dailyPlaceRepository.save(dailyPlace);

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
