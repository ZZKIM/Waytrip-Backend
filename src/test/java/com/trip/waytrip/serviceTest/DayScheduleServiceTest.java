package com.trip.waytrip.serviceTest;
import com.trip.waytrip.domain.*;
import com.trip.waytrip.dto.DayPlaceDto;
import com.trip.waytrip.dto.DayScheduleDto;
import com.trip.waytrip.dto.PlaceDto;
import com.trip.waytrip.dto.ScheduleDto;
import com.trip.waytrip.repository.*;
import com.trip.waytrip.service.DayScheduleService;
import com.trip.waytrip.service.UserService;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.springframework.boot.test.context.SpringBootTest;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

import static org.mockito.Mockito.*;
@SpringBootTest
public class DayScheduleServiceTest {

    @InjectMocks
    private DayScheduleService dayScheduleService;

    @Mock
    private TeamRepository teamRepository;

    @Mock
    private UserRepository userRepository;

    @Mock
    private DayScheduleRepository dayScheduleRepository;

    @Mock
    private ScheduleRepository scheduleRepository;

    @Mock
    private PlaceRepository placeRepository;

    @Mock
    private DayPlaceRepository dayPlaceRepository;

    @Mock
    private UserService userService;

    @BeforeEach
    public void setUp() {
        MockitoAnnotations.initMocks(this);
    }

    @Test
    public void testCreateSchedule() {
        Long scheduleId = 1L;

        // Mocking data
        DayScheduleDto.Request dayScheduleRequest = new DayScheduleDto.Request();
        List<PlaceDto.Request> placeRequestList = new ArrayList<>();
        PlaceDto.Request placeRequest = new PlaceDto.Request();
        placeRequestList.add(placeRequest);
        dayScheduleRequest.setRequestDtoList(placeRequestList);

        Schedule schedule = new Schedule();
        when(scheduleRepository.findById(scheduleId)).thenReturn(java.util.Optional.of(schedule));

        DayPlace dayPlace = new DayPlace();
        when(dayPlaceRepository.save(any())).thenReturn(dayPlace);

        // Call the method
        dayScheduleService.createSchedule(scheduleId, List.of(dayScheduleRequest));

        // Verify the interactions
        verify(scheduleRepository, times(1)).findById(scheduleId);
        verify(placeRepository, times(1)).save(any());
        verify(dayPlaceRepository, times(1)).save(any());
        verify(dayScheduleRepository, times(1)).save(any());
    }

    // You can write similar test cases for other methods as well
}
