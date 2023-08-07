package com.trip.waytrip.controller;

import com.trip.waytrip.dto.MemoDto;
import com.trip.waytrip.service.MemoService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/memos")
@RequiredArgsConstructor
public class MemoController {
    private final MemoService memoService;

    @PostMapping
    public ResponseEntity<HttpStatus> createMemo(@RequestBody MemoDto.BasicMemoDto memoDto) {
        memoService.createMemo(memoDto);
        return ResponseEntity.ok(HttpStatus.CREATED);
    }

}
