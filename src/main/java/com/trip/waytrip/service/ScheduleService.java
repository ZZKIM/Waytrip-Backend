package com.trip.waytrip.service;

import com.trip.waytrip.api.dto.CategoryDTO;
import com.trip.waytrip.domain.Schedule;
import com.trip.waytrip.domain.User;
import com.trip.waytrip.repository.ScheduleRepository;
import com.trip.waytrip.repository.UserRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.Optional;

@Service
@Transactional(readOnly = true)
@RequiredArgsConstructor
public class ScheduleService {
    private final UserRepository userRepository;
    private final ScheduleRepository scheduleRepository;

    @Transactional
    public void saveSchedule(CategoryDTO.UserDayRequestDTO dayDTO, Long userId){
        Optional<User> optionalUser = userRepository.findById(userId);
        if(optionalUser.isPresent()) {
            User user = optionalUser.get();
            Schedule schedule = new Schedule(user, dayDTO);
            scheduleRepository.save(schedule);

        }
        else
            System.out.println("No User");
    }

    public Schedule findByUserId(Long id){
        Optional<User> optionalUser = userRepository.findById(id);
        User user = optionalUser.get();

        Schedule schedule = scheduleRepository.findByUserId(user.getId());
        return schedule;
    }
}
