package com.trip.waytrip.dto.response;

import com.trip.waytrip.domain.Schedule;
import com.trip.waytrip.domain.User;
import lombok.Getter;
import lombok.Setter;

import java.util.List;

@Getter @Setter
public class UserDto {
    Long id;
    String nickname;
    String email;
    String profileUrl;
    List<Schedule> schedules;

    public UserDto(User user) {
        this.id = user.getId();
        this.nickname = user.getNickname();
        this.email = user.getEmail();
        this.profileUrl = user.getProfileUrl();
        this.schedules = user.getSchedules();
    }
}
