package com.trip.waytrip.controller;

import com.trip.waytrip.dto.ScheduleDto;
import com.trip.waytrip.dto.UserDto;
import com.trip.waytrip.service.ScheduleService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequiredArgsConstructor
@RequestMapping("/schedules")
public class ScheduleController {
    private final ScheduleService scheduleService;
    @PostMapping
    public ResponseEntity<HttpStatus> createTeamAndFirstSchedule(@RequestBody ScheduleDto.FirstRequestDto requestDto, Long userId) {
        scheduleService.createTeamAndFirstSchedule(requestDto, userId);
        return new ResponseEntity<>(HttpStatus.CREATED);
    }
}
