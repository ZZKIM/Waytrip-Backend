package com.trip.waytrip.domain;


import com.trip.waytrip.dto.UserDto;
import jakarta.persistence.*;
import lombok.*;

import java.util.ArrayList;
import java.util.List;

@Getter
@Builder
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "user_account")
public class User {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false, length = 20)
    private String nickname;

    @Column(nullable = false, length = 128)
    private String email;

    @Builder.Default
    private String profileUrl = null;

//    @JoinColumn(name = "team_id")
//    @ManyToOne(optional = false)
//    private Team team;
    @OneToMany(mappedBy = "user", cascade = CascadeType.ALL)
    private List<UserTeam> userTeams = new ArrayList<>();

//    public void joinTeam(Team team) {
//        this.team = team;
//    }
    public void updateProfile(UserDto.Request userDto){
        this.nickname = userDto.getNickname();
        this.email = userDto.getEmail();
        this.profileUrl = userDto.getProfileUrl();
    }
}
