package com.trip.waytrip.domain;

import com.trip.waytrip.dto.ScheduleDto;
import jakarta.annotation.Nullable;
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
    @Setter
    @ManyToOne(optional = false, fetch = FetchType.LAZY)
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
