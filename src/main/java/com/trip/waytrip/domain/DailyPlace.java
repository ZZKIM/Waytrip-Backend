package com.trip.waytrip.domain;

import com.trip.waytrip.dto.ScheduleDto;
import jakarta.persistence.*;
import lombok.*;

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
    @Setter
    @ManyToOne
    private Place place;

    public void addMemo(Memo memo){
        memos.add(memo);
    }
}
