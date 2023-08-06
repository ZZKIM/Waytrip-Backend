package com.trip.waytrip.domain;

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
public class DailySchedule {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false)
    private LocalDate date;

    @ManyToOne(optional = false)
    private Schedule schedule;

    @OneToMany(mappedBy = "dailySchedule", cascade = CascadeType.ALL, fetch = FetchType.LAZY)
    private List<DailyPlace> dailyPlaces = new ArrayList<>();
}
