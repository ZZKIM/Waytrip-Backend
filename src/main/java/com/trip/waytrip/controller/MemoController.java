package com.trip.waytrip.controller;

import com.trip.waytrip.dto.MemoDto;
import com.trip.waytrip.service.MemoService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/memos")
@RequiredArgsConstructor
public class MemoController {
    private final MemoService memoService;

    @PostMapping
    public ResponseEntity<Long> createMemo(@RequestBody MemoDto memoDto) {
        Long id = memoService.createMemo(memoDto);
        return ResponseEntity.ok(id);
    }
    @PostMapping("/{dailyPlaceId}")
    public MemoDto.Response addMemo(@PathVariable Long dailyPlaceId, @RequestBody MemoDto.CreateRequest request) {
        return memoService.addMemo(dailyPlaceId, request);
    }
}
