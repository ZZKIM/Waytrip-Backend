package com.trip.waytrip.controller;

import com.trip.waytrip.domain.DailyPlace;
import com.trip.waytrip.dto.DailyPlaceDto;
import com.trip.waytrip.service.DailyPlaceService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/dailyPlaces")
@RequiredArgsConstructor
public class DailyPlaceController {
    private final DailyPlaceService dailyPlaceService;

    @PostMapping
    public ResponseEntity<HttpStatus> createDailyPlace(@RequestBody DailyPlaceDto.BasicDailyPlaceDto dailyPlaceDto) {
        dailyPlaceService.createDailyPlace(dailyPlaceDto);
        return ResponseEntity.ok(HttpStatus.CREATED);
    }

}
