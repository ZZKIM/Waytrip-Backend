package com.trip.waytrip.repositoryTest;

import com.trip.waytrip.domain.*;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.time.LocalDate;
import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

public class ScheduleRepositoryTest extends RepositoryTest{
    private User user;
    private Schedule schedule;
    private Schedule schedule1;

    @BeforeEach
    void init(){
        user = User.builder()
                .email("email")
                .nickname("가희")
                .profileUrl("이미지")
                .build();
        schedule = Schedule.builder()
                .name("제주도")
                .imageUrl("image")
                .startDate(LocalDate.of(2023,01,01))
                .endDate(LocalDate.of(2023,01,02))
                .team(
                        teamRepository.save(
                                new Team()
                        )
                )
                .build();

    }
    @Test
    @DisplayName("팀을 만들고 초기 스케쥴을 저장한다.")
    void saveTeamAndFirstSchedule() {
        //given
        userRepository.save(user);

        //when
        Team team = new Team();
        Team team1 = teamRepository.save(team);
        Schedule schedule0 = Schedule.builder()
                .name("제주도")
                .imageUrl("image")
                .startDate(LocalDate.of(2023,01,01))
                .endDate(LocalDate.of(2023,01,02))
                .team(team)
                .build();
        schedule1 = scheduleRepository.save(schedule0);
        UserTeam userTeam = UserTeam.builder()
                .user(user)
                .team(team)
                .build();

        UserTeam userTeam1 = userTeamRepository.save(userTeam);

        //then
        assertThat(team).isEqualTo(team1);
        assertThat(schedule0).isEqualTo(schedule1);
        assertThat(userTeam).isEqualTo(userTeam1);
    }
    @Test
    @DisplayName("일정의 하루일정 하나를 저장한다.")
    void saveDailySchedule(){
        //given
        scheduleRepository.save(schedule);
        DailySchedule dailySchedule = DailySchedule.builder()
                .date(LocalDate.of(2023,01,01))
                .schedule(schedule)
                .build();
        //when
        DailySchedule dailySchedule1 = dailyScheduleRepository.save(dailySchedule);
        //then
        assertThat(dailySchedule).isEqualTo(dailySchedule1);
    }
    //ok
    @Test
    @DisplayName("일정의 하루일정 여러개를 저장한다.")
    void saveDailySchedules(){
        //given
        scheduleRepository.save(schedule);

        DailySchedule dailySchedule = DailySchedule.builder()
                .date(LocalDate.of(2023,01,01))
                .schedule(schedule)
                .build();
        DailySchedule dailySchedule1 = DailySchedule.builder()
                .date(LocalDate.of(2023,01,02))
                .schedule(schedule)
                .build();
        DailySchedule dailySchedule2 = DailySchedule.builder()
                .date(LocalDate.of(2023,01,03))
                .schedule(schedule)
                .build();
        DailySchedule dailySchedule3 = DailySchedule.builder()
                .date(LocalDate.of(2023,01,04))
                .schedule(schedule)
                .build();
        DailySchedule dailySchedule4 = DailySchedule.builder()
                .date(LocalDate.of(2023,01,05))
                .schedule(schedule)
                .build();
        //when
        DailySchedule new_dailySchedule = dailyScheduleRepository.save(dailySchedule);
        DailySchedule new1_dailySchedule = dailyScheduleRepository.save(dailySchedule1);
        DailySchedule new2_dailySchedule = dailyScheduleRepository.save(dailySchedule2);
        DailySchedule new3_dailySchedule = dailyScheduleRepository.save(dailySchedule3);
        DailySchedule new4_dailySchedule = dailyScheduleRepository.save(dailySchedule4);

        List<DailySchedule> dailyScheduleList = dailyScheduleRepository.findAllBySchedule(schedule);
        //then
        assertThat(dailyScheduleList.size()).isEqualTo(5);
        assertThat(dailyScheduleList).contains(new_dailySchedule, new1_dailySchedule, new2_dailySchedule, new3_dailySchedule, new4_dailySchedule);
    }
}
