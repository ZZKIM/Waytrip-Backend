package com.trip.waytrip.domain;

import com.trip.waytrip.global.BaseTimeEntity;
import jakarta.persistence.*;
import lombok.*;

import java.util.ArrayList;
import java.util.List;
@Getter
@Builder
@AllArgsConstructor
@NoArgsConstructor
@Entity
public class Team extends BaseTimeEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @Setter
    @OneToOne
    private Schedule schedule;

    @OneToOne
    private Album album;

    //@JoinColumn
//    @OneToMany(mappedBy = "team")
//    private List<User> users = new ArrayList<>();
    @OneToMany(mappedBy = "team", cascade = CascadeType.ALL)
    private List<UserTeam> userTeams = new ArrayList<>();

//    public void addUser(User user) {
//        users.add(user);
//        user.joinTeam(this);
//    }
}
