package com.trip.waytrip.controller;

import com.trip.waytrip.dto.ScheduleDto;
import com.trip.waytrip.dto.UserDto;
import com.trip.waytrip.service.ScheduleService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequiredArgsConstructor
@RequestMapping("/api/schedules")
public class ScheduleController {
    private final ScheduleService scheduleService;
    @PostMapping
    public ResponseEntity<HttpStatus> createTeamAndFirstSchedule(@RequestBody ScheduleDto.FirstRequestDto requestDto, Long userId) {
        scheduleService.createTeamAndFirstSchedule(requestDto, userId);
        return new ResponseEntity<>(HttpStatus.CREATED);
    }
    @GetMapping("/{scheduleId}/album")
    public ResponseEntity<?> getAllImagesInAlbum(@PathVariable(name = "scheduleId")Long scheduleId){
        return new ResponseEntity<>(
                scheduleService.getAllImagesInAlbum(scheduleId),
                HttpStatus.OK
        );
    }
}
