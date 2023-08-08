package com.trip.waytrip.domain;

import com.trip.waytrip.dto.ScheduleDto;
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

    @ManyToOne(optional = false, cascade = CascadeType.ALL)
    private Schedule schedule;

    @OneToMany(mappedBy = "dailySchedule", cascade = CascadeType.ALL, fetch = FetchType.LAZY)
    private List<DailyPlace> dailyPlaces = new ArrayList<>();
    public DailySchedule(Schedule schedule, ScheduleDto.DailyScheduleRequestDto requestDto){
        this.schedule = schedule;
        this.date = requestDto.getDate();
    }
    public void addDailyPlace(DailyPlace dailyPlace){

        dailyPlaces.add(dailyPlace);
        dailyPlace.setDailySchedule(this);
    }
}
