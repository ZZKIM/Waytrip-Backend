package com.trip.waytrip.service;

import com.trip.waytrip.domain.DailyPlace;
import com.trip.waytrip.domain.Memo;
import com.trip.waytrip.domain.User;
import com.trip.waytrip.dto.MemoDto;
import com.trip.waytrip.repository.DailyPlaceRepository;
import com.trip.waytrip.repository.MemoRepository;
import com.trip.waytrip.repository.UserRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@RequiredArgsConstructor
public class MemoService {
    private final MemoRepository memoRepository;
    private final UserRepository userRepository;
    private final DailyPlaceRepository dailyPlaceRepository;
    public MemoDto.Response addMemo(Long dailyPlaceId, MemoDto.CreateRequest request) {
        DailyPlace dailyPlace = dailyPlaceRepository.findById(dailyPlaceId)
                .orElseThrow(() -> new IllegalArgumentException("DailyPlace not found"));

        Memo memo = Memo.builder()
                .title(request.getTitle())
                .content(request.getContent())
                .dailyPlace(dailyPlace)
                .build();

        Memo savedMemo = memoRepository.save(memo);

        return MemoDto.Response.builder()
                .id(savedMemo.getId())
                .title(savedMemo.getTitle())
                .content(savedMemo.getContent())
                .build();
    }
    @Transactional
    public Long createMemo(MemoDto.BasicMemoDto memoDto) {
        User user = userRepository.findById(memoDto.getUserId())
                .orElseThrow(() -> new RuntimeException("User not found"));
        DailyPlace dailyPlace = dailyPlaceRepository.findById(memoDto.getDailyPlaceId())
                .orElseThrow(() -> new RuntimeException("DailyPlace not found"));

        Memo memo = Memo.builder()
                .title(memoDto.getTitle())
                .content(memoDto.getContent())
                .user(user)
                .dailyPlace(dailyPlace)
                .build();

        memoRepository.save(memo);
        return memo.getId();
    }
}
