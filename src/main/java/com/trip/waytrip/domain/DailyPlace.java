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
public class DailyPlace {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne(optional = false)
    private DailySchedule dailySchedule;

    //@JoinColumn
    @OneToMany(mappedBy = "dailyPlace", cascade = CascadeType.ALL)
    private List<Memo> memos = new ArrayList<>();

    @ManyToOne
    private Place place;
}
