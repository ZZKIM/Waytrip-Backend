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
public class DaySchedule {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false)
    private LocalDate date;

    @ManyToOne(optional = false, cascade = CascadeType.ALL)
    private Schedule schedule;

    @OneToMany(cascade = CascadeType.ALL, fetch = FetchType.LAZY)
    private List<DayPlace> dayPlaces = new ArrayList<>();
    public DaySchedule(Schedule schedule, ScheduleDto.DailyScheduleRequestDto requestDto){
        this.schedule = schedule;
        this.date = requestDto.getDate();
    }
    public void addDayPlace(DayPlace dayPlace){
        dayPlaces.add(dayPlace);
    }
}
