package com.trip.waytrip.service;

import com.trip.waytrip.domain.DailySchedule;
import com.trip.waytrip.domain.Schedule;
import com.trip.waytrip.dto.DailyScheduleDto;
import com.trip.waytrip.repository.DailyScheduleRepository;
import com.trip.waytrip.repository.ScheduleRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@RequiredArgsConstructor
@Service
public class DailyScheduleService {
    private final DailyScheduleRepository dailyScheduleRepository;
    private final ScheduleRepository scheduleRepository;

    public void create(DailyScheduleDto.CreateRequest request) {
        Schedule schedule = scheduleRepository.findById(request.getScheduleId())
                .orElseThrow(() -> new IllegalArgumentException("Schedule not found"));

        DailySchedule dailySchedule = DailySchedule.builder()
                .date(request.getDate())
                .schedule(schedule)
                .build();

        dailyScheduleRepository.save(dailySchedule);
    }

    public List<DailyScheduleDto.DailyScheduleResponse> getAll() {
        List<DailySchedule> dailySchedules = dailyScheduleRepository.findAll();
        return dailySchedules.stream()
                .map(DailyScheduleDto.DailyScheduleResponse::new)
                .collect(Collectors.toList());
    }

    public DailyScheduleDto.DailyScheduleResponse getById(Long id) {
        DailySchedule dailySchedule = dailyScheduleRepository.findById(id)
                .orElseThrow(() -> new IllegalArgumentException("DailySchedule not found"));
        return DailyScheduleMapper.INSTANCE.dailyScheduleToResponse(dailySchedule);
    }

    public DailyScheduleDto.DailyScheduleResponse update(DailyScheduleDto.UpdateRequest request) {
        DailySchedule dailySchedule = dailyScheduleRepository.findById(request.getId())
                .orElseThrow(() -> new IllegalArgumentException("DailySchedule not found"));

        dailySchedule.setDate(request.getDate());
        DailySchedule updatedDailySchedule = dailyScheduleRepository.save(dailySchedule);

        return DailyScheduleMapper.INSTANCE.dailyScheduleToResponse(updatedDailySchedule);
    }

    public void delete(Long id) {
        dailyScheduleRepository.deleteById(id);
    }
}
