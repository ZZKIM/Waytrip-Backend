package com.trip.waytrip.service;

import com.trip.waytrip.domain.*;
import com.trip.waytrip.dto.DayPlaceDto;
import com.trip.waytrip.dto.DayScheduleDto;
import com.trip.waytrip.dto.PlaceDto;
import com.trip.waytrip.dto.ScheduleDto;
import com.trip.waytrip.repository.*;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
//확인 완료
@Service
@RequiredArgsConstructor
public class DayScheduleService {
    private final TeamRepository teamRepository;
    private final UserRepository userRepository;
    private final DayScheduleRepository dayScheduleRepository;
    private final ScheduleRepository scheduleRepository;
    private final PlaceRepository placeRepository;
    private final DayPlaceRepository dayPlaceRepository;

    private final UserService userService;
    public void createTeamAndFirstSchedule(ScheduleDto.FirstRequestDto requestDto, Long userId) {

        User user = userRepository.findById(userId).orElseThrow(() -> new RuntimeException("User not found"));

        Team team = new Team();
        teamRepository.save(team);

        Schedule schedule = new Schedule(requestDto, team);
        scheduleRepository.save(schedule);

        userService.joinTeam(user.getId(), team.getId());
    }
    public void createSchedule(Long scheduleId, List<DayScheduleDto.Request> requestList){
        for (DayScheduleDto.Request dayScheduleRequest : requestList) {
            makeDaySchedule(scheduleId, dayScheduleRequest);
        }
    }

    public void makeDaySchedule(Long scheduleId, DayScheduleDto.Request requestDto){
        Schedule schedule = scheduleRepository.findById(scheduleId).orElseThrow();
        List<DayPlace> dayPlaces = new ArrayList<>();

        for (PlaceDto.Request placeRequestDto : requestDto.getRequestDtoList()) {
            Address address = new Address(placeRequestDto);
            Place place = new Place(placeRequestDto, address);
            placeRepository.save(place);

            DayPlace dayPlace = DayPlace.builder()
                    .place(place)
                    .build();
            dayPlaces.add(dayPlaceRepository.save(dayPlace));
        }
        DaySchedule daySchedule = DaySchedule.builder()
                .date(requestDto.getDate())
                .dayPlaces(dayPlaces)
                .schedule(schedule)
                .build();
        dayScheduleRepository.save(daySchedule);
    }
}
