package com.trip.waytrip.controller;

import com.trip.waytrip.dto.DayScheduleDto;
import com.trip.waytrip.dto.ScheduleDto;
import com.trip.waytrip.dto.UserDto;
import com.trip.waytrip.service.DayPlaceService;
import com.trip.waytrip.service.DayScheduleService;
import com.trip.waytrip.service.ScheduleService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
//완료
@RestController
@RequiredArgsConstructor
@RequestMapping("/api/schedules")
public class ScheduleController {
    private final DayScheduleService dayScheduleService;//이게 그나마 나은 듯
    private final ScheduleService scheduleService;
    @PostMapping("/{userId}")
    public ResponseEntity<HttpStatus> createTeamAndFirstSchedule(@RequestBody ScheduleDto.FirstRequestDto requestDto,@PathVariable(name = "userId") Long userId) {
        dayScheduleService.createTeamAndFirstSchedule(requestDto, userId);
        return new ResponseEntity<>(HttpStatus.CREATED);
    }
    @PostMapping("/{scheduleId}")
    public ResponseEntity<HttpStatus> createSchedule(@PathVariable(name = "scheduleId") Long scheduleId, @RequestBody List<DayScheduleDto.Request> requestDtos) {
        dayScheduleService.createSchedule(scheduleId, requestDtos);
        return new ResponseEntity<>(HttpStatus.CREATED);
    }
    @GetMapping("/{scheduleId}/album")
    public ResponseEntity<?> getAllImagesInAlbum(@PathVariable(name = "scheduleId")Long scheduleId){
        return new ResponseEntity<>(
                scheduleService.getAllImagesInAlbum(scheduleId),
                HttpStatus.OK
        );
    }
    @GetMapping("/{scheduleId}")
    public ResponseEntity<?> getSchedule(@PathVariable(name = "scheduleId")Long scheduleId){
        return new ResponseEntity<>(
                dayScheduleService.getAllDaySchedule(scheduleId),
                HttpStatus.OK
        );
    }
}
