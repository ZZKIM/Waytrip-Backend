package com.trip.waytrip.domain;

import com.trip.waytrip.domain.category.Theme;
import com.trip.waytrip.domain.category.District;


import com.trip.waytrip.dto.ScheduleDto;
import com.trip.waytrip.global.BaseTimeEntity;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

@Getter
@Builder
@AllArgsConstructor
@NoArgsConstructor
@Entity
public class Schedule extends BaseTimeEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(length = 50)
    private String name;

    @Column(nullable = false)
    private LocalDate startDate;

    @Column(nullable = false)
    private LocalDate endDate;

    @Builder.Default
    private boolean isDone = false;

    @OneToOne
    @JoinColumn(nullable = false)
    private Team team;

    @OneToMany(mappedBy = "schedule", cascade = CascadeType.ALL, orphanRemoval = true, fetch = FetchType.EAGER)
    @Builder.Default
    private List<DailySchedule> dailySchedules = new ArrayList<>();

    @OneToMany(mappedBy = "schedule", cascade = CascadeType.ALL, orphanRemoval = true, fetch = FetchType.EAGER)
    private List<Theme> theme = new ArrayList<>();

    @OneToMany(mappedBy = "schedule", cascade = CascadeType.ALL, orphanRemoval = true, fetch = FetchType.EAGER)
    private List<District> district = new ArrayList<>();

    private String imageUrl;

    public Schedule(ScheduleDto.FirstRequestDto requestDto, Team team){
        this.name = requestDto.getName();
        this.startDate = requestDto.getStartDate();
        this.endDate = requestDto.getEndDate();
        this.team = team;
        team.setSchedule(this);
    }
    public void update(ScheduleDto.RequestDto requestDto){
        this.name = requestDto.getName();
        this.startDate = requestDto.getStartDate();
        this.endDate = requestDto.getEndDate();
        this.dailySchedules = requestDto.getDailySchedules();
        this.theme = requestDto.getTheme();
        this.district = requestDto.getDistrict();
        this.imageUrl = requestDto.getImageUrl();
    }
}
