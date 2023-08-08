package com.trip.waytrip.controller;

import com.trip.waytrip.dto.DailyScheduleDto;
import com.trip.waytrip.service.DailyScheduleService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RequiredArgsConstructor
@RestController
@RequestMapping("/api/daily-schedules")
public class DailyScheduleController {
    private final DailyScheduleService dailyScheduleService;

    @PostMapping
    public ResponseEntity<HttpStatus> create(@RequestBody DailyScheduleDto.CreateRequest request) {
        dailyScheduleService.create(request);
        return new ResponseEntity(HttpStatus.CREATED);
    }


    @GetMapping
    public List<DailyScheduleDto.DailyScheduleResponse> getAll() {
        return dailyScheduleService.getAll();
    }

    @GetMapping("/{id}")
    public DailyScheduleDto.DailyScheduleResponse getById(@PathVariable Long id) {
        return dailyScheduleService.getById(id);
    }

    @PutMapping
    public ResponseEntity<HttpStatus> update(@RequestBody DailyScheduleDto.UpdateRequest request) {
        return new ResponseEntity(HttpStatus.OK);
    }

    @DeleteMapping("/{id}")
    public void delete(@PathVariable Long id) {
        dailyScheduleService.delete(id);
    }
}
