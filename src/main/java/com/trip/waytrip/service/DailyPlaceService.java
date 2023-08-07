package com.trip.waytrip.service;

import com.trip.waytrip.domain.DailyPlace;
import com.trip.waytrip.domain.DailySchedule;
import com.trip.waytrip.domain.Place;
import com.trip.waytrip.dto.DailyPlaceDto;
import com.trip.waytrip.dto.MemoDto;
import com.trip.waytrip.repository.DailyPlaceRepository;
import com.trip.waytrip.repository.DailyScheduleRepository;
import com.trip.waytrip.repository.PlaceRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;

@Service
@RequiredArgsConstructor
public class DailyPlaceService {
    private final DailyPlaceRepository dailyPlaceRepository;
    private final DailyScheduleRepository dailyScheduleRepository;
    private final PlaceRepository placeRepository;
    private final MemoService memoService;

    @Transactional
    public void createDailyPlace(DailyPlaceDto.BasicDailyPlaceDto dailyPlaceDto) {
        DailySchedule dailySchedule = dailyScheduleRepository.findById(dailyPlaceDto.getDailyScheduleId())
                .orElseThrow(() -> new RuntimeException("DailySchedule not found"));
        Place place = placeRepository.findById(dailyPlaceDto.getPlaceId())
                .orElseThrow(() -> new RuntimeException("Place not found"));

        DailyPlace dailyPlace = DailyPlace.builder()
                .dailySchedule(dailySchedule)
                .place(place)
                .build();

        dailyPlaceRepository.save(dailyPlace);
    }
    @PostMapping("/{dailyPlaceId}/memos")
    public ResponseEntity<HttpStatus> createMemo(@RequestBody MemoDto.BasicMemoDto memoDto) {
        memoService.createMemo(memoDto);
        return ResponseEntity.ok(HttpStatus.CREATED);
    }

}
