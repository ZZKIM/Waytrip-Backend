package com.trip.waytrip.domain.category;

import com.trip.waytrip.domain.Schedule;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Getter
@Builder
@AllArgsConstructor
@NoArgsConstructor
@Entity
public class Theme {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne(fetch = FetchType.LAZY, cascade = CascadeType.ALL)
    @JoinColumn(name = "SCHEDULE_ID")
    private Schedule schedule;

    private String type;

    public Theme(Schedule schedule, String type){
        this.schedule = schedule;
        this.type = type;
    }
}

