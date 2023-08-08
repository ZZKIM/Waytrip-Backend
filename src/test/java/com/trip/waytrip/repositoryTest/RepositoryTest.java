package com.trip.waytrip.repositoryTest;

import com.trip.waytrip.repository.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.test.annotation.DirtiesContext;

@DataJpaTest
@DirtiesContext(classMode = DirtiesContext.ClassMode.BEFORE_EACH_TEST_METHOD)
class RepositoryTest {
    @Autowired protected UserRepository userRepository;
    @Autowired protected ScheduleRepository scheduleRepository;
    @Autowired protected DailyScheduleRepository dailyScheduleRepository;
    @Autowired protected DailyPlaceRepository dailyPlaceRepository;
    @Autowired protected PlaceRepository placeRepository;
    @Autowired protected AlbumRepository albumRepository;
    @Autowired protected MemoRepository memoRepository;
    @Autowired protected TeamRepository teamRepository;
    @Autowired protected UserTeamRepository userTeamRepository;
    @Autowired protected DayPlaceRepository dayPlaceRepository;
    @Autowired protected DayScheduleRepository dayScheduleRepository;
}
