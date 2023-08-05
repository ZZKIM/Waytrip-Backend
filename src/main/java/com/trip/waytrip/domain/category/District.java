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
public class District {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;

    @ManyToOne(fetch = FetchType.LAZY, cascade = CascadeType.ALL)
    @JoinColumn(name = "SCHEDULE_ID")
    private Schedule schedule;

    private String city;

    public District(Schedule schedule, String city){
        this.schedule = schedule;
        this.city = city;
    }
}
