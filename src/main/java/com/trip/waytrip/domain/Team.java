package com.trip.waytrip.domain;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

import java.util.ArrayList;
import java.util.List;
@Getter
@Builder
@AllArgsConstructor
@NoArgsConstructor
@Entity
public class Team {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false, length = 20)
    private String name;

    @OneToOne
    private Schedule schedule;

    @OneToOne
    private Album album;

    //@JoinColumn
    @OneToMany(mappedBy = "team")
    private List<User> users = new ArrayList<>();
}
