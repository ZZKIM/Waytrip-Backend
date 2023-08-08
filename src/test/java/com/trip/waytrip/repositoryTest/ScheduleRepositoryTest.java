package com.trip.waytrip.repositoryTest;

import com.trip.waytrip.domain.*;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.time.LocalDate;

import static org.assertj.core.api.Assertions.assertThat;

public class ScheduleRepositoryTest extends RepositoryTest{
    private User user;

    @BeforeEach
    void init(){
        user = User.builder()
                .email("email")
                .nickname("가희")
                .profileUrl("이미지")
                .build();
    }
    @Test
    @DisplayName("팀을 만들고 초기 스케쥴을 저장한다.")
    void save() {
        //given
        userRepository.save(user);

        //when
        Team team = new Team();
        Team team1 = teamRepository.save(team);
        Schedule schedule = Schedule.builder()
                .name("제주도")
                .imageUrl("image")
                .startDate(LocalDate.of(2023,01,01))
                .endDate(LocalDate.of(2023,01,02))
                .team(team)
                .build();
        Schedule schedule1 = scheduleRepository.save(schedule);
        UserTeam userTeam = UserTeam.builder()
                .user(user)
                .team(team)
                .build();

        UserTeam userTeam1 = userTeamRepository.save(userTeam);

        //then
        assertThat(team).isEqualTo(team1);
        assertThat(schedule).isEqualTo(schedule1);
        assertThat(userTeam).isEqualTo(userTeam1);
    }
}
